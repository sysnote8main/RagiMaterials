package hiiragi283.api.block

import hiiragi283.api.HiiragiEntry
import hiiragi283.material.RMCreativeTabs
import hiiragi283.material.RMReference
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.item.Item
import java.util.*

abstract class HiiragiBlock(material: Material, id: String) : Block(material), HiiragiEntry.BLOCK {

    init {
        creativeTab = RMCreativeTabs.COMMON
        setRegistryName(RMReference.MOD_ID, id)
        translationKey = id
    }

    //    Block    //

    override fun getItemDropped(state: IBlockState, rand: Random, fortune: Int): Item = asItem()

}