package hiiragi283.material.api.shape

import hiiragi283.material.api.item.ItemMaterial
import hiiragi283.material.api.material.HiiragiMaterial
import hiiragi283.material.util.RMModelManager
import net.minecraft.client.resources.I18n
import rechellatek.snakeToLowerCamelCase
import kotlin.math.roundToInt

fun shapeOf(name: String, scale: Double, init: HiiragiShape.() -> Unit = {}): HiiragiShape {
    val shape = HiiragiShape(name, scale)
    shape.init()
    return shape
}

class HiiragiShape internal constructor(val name: String, val scale: Double) {

    var model: (ItemMaterial) -> Unit = { RMModelManager.setModelSame(it) }
    var recipe: (ItemMaterial, HiiragiMaterial) -> Unit = { _, _ -> }

    var translationKey: String = "shape.$name"
    var translatedName: (HiiragiMaterial) -> String = { I18n.format(translationKey, it.translatedName) }

    companion object {
        @JvmField
        val EMPTY = HiiragiShape("empty", 0.0)
    }

    fun isEmpty(): Boolean = this.name == "empty"

    fun getOreDict(material: HiiragiMaterial): String = StringBuilder().also {
        it.append(name.snakeToLowerCamelCase())
        it.append(material.getOreDictName())
    }.toString()

    fun getOreDictAlt(material: HiiragiMaterial): String =
        if (material.hasOreDictAlt()) StringBuilder().also {
            it.append(name.snakeToLowerCamelCase())
            it.append(material.getOreDictNameAlt())
        }.toString() else ""

    fun getOreDicts(material: HiiragiMaterial): List<String> =
        listOf(getOreDict(material), getOreDictAlt(material)).filter(String::isNotEmpty)

    fun getWeight(material: HiiragiMaterial): Double = (material.molar * scale * 10.0).roundToInt() / 10.0

    fun hasScale(): Boolean = scale > 0.0

    fun isValid(material: HiiragiMaterial): Boolean = name in material.validShapes

}