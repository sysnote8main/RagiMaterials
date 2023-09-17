package hiiragi283.material.block

import hiiragi283.material.api.block.HiiragiBlockContainer
import hiiragi283.material.api.item.HiiragiItemBlock
import hiiragi283.material.api.recipe.IMachineRecipe
import hiiragi283.material.api.registry.HiiragiRegistries
import hiiragi283.material.api.tile.HiiragiTileEntity
import hiiragi283.material.api.tile.TileEntityModuleMachine
import hiiragi283.material.item.ItemBlockModuleMachine
import hiiragi283.material.util.HiiragiNBTKey
import hiiragi283.material.util.getTile
import hiiragi283.material.util.setModelSame
import net.minecraft.block.BlockHorizontal
import net.minecraft.block.material.Material
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.color.BlockColors
import net.minecraft.client.renderer.color.ItemColors
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.*
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.RayTraceResult
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class BlockModuleMachine(val type: IMachineRecipe.Type) : HiiragiBlockContainer.Holdable<TileEntityModuleMachine>(
    Material.IRON,
    "machine_${type.name.lowercase()}",
    { TileEntityModuleMachine() }
) {

    override val itemBlock: HiiragiItemBlock = ItemBlockModuleMachine(this)

    init {
        defaultState = defaultState.withProperty(BlockHorizontal.FACING, EnumFacing.NORTH)
        HiiragiRegistries.MODULE_MACHINE.register(type, this)
    }

    //    HiiragiBlockContainer.Holdable    //

    override fun getDrops(
        drops: NonNullList<ItemStack>,
        world: IBlockAccess,
        pos: BlockPos,
        state: IBlockState,
        fortune: Int
    ) {
        drops.add(getStackWithTileNBT(world, pos, getItemStack(getTile<TileEntityModuleMachine>(world, pos)?.material)))
    }

    override fun getPickBlock(
        state: IBlockState,
        target: RayTraceResult,
        world: World,
        pos: BlockPos,
        player: EntityPlayer
    ): ItemStack = getStackWithTileNBT(world, pos, getItemStack(getTile<TileEntityModuleMachine>(world, pos)?.material))

    override fun <T : HiiragiTileEntity> getTileNBT(tile: T): NBTTagCompound =
        NBTTagCompound().also { tag: NBTTagCompound ->
            tag.setTag(
                HiiragiNBTKey.MACHINE_PROPERTY,
                super.getTileNBT(tile).getCompoundTag(HiiragiNBTKey.MACHINE_PROPERTY)
            )
        }

    //    BlockState    //

    override fun createBlockState(): BlockStateContainer = BlockStateContainer(this, BlockHorizontal.FACING)

    override fun getMetaFromState(state: IBlockState): Int = state.getValue(BlockHorizontal.FACING).horizontalIndex

    override fun getStateForPlacement(
        world: World,
        pos: BlockPos,
        facing: EnumFacing,
        hitX: Float,
        hitY: Float,
        hitZ: Float,
        meta: Int,
        placer: EntityLivingBase,
        hand: EnumHand
    ): IBlockState = defaultState.withProperty(BlockHorizontal.FACING, placer.horizontalFacing.opposite)


    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "defaultState.withProperty(BlockHorizontal.FACING, EnumFacing.byHorizontalIndex(meta))",
            "net.minecraft.block.BlockHorizontal",
            "net.minecraft.util.EnumFacing"
        )
    )
    override fun getStateFromMeta(meta: Int): IBlockState =
        defaultState.withProperty(BlockHorizontal.FACING, EnumFacing.byHorizontalIndex(meta))

    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "state.withRotation(mirrorIn.toRotation(state.getValue(BlockHorizontal.FACING)))",
            "net.minecraft.block.BlockHorizontal"
        )
    )
    override fun withMirror(state: IBlockState, mirrorIn: Mirror): IBlockState =
        state.withRotation(mirrorIn.toRotation(state.getValue(BlockHorizontal.FACING)))

    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "state.withProperty(BlockHorizontal.FACING, rot.rotate(state.getValue(BlockHorizontal.FACING)))",
            "net.minecraft.block.BlockHorizontal",
            "net.minecraft.block.BlockHorizontal"
        )
    )
    override fun withRotation(state: IBlockState, rot: Rotation): IBlockState =
        state.withProperty(BlockHorizontal.FACING, rot.rotate(state.getValue(BlockHorizontal.FACING)))

    //    HiiragiEntry    //

    @SideOnly(Side.CLIENT)
    override fun registerBlockColor(blockColors: BlockColors) {
        blockColors.registerBlockColorHandler({ _: IBlockState?, world: IBlockAccess?, pos: BlockPos?, _: Int ->
            getTile<TileEntityModuleMachine>(world, pos)?.material?.color ?: -1
        }, this)
    }

    @SideOnly(Side.CLIENT)
    override fun registerItemColor(itemColors: ItemColors) {
        itemColors.registerItemColorHandler({ stack: ItemStack, tintIndex: Int ->
            if (tintIndex == 0) HiiragiRegistries.MATERIAL_INDEX.getValue(stack.metadata)?.color ?: -1 else -1
        }, this)
    }

    @SideOnly(Side.CLIENT)
    override fun registerModel() {
        this.setModelSame()
    }

}