package hiiragi283.api.material

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.minecraft.client.resources.I18n
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry
import rechellatek.snakeToUpperCamelCase

/**
 * An object which contains several properties of material
 *
 * Should be registered in [net.minecraftforge.event.RegistryEvent.Register]<[HiiragiMaterial]>
 *
 *   === Index Range ===
 *
 *            <= -1 ... Not registered
 *
 *          1 ~ 118 ... Periodic Table
 *
 *        120 ~ 199 ... Isotopes
 *
 *      1000 ~ 1900 ... Integration for other mods
 *
 *    10010 ~ 11899 ... Compounds: 1 + Atomic Number + Index
 *
 *         >= 32768 ... Not registered
 *
 * @param name should be unique
 * @param index follows above format
 * @param color see also [hiiragi283.material.util.RagiColor], [hiiragi283.material.util.ColorUtil]
 * @param crystalType see also [CrystalType]
 * @param formula empty value will be ignored
 * @param molar 0 or less value will be ignored
 * @param oreDictAlt a list of alternative Ore Dictionary names: aluminum, chrome, saltpeter, ...
 * @param tempBoil boiling point with kelvin Temperature, 0 or less will be ignored
 * @param tempMelt melting point with kelvin Temperature, 0 or less will be ignored
 * @param tempSubl sublimation point with kelvin Temperature, 0 or less will be ignored
 * @param translationKey can be overridden
 */

@Serializable
data class HiiragiMaterial internal constructor(
    val name: String,
    val index: Int,
    var color: Int = 0xFFFFFF,
    var crystalType: CrystalType = CrystalType.NONE,
    var formula: String = "",
    var molar: Double = -1.0,
    var oreDictAlt: MutableList<String> = mutableListOf(),
    var tempBoil: Int = -1,
    var tempMelt: Int = -1,
    var tempSubl: Int = -1,
    var translationKey: String = "material.$name"
) {

    /**
     * a set of shape names that is acceptable to this material
     */
    val validShapes: MutableSet<String> = MaterialType.INTERNAL.toSortedSet()

    companion object {
        @JvmField
        val EMPTY = HiiragiMaterial("empty", -1)

        @JvmField
        val UNKNOWN = formulaOf("?")

        private val pretty = Json { prettyPrint = true }

        /**
         * Converts [String] with JSON format into [HiiragiMaterial]
         * @return a new material
         */
        @JvmStatic
        fun fromJson(json: String): HiiragiMaterial = Json.decodeFromString(json)

    }

    /**
     * Adds bracket to chemical formula
     *
     * Example:  "H2O" -> "(H2O)"
     */
    fun addBracket(): HiiragiMaterial = copy(formula = "($formula)")

    fun getFluid(): Fluid = FluidRegistry.getFluid(name) ?: FluidRegistry.WATER

    /**
     * Converts material name with UCC format
     *
     * Example: "sulfuric_acid" -> "SulfuricAcid"
     */
    fun getOreDictName(): String = name.snakeToUpperCamelCase()

    /**
     * Converts [oreDictAlt] with UCC format
     * @return a new list of Ore Dictionary names
     */
    fun getOreDictNameAlt(): List<String> = oreDictAlt.map { it.snakeToUpperCamelCase() }

    /**
     * Gets the standard state of this material
     * @return [MaterialState.GAS], [MaterialState.LIQUID], [MaterialState.SOLID]
     */
    fun getState(): MaterialState {
        //沸点が有効かつ298 K以下 -> 標準状態で気体
        if (hasTempBoil() && tempBoil <= 298) return MaterialState.GAS
        //融点が有効かつ298以下 -> 標準状態で液体
        if (hasTempMelt() && tempMelt <= 298) return MaterialState.LIQUID
        //それ以外は固体として扱う
        return MaterialState.SOLID
    }

    fun getTranslatedName(): String = I18n.format(translationKey)

    /**
     * Returns true if [oreDictAlt] is not empty
     * @see [Collection.isNotEmpty]
     */
    fun hasOreDictAlt(): Boolean = oreDictAlt.isNotEmpty()

    fun hasFluid(): Boolean = FluidRegistry.isFluidRegistered(name)

    /**
     * Returns true if [formula] is not empty
     * @see [String.isNotEmpty]
     */
    fun hasFormula(): Boolean = formula.isNotEmpty()

    /**
     * Returns true if [molar] is bigger than 0.0
     */
    fun hasMolar(): Boolean = molar > 0.0

    /**
     * Returns true if [tempBoil] is 0 or more
     */
    fun hasTempBoil(): Boolean = tempBoil >= 0

    /**
     * Returns true if [tempMelt] is 0 or more
     */
    fun hasTempMelt(): Boolean = tempMelt >= 0

    /**
     * Returns true if [tempSubl] is 0 or more
     */
    fun hasTempSubl(): Boolean = tempSubl >= 0

    /**
     * Returns true if [name] equals "empty"
     */
    fun isEmpty(): Boolean = this.name == "empty"

    /**
     * Returns true if [CrystalType.isCrystal] is true and [isMetal] is false
     * @see [CrystalType]
     */
    fun isGem(): Boolean = crystalType.isCrystal && !isMetal()

    /**
     * Returns true if [crystalType] equals [CrystalType.METAL]
     * @see [CrystalType]
     */
    fun isMetal(): Boolean = crystalType == CrystalType.METAL

    /**
     * Returns true if standard state of this material is [MaterialState.GAS]
     * @see [getState]
     */
    fun isGas(): Boolean = getState() == MaterialState.GAS

    /**
     * Returns true if standard state of this material is [MaterialState.LIQUID]
     * @see [getState]
     */
    fun isLiquid(): Boolean = getState() == MaterialState.LIQUID

    /**
     * Returns true if standard state of this material is [MaterialState.SOLID]
     * @see [getState]
     */
    fun isSolid(): Boolean = getState() == MaterialState.SOLID

    /**
     * Converts [HiiragiMaterial] into JSON format
     * @return JSON-formatted String
     */
    fun toJson(isPretty: Boolean): String = if (isPretty) pretty.encodeToString(this) else Json.encodeToString(this)

    //    General    //

    override fun toString(): String = "Material:${this.name}"

}