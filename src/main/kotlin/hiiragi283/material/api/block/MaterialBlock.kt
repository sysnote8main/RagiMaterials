package hiiragi283.material.api.block

import hiiragi283.material.api.HiiragiBlock
import hiiragi283.material.api.item.MaterialBlockItem
import hiiragi283.material.api.part.HiiragiPart
import hiiragi283.material.common.RagiResourcePack
import net.devtech.arrp.json.tags.JTag
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.client.color.block.BlockColorProvider
import net.minecraft.client.color.item.ItemColorProvider
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockRenderView

abstract class MaterialBlock : HiiragiBlock(FabricBlockSettings.of(Material.METAL)), BlockColorProvider,
    ItemColorProvider {

    companion object {

        @JvmStatic
        fun of(part: HiiragiPart): MaterialBlock {

            val identifier: Identifier = part.getId()
            val material = part.material
            val shape = part.shape
            val tag: Identifier = part.getTadId()

            val block = object : MaterialBlock() {

                override fun getIdentifier(): Identifier = identifier

                override fun getColor(state: BlockState, view: BlockRenderView?, pos: BlockPos?, tintIndex: Int): Int =
                    shape.blockColor(material).getColor(state, view, pos, tintIndex)

                override fun getColor(stack: ItemStack, tintIndex: Int): Int =
                    shape.itemColor(material).getColor(stack, tintIndex)

            }

            block.register()
            MaterialBlockItem.of(material, shape, block).register()

            RagiResourcePack.addBlockState(identifier, shape.state)
            shape.recipes(material).forEach(RagiResourcePack::addRecipe)
            val jTag = JTag().add(identifier)
            RagiResourcePack.addBlockTag(tag, jTag)
            RagiResourcePack.addItemTag(tag, jTag)

            return block
        }

    }

}