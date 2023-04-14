package hiiragi283.ragi_materials.container

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.inventory.Container
import net.minecraft.inventory.Slot
import net.minecraft.tileentity.TileEntity

abstract class ContainerBase<T : TileEntity>(val player: EntityPlayer, open val tile: TileEntity) : Container() {

    val invPlayer: InventoryPlayer = player.inventory

    fun initSlotsPlayer(posY: Int) {
        //プレイヤーのインベントリのスロットを設定
        for (y in 0..2) {
            for (x in 0..8) {
                addSlotToContainer(Slot(invPlayer, x + y * 9 + 9, 8 + x * 18, y * 18 + posY))
            }
        }
        //プレイヤーのホットバーのスロットを設定
        for (x in 0..8) {
            addSlotToContainer(Slot(invPlayer, x, 8 + x * 18, 3 * 18 + (posY + 4)))
        }
    }

}