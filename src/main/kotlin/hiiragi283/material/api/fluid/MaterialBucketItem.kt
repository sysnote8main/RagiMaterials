package hiiragi283.material.api.fluid

import hiiragi283.material.api.HiiragiEntry
import hiiragi283.material.api.material.HiiragiMaterial
import hiiragi283.material.api.part.IHiiragiPart
import hiiragi283.material.common.RagiMaterials
import hiiragi283.material.common.RagiResourcePack
import hiiragi283.material.common.util.commonId
import hiiragi283.material.common.util.hiiragiId
import hiiragi283.material.common.util.itemModelLayered
import net.devtech.arrp.json.tags.JTag
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.fluid.Fluid
import net.minecraft.item.BucketItem
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class MaterialBucketItem(fluid: Fluid, val material: HiiragiMaterial) : BucketItem(fluid, FabricItemSettings()),
    HiiragiEntry, IHiiragiPart.ITEM {

    override fun getName(stack: ItemStack): Text =
        TranslatableText("item.ragi_materials.material_bucket", material.getTranslatedName())

    //    HiiragiEntry    //

    override val identifier: Identifier
        get() = hiiragiId("${material.name}_buckets")

    private val model = itemModelLayered {
        layer0("minecraft:item/bucket")
        layer1("ragi_materials:item/bucket_layer")
    }

    override fun register() {
        Registry.register(Registry.ITEM, identifier, this)
        RagiMaterials.LOGGER.debug("The bucket item ${identifier.path} registered!")

        RagiResourcePack.addItemModel(identifier, model)

        RagiResourcePack.addItemTag(commonId(identifier.path), JTag().add(identifier))
    }

    //    IHiiragiPart    //

    override fun getColor(stack: ItemStack, tintIndex: Int): Int = if (tintIndex == 1) material.color else -1

}