package hiiragi283.material.api.item

import hiiragi283.material.api.HiiragiEntry
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

abstract class HiiragiItem(private val modid: String, id: String, private var maxMeta: Int) : Item(), HiiragiEntry.ITEM {

    init {
        setRegistryName(modid, id)
        creativeTab = CreativeTabs.MISC
        hasSubtypes = maxMeta > 0
        maxMeta = 0.coerceAtLeast(maxMeta)
        translationKey = id
    }

    //    General    //

    override fun getCreatorModId(stack: ItemStack): String = modid

    override fun getMetadata(damage: Int): Int = if (damage in 0..maxMeta) damage else maxMeta

    override fun getTranslationKey(stack: ItemStack): String = StringBuilder().also {
        it.append(super.getTranslationKey())
        it.append("_")
        it.append(stack.metadata)
    }.toString()

    //    Client    //

    @SideOnly(Side.CLIENT)
    override fun getSubItems(tab: CreativeTabs, subItems: NonNullList<ItemStack>) {
        if (isInCreativeTab(tab)) {
            (0..maxMeta).forEach {
                subItems.add(ItemStack(this, 1, it))
            }
        }
    }

}