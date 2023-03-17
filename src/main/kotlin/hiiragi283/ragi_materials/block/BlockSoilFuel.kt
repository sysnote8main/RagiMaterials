package hiiragi283.ragi_materials.block

import hiiragi283.ragi_materials.base.BlockBase
import hiiragi283.ragi_materials.item.IMaterialItem
import hiiragi283.ragi_materials.material.MaterialUtil
import hiiragi283.ragi_materials.material.builder.MaterialBuilder
import hiiragi283.ragi_materials.material.part.PartRegistry
import net.minecraft.block.IGrowable
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyInteger
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.NonNullList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import java.util.*

abstract class BlockSoilFuel(ID: String): BlockBase(ID, Material.GROUND, 2), IGrowable, IMaterialBlock, IMaterialItem {

    init {
        blockHardness = 0.5f
        blockResistance = 0.5f
        defaultState = blockState.baseState.withProperty(getProperty(), 0)
        soundType = SoundType.GROUND
        tickRandomly = true
    }

    //    General    //

    override fun getDrops(drops: NonNullList<ItemStack>, world: IBlockAccess, pos: BlockPos, state: IBlockState, fortune: Int) {
        if (world is World && !world.isRemote) {
            val random = world.rand
            if (isMaxAge(state)) {
                drops.add(MaterialUtil.getPart(PartRegistry.CRYSTAL, getDropMain(), 4))
            } else {
                drops.add(ItemStack(this))
            }
            if (random.nextInt(3) <= fortune) {
                drops.add(MaterialUtil.getPart(PartRegistry.CRYSTAL, getDropAdd()))
                if (fortune >= 4) {
                    drops.add(MaterialUtil.getPart(PartRegistry.CRYSTAL, getDropAdd(), fortune - 3))
                }
            }
        }
    }

    abstract fun getDropMain(): MaterialBuilder

    abstract fun getDropAdd(): MaterialBuilder

    //    BlockState    //

    override fun createBlockState(): BlockStateContainer = BlockStateContainer(this, getProperty())

    override fun getMetaFromState(state: IBlockState): Int = state.getValue(getProperty())

    @Deprecated("Deprecated in Java", ReplaceWith("this.defaultState.withProperty(getProperty(), meta)"))
    override fun getStateFromMeta(meta: Int): IBlockState = this.defaultState.withProperty(getProperty(), meta)

    abstract fun getProperty(): PropertyInteger

    fun getAge(state: IBlockState): Int = state.getValue(getProperty())

    fun getAgeMax(state: IBlockState): Int = getProperty().allowedValues.last()

    private fun isMaxAge(state: IBlockState) = getAge(state) == getAgeMax(state)

    //    Event    //

    override fun updateTick(world: World, pos: BlockPos, state: IBlockState, rand: Random) {
        if (canGrow(world, pos, state, false)) grow(world, rand, pos, state)
        val biome = world.getBiome(pos)
        //バイオームが水系の場合
        if (biome in getAllowedBiomes()) {
            for (facing in EnumFacing.values()) {
                val posTo = pos.offset(facing)
                val stateTo = world.getBlockState(posTo)
                //隣接するブロックの種類がGROUNDまたはGRASSの場合，それを侵食する
                if (stateTo.material in listOf(Material.GROUND, Material.GRASS)) {
                    world.setBlockState(posTo, this.defaultState, 2)
                }
            }
        }
    }

    abstract fun getAllowedBiomes(): List<Biome>

    //    IGrowable    //

    override fun canGrow(world: World, pos: BlockPos, state: IBlockState, isClient: Boolean): Boolean {
        val list: MutableList<Boolean> = mutableListOf()
        for (facing in EnumFacing.values()) {
            list.add(world.isAirBlock(pos.offset(facing)))
        }
        return !list.contains(true) //各面が空気に触れていない場合，成長可能
    }

    override fun canUseBonemeal(world: World, rand: Random, pos: BlockPos, state: IBlockState): Boolean = false

    override fun grow(world: World, rand: Random, pos: BlockPos, state: IBlockState) {
        if (canGrow(world, pos, state, false) && !isMaxAge(state)) world.setBlockState(pos, state.withProperty(getProperty(), getAge(state) + 1), 2)
    }

    //    IMaterialBLock    //

    abstract override fun getMaterialBlock(world: IBlockAccess, pos: BlockPos, state: IBlockState): MaterialBuilder

    //    IMaterialItem    //

    abstract override fun getMaterial(stack: ItemStack): MaterialBuilder

    override fun setMaterial(stack: ItemStack, material: MaterialBuilder): ItemStack = stack

}