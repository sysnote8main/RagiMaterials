package hiiragi283.ragi_materials.material.builder

import hiiragi283.ragi_materials.material.type.TypeRegistry

class AlloyBuilder(index: Int, name: String, components: Map<MaterialBuilder, Int>) : CompoundBuilder(index, name, TypeRegistry.METAL, components) {

    init {
        setBoil()
        setMelt()
    }

    private fun setBoil() {
        //変数の宣言
        var tempBoil = 0
        var divideBoil = 0
        val components = this.components
        //components内の各keyに対して実行
        for (key in components.keys) {
            //沸点がnullでない場合
            key.tempBoil?.let {
                tempBoil += it * components.getValue(key)
                divideBoil += components.getValue(key)
            }
        }
        //沸点の平均値をとる
        tempBoil /= divideBoil
        this.tempBoil = tempBoil
    }

    private fun setMelt() {
        //変数の宣言
        var tempMelt = 0
        var divideMelt = 0
        val components = this.components
        //components内の各keyに対して実行
        for (key in components.keys) {
            //融点がnullでない場合
            key.tempMelt?.let {
                tempMelt += it * components.getValue(key)
                divideMelt += components.getValue(key)
            }
        }
        //融点の平均値をとる
        tempMelt /= divideMelt
        this.tempMelt = tempMelt
    }
}