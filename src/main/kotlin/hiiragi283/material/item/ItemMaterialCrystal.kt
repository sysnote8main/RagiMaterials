package hiiragi283.material.item

import hiiragi283.material.RagiMaterials
import hiiragi283.material.material.MaterialRegistry
import hiiragi283.material.material.type.EnumCrystalType
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

object ItemMaterialCrystal : ItemMaterial("gem") {

    @SideOnly(Side.CLIENT)
    override fun registerModel() {

        ModelLoader.registerItemVariants(
            this,
            ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_coal", "inventory"),
            ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_cubic", "inventory"),
            ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_diamond", "inventory"),
            ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_emerald", "inventory"),
            ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_lapis", "inventory"),
            ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_quartz", "inventory"),
            ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_ruby", "inventory")
        )
        ModelLoader.setCustomMeshDefinition(this) { stack ->
            var result = ModelResourceLocation("${RagiMaterials.MOD_ID}:crystal_cubic", "inventory")
            val item = stack.item
            if (item is ItemMaterial) {
                val material = MaterialRegistry.getMaterial(stack)
                if (material.crystalType != EnumCrystalType.NONE) result =
                    ModelResourceLocation(
                        "${RagiMaterials.MOD_ID}:crystal_${material.crystalType.texture}",
                        "inventory"
                    )
            }
            result
        }
    }

}