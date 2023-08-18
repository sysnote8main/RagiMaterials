package hiiragi283.integration.jei

import hiiragi283.api.item.ICastItem
import hiiragi283.api.material.HiiragiMaterial
import hiiragi283.api.material.MaterialRegistry
import hiiragi283.api.material.MaterialStack
import hiiragi283.api.part.HiiragiPart
import hiiragi283.api.recipe.CrushingRecipe
import hiiragi283.api.registry.HiiragiRegistry
import hiiragi283.api.shape.ShapeRegistry
import hiiragi283.integration.jei.ingredients.HiiragiIngredientTypes
import hiiragi283.integration.jei.ingredients.MaterialStackHelper
import hiiragi283.integration.jei.ingredients.MaterialStackRenderer
import hiiragi283.material.RMBlocks
import hiiragi283.material.RMItems
import hiiragi283.material.RMReference
import hiiragi283.material.RagiMaterials
import mezz.jei.api.IModPlugin
import mezz.jei.api.IModRegistry
import mezz.jei.api.JEIPlugin
import mezz.jei.api.ingredients.IModIngredientRegistration
import mezz.jei.api.recipe.IRecipeCategoryRegistration
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.ForgeRegistries

const val CRUCIBLE = "${RMReference.MOD_ID}.crucible"
const val CRUCIBLE_HEAT = "${RMReference.MOD_ID}.crucible_heat"
const val CRUSHING = "${RMReference.MOD_ID}.crushing"
const val MATERIAL = "${RMReference.MOD_ID}.material"

@JEIPlugin
class JEIIntegration : IModPlugin {

    init {
        RagiMaterials.LOGGER.info("Enabled Integration: JEI / HEI")
    }

    override fun registerCategories(registry: IRecipeCategoryRegistration) {
        val guiHelper = registry.jeiHelpers.guiHelper
        registry.addRecipeCategories(
            CrucibleCategory(guiHelper),
            CrushingCategory(guiHelper),
            HeatSourceCategory(guiHelper),
            HiiragiMaterialCategory(guiHelper)
        )
    }

    override fun register(registry: IModRegistry) {
        //Crucible
        registry.handleRecipes(CrucibleRecipe::class.java, { it }, CRUCIBLE)
        registry.addRecipes(getCrucibleRecipes(), CRUCIBLE)
        registry.addRecipeCatalyst(ItemStack(RMBlocks.CRUCIBLE), CRUCIBLE)
        //Crucible - Heat Source
        registry.handleRecipes(HeatSourceRecipe::class.java, { it }, CRUCIBLE_HEAT)
        registry.addRecipes(HiiragiRegistry.HEAT_SOURCE.map { HeatSourceRecipe(it.key, it.value) }, CRUCIBLE_HEAT)
        registry.addRecipeCatalyst(ItemStack(Items.LAVA_BUCKET), CRUCIBLE_HEAT)
        //Crushing
        registry.handleRecipes(CrushingRecipe::class.java, { it }, CRUSHING)
        registry.addRecipes(HiiragiRegistry.CRUSHING.valuesCollection, CRUSHING)
        registry.addRecipeCatalyst(ItemStack(RMItems.CRUSHING_HAMMER), CRUSHING)
        //HiiragiMaterial
        registry.handleRecipes(HiiragiMaterialRecipe::class.java, { it }, MATERIAL)
        registry.addRecipes(getHiiragiMaterialRecipes(), MATERIAL)
        registry.addRecipeCatalyst(ItemStack(RMItems.MATERIAL_BOTTLE, 1, Short.MAX_VALUE.toInt()), MATERIAL)
    }

    override fun registerIngredients(registry: IModIngredientRegistration) {
        registry.register(
            HiiragiIngredientTypes.MATERIAL,
            MaterialRegistry.getMaterials().map { it.toMaterialStack() },
            MaterialStackHelper,
            MaterialStackRenderer,
        )
    }

    private fun getCrucibleRecipes(): Collection<CrucibleRecipe> {
        return ForgeRegistries.ITEMS.valuesCollection
            .filterIsInstance<ICastItem>() //ICastItemを実装しているItemのみ
            .flatMap { item ->
                MaterialRegistry.getMaterials()
                    .filter { it.hasTempMelt() } //融点をもつ素材のみ
                    .map { MaterialStack(it, item.getMaterialAmount()) }
                    .filterNot { item.getResult(it).isEmpty } //完成品がEMPTYでないレシピのみ
                    .map { CrucibleRecipe(it, ItemStack(item.getCastItem()), item.getResult(it)) }
            }
    }

    private fun getHiiragiMaterialRecipes(): Collection<HiiragiMaterialRecipe> {
        val ret: MutableList<HiiragiMaterialRecipe> = mutableListOf()
        for (material: HiiragiMaterial in MaterialRegistry.getMaterials()) {
            val items: List<ItemStack> = ShapeRegistry.getShapes()
                .map { HiiragiPart(it, material) }
                .flatMap { it.getAllItemStack() }
            ret.add(HiiragiMaterialRecipe(material.toMaterialStack(), items))
        }
        return ret
    }

}