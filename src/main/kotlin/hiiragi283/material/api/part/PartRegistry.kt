package hiiragi283.material.api.part

import hiiragi283.material.common.RagiMaterials
import hiiragi283.material.common.util.*
import net.devtech.arrp.json.blockstate.JState
import net.devtech.arrp.json.models.JModel
import net.devtech.arrp.json.recipe.JIngredients
import net.devtech.arrp.json.recipe.JKeys
import net.devtech.arrp.json.recipe.JRecipe

object PartRegistry {

    private val REGISTRY: HashMap<String, HiiragiPart> = hashMapOf()

    @JvmStatic
    fun getParts(): Collection<HiiragiPart> = REGISTRY.values

    @JvmStatic
    fun getPart(name: String) = REGISTRY.getOrDefault(name, HiiragiPart.EMPTY)

    @JvmStatic
    fun registerPart(part: HiiragiPart) {
        //EMPTYを渡された場合はパス
        if (part == HiiragiPart.EMPTY) return
        val name = part.name
        //名前が空の場合はパス
        if (name.isEmpty()) {
            RagiMaterials.LOGGER.warn("The name of $part is empty!")
            return
        }
        val resultName = REGISTRY[name]
        //同じ名前で登録されていた場合，登録せずに警告を表示する
        if (resultName !== null) {
            RagiMaterials.LOGGER.warn("The name of $part was already registered by $resultName!")
            return
        }
        //重複しなかった場合のみ登録を行う
        REGISTRY[name] = part
    }

    //    Parts    //

    private val ingotFake = HiiragiPart.Builder("@_ingots", 1.0).build()
    private val gemFake = HiiragiPart.Builder("@_gems", 1.0).build()

    //    Parts - Block   //

    @JvmField
    val BLOCK_METAL = HiiragiPart.Builder("@_blocks", 9.0).build {
        model = JModel.model().parent(hiiragiId("item/metal_block").toString())
        predicate = { it.isSolid() && it.isMetal() }
        recipes = {
            mapOf(
                this.getId(it).append("_shaped") to JRecipe.shaped(
                    get3x3('A'),
                    JKeys.keys().addTag("A", ingotFake.getTag(it).toString()),
                    this.getResult(it)
                )
            )
        }
        state = JState.state(
            JState.variant(
                JState.model(
                    hiiragiId("block/metal_block")
                )
            )
        )
        type = PartType.BLOCK
    }

    @JvmField
    val BLOCK_GEM = HiiragiPart.Builder("@_blocks", 9.0).build {
        predicate = { it.isSolid() && it.isGem() }
        recipes = {
            mapOf(
                this.getId(it).append("_shaped") to JRecipe.shaped(
                    get3x3('A'),
                    JKeys.keys().addTag("A", gemFake.getTag(it).toString()),
                    this.getResult(it)
                )
            )
        }
        type = PartType.BLOCK
    }


    @JvmField
    val ORE = HiiragiPart.Builder("@_ores", 1.0).build {
        type = PartType.BLOCK
    }

    @JvmField
    val ORE_BLOCK = HiiragiPart.Builder("raw_@_blocks", 9.0).build {
        type = PartType.BLOCK
    }

    //    Parts - Item   //

    @JvmField
    val DUST = HiiragiPart.Builder("@_dusts", 1.0).build {
        model = itemModelLayered { layer0("minecraft:item/sugar") }
        predicate = { it.isSolid() }
    }

    @JvmField
    val DUST_TINY = HiiragiPart.Builder("@_tiny_dusts", 0.1).build {
        model = itemModelLayered { layer0("minecraft:item/sugar") }
        predicate = { it.isSolid() }
    }

    @JvmField
    val GEAR = HiiragiPart.Builder("@_gears", 4.0).build {
        model = itemModelLayered { layer0("ragi_materials:item/gear") }
        predicate = { it.isSolid() && it.type.hasGear }
    }

    @JvmField
    val GEM = HiiragiPart.Builder("@_gems", 1.0).build {
        predicate = { it.isGem() }
    }

    @JvmField
    val INGOT = HiiragiPart.Builder("@_ingots", 1.0).build {
        predicate = { it.isSolid() && it.isMetal() }
        recipes = {
            mapOf(
                this.getId(it).append("_shaped") to JRecipe.shaped(
                    get3x3('A'),
                    JKeys.keys().addTag("A", NUGGET.getTag(it).toString()),
                    this.getResult(it)
                ),
                this.getId(it).append("_shapeless") to JRecipe.shapeless(
                    JIngredients.ingredients().addTag(BLOCK_METAL.getTag(it).toString()),
                    this.getResult(it, 9)
                )
            )
        }
    }

    @JvmField
    val NUGGET = HiiragiPart.Builder("@_nuggets", 0.1).build {
        model = itemModelLayered { layer0("minecraft:item/iron_nugget") }
        predicate = { it.isSolid() && it.isMetal() }
        recipes = {
            mapOf(
                this.getId(it).append("_shapeless") to JRecipe.shapeless(
                    JIngredients.ingredients().addTag(ingotFake.getTag(it).toString()),
                    this.getResult(it, 9)
                )
            )
        }
    }

    @JvmField
    val PLATE = HiiragiPart.Builder("@_plates", 1.0).build {
        model = itemModelLayered { layer0("ragi_materials:item/plate") }
        predicate = { it.isSolid() && it.type.hasPlate }
    }

    @JvmField
    val RAW_ORE = HiiragiPart.Builder("raw_@_ores", 1.0).build()

    @JvmField
    val ROD = HiiragiPart.Builder("@_rods", 0.5).build {
        model = itemModelLayered { layer0("ragi_materials:item/rod") }
        predicate = { it.isSolid() && it.type.hasRod }
    }

    fun load() {
        //Block Parts
        registerPart(BLOCK_METAL)
        //registerPart(BLOCK_GEM)
        //registerPart(ORE)
        //registerPart(ORE_BLOCK)
        //Item Parts
        registerPart(DUST)
        //registerPart(DUST_TINY)
        registerPart(GEAR)
        //registerPart(GEM)
        registerPart(INGOT)
        registerPart(NUGGET)
        registerPart(PLATE)
        //registerPart(RAW_ORE)
        registerPart(ROD)
    }

}