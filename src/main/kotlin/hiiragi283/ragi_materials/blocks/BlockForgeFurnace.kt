package hiiragi283.ragi_materials.blocks

import hiiragi283.ragi_materials.Reference
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.properties.PropertyInteger
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.util.IStringSerializable
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