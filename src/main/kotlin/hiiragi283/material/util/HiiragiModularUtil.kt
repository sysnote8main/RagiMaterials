package hiiragi283.material.util

import com.cleanroommc.modularui.ModularUI
import com.cleanroommc.modularui.drawable.UITexture
import com.cleanroommc.modularui.value.sync.FluidSlotSyncHandler
import com.cleanroommc.modularui.widgets.slot.ModularSlot
import hiiragi283.api.capability.fluid.HiiragiFluidTank
import hiiragi283.api.capability.item.HiiragiItemHandler
import hiiragi283.material.RMReference
import net.minecraftforge.fluids.IFluidTank
import net.minecraftforge.items.IItemHandler

object HiiragiModularUtil {

    @JvmField
    val LOGO: UITexture = UITexture.builder()
        .location(RMReference.MOD_ID, "logo")
        .imageSize(512, 512)
        .build()

    @JvmField
    var PROGRESS_ARROW_INVERTED: UITexture = UITexture.builder()
        .location(ModularUI.ID, "gui/widgets/progress_bar_arrow_inverted")
        .imageSize(20, 40)
        .build()

    fun itemSlot(handler: HiiragiItemHandler, index: Int) = ModularSlot(handler as IItemHandler, index)

    fun phantomItemSlot(handler: HiiragiItemHandler, index: Int) = ModularSlot(handler as IItemHandler, index, true)

    fun itemSlotOut(handler: HiiragiItemHandler, index: Int) = ModularSlotOut(handler, index)

    fun fluidSlot(tank: HiiragiFluidTank) = FluidSlotSyncHandler(tank as IFluidTank)

}