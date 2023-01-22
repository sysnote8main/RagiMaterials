package hiiragi283.ragi_materials.blocks

import hiiragi283.ragi_materials.Reference
import hiiragi283.ragi_materials.init.RagiInit
import hiiragi283.ragi_materials.util.RagiUtils
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.properties.PropertyInteger
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.IStringSerializable
import net.minecraft.util.SoundCategory
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.common.registry.ForgeRegistries
import java.util.*

class BlockForgeFurnace : Block(Material.ROCK) {

    //private変数の宣言
    companion object {
        private val propertyFire = PropertyEnum.create("state", PropertyState::class.java)
        private val propertyFuel = PropertyInteger.create("fuel", 0, 3)
    }

    private val maxMeta = 8
    private val registryName = "forge_furnace"

    //コンストラクタの初期化
    init {
        this.setCreativeTab(CreativeTabs.DECORATIONS)
        defaultState =
            blockState.baseState.withProperty(propertyFire, PropertyState.EXTINGUISH).withProperty(propertyFuel, 0)
        setRegistryName(Reference.MOD_ID, registryName)
        unlocalizedName = registryName.toString()
        ForgeRegistries.BLOCKS.register(this)
    }

    //Blockstateの登録をするメソッド
    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, propertyFire, propertyFuel)
    }

    //Blockstateからメタデータを得るメソッド
    override fun getMetaFromState(state: IBlockState): Int {
        val stateFire = state.getValue(propertyFire)
        val stateFuel = state.getValue(propertyFuel)
        val stateMeta = when (stateFire) {
            PropertyState.EXTINGUISH -> when (stateFuel) {
                1 -> 1
                2 -> 2
                3 -> 3
                else -> 0
            }

            PropertyState.BURNING -> when (stateFuel) {
                1 -> 4
                2 -> 5
                3 -> 6
                else -> 0
            }

            PropertyState.BLASTING -> 7
        }
        return stateMeta
    }

    //メタデータからBlockstateを得るメソッド
    override fun getStateFromMeta(meta: Int): IBlockState {
        val state = when (meta) {
            0 -> this.defaultState
            1 -> blockState.baseState.withProperty(propertyFire, PropertyState.EXTINGUISH).withProperty(propertyFuel, 1)
            2 -> blockState.baseState.withProperty(propertyFire, PropertyState.EXTINGUISH).withProperty(propertyFuel, 2)
            3 -> blockState.baseState.withProperty(propertyFire, PropertyState.EXTINGUISH).withProperty(propertyFuel, 3)
            4 -> blockState.baseState.withProperty(propertyFire, PropertyState.BURNING).withProperty(propertyFuel, 1)
            5 -> blockState.baseState.withProperty(propertyFire, PropertyState.BURNING).withProperty(propertyFuel, 2)
            6 -> blockState.baseState.withProperty(propertyFire, PropertyState.BURNING).withProperty(propertyFuel, 3)
            7 -> blockState.baseState.withProperty(propertyFire, PropertyState.BLASTING).withProperty(propertyFuel, 3)
            else -> this.defaultState
        }
        return state
    }

    //Blockstateをもとにドロップするアイテムのメタデータを指定するメソッド
    override fun damageDropped(state: IBlockState): Int {
        val stateFire = state.getValue(propertyFire)
        val stateFuel = state.getValue(propertyFuel)
        val stateMeta = when (stateFire) {
            PropertyState.EXTINGUISH -> when (stateFuel) {
                1 -> 1
                2 -> 2
                3 -> 3
                else -> 0
            }

            PropertyState.BURNING -> when (stateFuel) {
                1 -> 4
                2 -> 5
                3 -> 6
                else -> 0
            }

            PropertyState.BLASTING -> 7
        }
        return stateMeta
    }

    //ドロップするアイテムを得るメソッド
    override fun getItemDropped(state: IBlockState, rand: Random, fortune: Int): Item {
        //Blockstateからブロックを取得し、更にそこからアイテムを取得して返す
        return Item.getItemFromBlock(state.block)
    }

    //ドロップする確率を得るメソッド
    override fun quantityDropped(random: Random): Int {
        //常にドロップさせるので1を返す
        return 1
    }

    //ブロックを右クリックした時に呼ばれるメソッド
    override fun onBlockActivated(
        world: World,
        pos: BlockPos,
        state: IBlockState,
        player: EntityPlayer,
        hand: EnumHand,
        facing: EnumFacing,
        hitX: Float,
        hitY: Float,
        hitZ: Float
    ): Boolean {
        //プレイヤーが利き手に持っているアイテムを取得
        val stack: ItemStack = player.getHeldItem(hand)
        val item = stack.item
        setFuel(world, pos, state, stack) //燃料を投入
        setFire(world, pos, state, player, stack) //着火
        setBlasting(world, pos, state, player, stack) //火力UP
        return true
    }

    //燃料を投入するメソッド
    private fun setFuel(world: World, pos: BlockPos, state: IBlockState, stack: ItemStack) {
        //ブロックに蓄えられた燃料の量を取得
        val fuel = state.getValue(propertyFuel)
        //手持ちのアイテムが燃料，かつブロックに蓄えられた燃料が3未満の場合
        if (stack.item == Items.COAL && fuel < 3) {
            world.setBlockState(
                pos,
                blockState.baseState.withProperty(propertyFire, state.getValue(propertyFire))
                    .withProperty(propertyFuel, fuel + 1)
            ) //燃料を投入する
            world.playSound(null, pos, RagiUtils.getSound("minecraft:block.gravel.place"), SoundCategory.BLOCKS, 1.0f, 0.5f) //SEを再生
            stack.shrink(1) //手持ちの燃料を1つ減らす
        }
    }

    //着火するメソッド
    private fun setFire(world: World, pos: BlockPos, state: IBlockState, player: EntityPlayer, stack: ItemStack) {
        //消火状態，かつ燃料が1つ以上の場合
        if (state.getValue(propertyFire) == PropertyState.EXTINGUISH && state.getValue(propertyFuel) > 0)
        //ファイアーチャージの場合
            if (stack.item == Items.FIRE_CHARGE) {
                world.setBlockState(
                    pos,
                    blockState.baseState.withProperty(propertyFire, PropertyState.BURNING)
                        .withProperty(propertyFuel, state.getValue(propertyFuel))
                ) //着火
                world.playSound(null, pos, RagiUtils.getSound("minecraft:item.firecharge.use"), SoundCategory.BLOCKS, 1.0f, 1.0f) //SEを再生
                stack.shrink(1) //手持ちの火種を1つ減らす
            }
            //火打石の場合
            else if (stack.item == Items.FLINT_AND_STEEL) {
                world.setBlockState(
                    pos,
                    blockState.baseState.withProperty(propertyFire, PropertyState.BURNING)
                        .withProperty(propertyFuel, state.getValue(propertyFuel))
                ) //着火
                world.playSound(null, pos, RagiUtils.getSound("minecraft:item.flintandsteel.use"), SoundCategory.BLOCKS, 1.0f, 1.0f) //SEを再生
                stack.damageItem(1, player)//耐久値を1つ減らす
            }
    }

    //ふいごで火力を上げるメソッド
    private fun setBlasting(world: World, pos: BlockPos, state: IBlockState, player: EntityPlayer, stack: ItemStack) {
        //着火済み，かつ燃料が満タンの場合
        if (state.getValue(propertyFire) == PropertyState.BURNING && state.getValue(propertyFuel) == 3) {
            //手持ちのアイテムがふいごの場合
            if(stack.item == RagiInit.ItemToolBellow) {
                world.setBlockState(
                    pos,
                    blockState.baseState.withProperty(propertyFire, PropertyState.BLASTING)
                        .withProperty(propertyFuel, 3)
                ) //火力UP
                world.playSound(null, pos, RagiUtils.getSound("minecraft:entity.blaze.shoot"), SoundCategory.BLOCKS, 1.0f, 0.5f) //SEを再生
                stack.damageItem(1, player)//耐久値を1つ減らす
            }
        }
    }

    /*
      Thanks to TeamCofh!
      Source: https://github.com/CoFH/ThermalFoundation-1.12-Legacy/blob/1.12/src/main/java/cofh/thermalfoundation/block/BlockOre.java
    */
    enum class PropertyState(private val state: String) : IStringSerializable {
        EXTINGUISH("extinguish"), BURNING("burning"), BLASTING("blasting");

        override fun getName(): String {
            return this.state
        }
    }

}