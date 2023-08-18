package hiiragi283.api.material

import hiiragi283.material.config.RMConfig
import hiiragi283.material.util.HiiragiColor

/**
 * @author MrKono
 * @author turtton
 */
object MaterialElements {

    //    1st Period    //

    @JvmField
    val HYDROGEN = materialOf("hydrogen", 1) {
        color = HiiragiColor.BLUE.rgb
        formula = "H"
        molar = 1.0
        tempBoil = 20
        tempMelt = 14
    }

    @JvmField
    val HELIUM = materialOf("helium", 2) {
        color = HiiragiColor.YELLOW.rgb
        formula = "He"
        molar = 4.0
        tempBoil = 3
        tempMelt = 1
    }

    //    2nd Period    //

    @JvmField
    val LITHIUM = materialOf("lithium", 3) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Li"
        molar = 6.9
        tempBoil = 1560
        tempMelt = 454
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val BERYLLIUM = materialOf("beryllium", 4) {
        color = HiiragiColor.DARK_GREEN.rgb
        crystalType = CrystalType.METAL
        formula = "Be"
        molar = 9.0
        tempBoil = 2742
        tempMelt = 1560
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val BORON = materialOf("boron", 5) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "B"
        molar = 10.8
        tempBoil = 4200
        tempMelt = 2349
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CARBON = materialOf("carbon", 6) {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK, HiiragiColor.DARK_GRAY).rgb
        formula = "C"
        molar = 12.0
        //tempBoil = 4300
        //tempMelt = 4000
        tempSubl = 3915
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val NITROGEN = materialOf("nitrogen", 7) {
        color = HiiragiColor.AQUA.rgb
        formula = "N"
        molar = 14.0
        tempBoil = 77
        tempMelt = 63
    }

    @JvmField
    val OXYGEN = materialOf("oxygen", 8) {
        formula = "O"
        molar = 16.0
        tempBoil = 90
        tempMelt = 54
    }

    @JvmField
    val FLUORINE = materialOf("fluorine", 9) {
        color = HiiragiColor.GREEN.rgb
        formula = "F"
        molar = 19.0
        tempBoil = 85
        tempMelt = 54
    }

    @JvmField
    val NEON = materialOf("neon", 10) {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Ne"
        molar = 20.2
        tempBoil = 27
        tempMelt = 25
    }

    //    3rd Period    //

    @JvmField
    val SODIUM = materialOf("sodium", 11) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 1, HiiragiColor.BLUE to 4).rgb
        crystalType = CrystalType.METAL
        formula = "Na"
        molar = 23.0
        tempBoil = 1156
        tempMelt = 371
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val MAGNESIUM = materialOf("magnesium", 12) {
        color = HiiragiColor.mixColor(HiiragiColor.LIGHT_PURPLE, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Mg"
        molar = 24.3
        tempBoil = 1363
        tempMelt = 923
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ALUMINIUM = materialOf("aluminium", 13) {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.WHITE to 5).rgb
        crystalType = CrystalType.METAL
        formula = "Al"
        molar = 27.0
        oreDictAlt = mutableListOf("aluminum")
        tempBoil = 2792
        tempMelt = 933
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val SILICON = materialOf("silicon", 14) {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 2, HiiragiColor.GRAY to 1, HiiragiColor.BLUE to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Si"
        molar = 28.1
        tempBoil = 3538
        tempMelt = 1687
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PHOSPHORUS = materialOf("phosphorus", 15) {
        color = HiiragiColor.YELLOW.rgb
        formula = "P"
        molar = 31.0
        tempBoil = 550
        tempMelt = 317
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val SULFUR = materialOf("sulfur", 16) {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.YELLOW).rgb
        formula = "S"
        molar = 32.1
        tempBoil = 718
        tempMelt = 388
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CHLORINE = materialOf("chlorine", 17) {
        color = HiiragiColor.YELLOW.rgb
        formula = "Cl"
        molar = 35.5
        tempBoil = 239
        tempMelt = 171
    }

    @JvmField
    val ARGON = materialOf("argon", 18) {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Ar"
        molar = 40.0
        tempBoil = 87
        tempMelt = 84
    }

    //    4th Period    //

    @JvmField
    val POTASSIUM = materialOf("potassium", 19) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 2, HiiragiColor.BLUE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "K"
        molar = 39.1
        tempBoil = 1032
        tempMelt = 337
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val CALCIUM = materialOf("calcium", 20) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ca"
        molar = 40.1
        tempBoil = 1757
        tempMelt = 1115
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val SCANDIUM = materialOf("scandium", 21) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sc"
        molar = 45.0
        tempBoil = 3109
        tempMelt = 1814
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TITANIUM = materialOf("titanium", 22) {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Ti"
        molar = 47.9
        tempBoil = 3560
        tempMelt = 1941
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val VANADIUM = materialOf("vanadium", 23) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "V"
        molar = 50.9
        tempBoil = 3680
        tempMelt = 2183
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val CHROMIUM = materialOf("chromium", 24) {
        color = HiiragiColor.GREEN.rgb
        crystalType = CrystalType.METAL
        formula = "Cr"
        molar = 52.0
        oreDictAlt = mutableListOf("chrome")
        tempBoil = 2944
        tempMelt = 2180
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val MANGANESE = materialOf("manganese", 25) {
        color = HiiragiColor.mixColor(HiiragiColor.RED, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Mn"
        molar = 54.9
        tempBoil = 2334
        tempMelt = 1519
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val IRON = materialOf("iron", 26) {
        color = HiiragiColor.mixColor(HiiragiColor.GRAY to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Fe"
        molar = 55.8
        tempBoil = 3134
        tempMelt = 1811
        validShapes.addAll(MaterialType.METAL_ADVANCED)
        if (RMConfig.MATERIAL.disableVanillaParts) {
            validShapes.remove("block")
            validShapes.remove("ingot")
            validShapes.remove("nugget")
        }
    }

    @JvmField
    val COBALT = materialOf("cobalt", 27) {
        color = HiiragiColor.BLUE.rgb
        crystalType = CrystalType.METAL
        formula = "Co"
        molar = 58.9
        tempBoil = 3200
        tempMelt = 1768
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val NICKEL = materialOf("nickel", 28) {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Ni"
        molar = 58.7
        tempBoil = 3186
        tempMelt = 1728
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val COPPER = materialOf("copper", 29) {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.RED).rgb
        crystalType = CrystalType.METAL
        formula = "Cu"
        molar = 63.5
        tempBoil = 2835
        tempMelt = 1358
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val ZINC = materialOf("zinc", 30) {
        color = HiiragiColor.mixColor(HiiragiColor.GREEN to 1, HiiragiColor.WHITE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Zn"
        molar = 65.4
        tempBoil = 1180
        tempMelt = 693
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val GALLIUM = materialOf("gallium", 31) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ga"
        molar = 69.7
        tempBoil = 2673
        tempMelt = 303
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val GERMANIUM = materialOf("germanium", 32) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ge"
        molar = 72.6
        tempBoil = 3106
        tempMelt = 1211
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ARSENIC = materialOf("arsenic", 33) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "As"
        molar = 74.9
        //tempBoil = 887
        //tempMelt = 1090
        tempSubl = 887
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val SELENIUM = materialOf("selenium", 34) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Se"
        molar = 74.9
        tempBoil = 958
        tempMelt = 453
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val BROMINE = materialOf("bromine", 35) {
        color = HiiragiColor.GOLD.rgb
        formula = "Br"
        molar = 79.9
        tempBoil = 332
        tempMelt = 267
    }

    @JvmField
    val KRYPTON = materialOf("krypton", 36) {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Kr"
        molar = 83.8
        tempBoil = 120
        tempMelt = 116
    }

    //    5th Period    //

    @JvmField
    val RUBIDIUM = materialOf("rubidium", 37) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 3, HiiragiColor.BLUE to 2).rgb
        crystalType = CrystalType.METAL
        formula = "Rb"
        molar = 85.5
        tempBoil = 961
        tempMelt = 312
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val STRONTIUM = materialOf("strontium", 38) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sr"
        molar = 87.6
        tempBoil = 1655
        tempMelt = 1050
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val YTTRIUM = materialOf("yttrium", 39) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Y"
        molar = 88.9
        tempBoil = 3609
        tempMelt = 1799
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ZIRCONIUM = materialOf("zirconium", 40) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Zr"
        molar = 91.2
        tempBoil = 4682
        tempMelt = 2128
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val NIOBIUM = materialOf("niobium", 41) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Nb"
        molar = 92.9
        tempBoil = 5017
        tempMelt = 2750
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val MOLYBDENUM = materialOf("molybdenum", 42) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Mo"
        molar = 96.0
        tempBoil = 4912
        tempMelt = 2896
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TECHNETIUM = materialOf("technetium", 43) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tc"
        //molar = 97.0/98.0/99.0
        tempBoil = 4538
        tempMelt = 2430
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val RUTHENIUM = materialOf("ruthenium", 44) {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.LIGHT_PURPLE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Ru"
        molar = 101.1
        tempBoil = 4423
        tempMelt = 2607
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val RHODIUM = materialOf("rhodium", 45) {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.RED to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Rh"
        molar = 102.9
        tempBoil = 3968
        tempMelt = 2237
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PALLADIUM = materialOf("palladium", 46) {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.YELLOW to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Pd"
        molar = 106.4
        tempBoil = 3236
        tempMelt = 1828
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val SILVER = materialOf("silver", 47) {
        color = HiiragiColor.mixColor(HiiragiColor.AQUA to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Ag"
        molar = 107.9
        tempBoil = 2435
        tempMelt = 1235
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val CADMIUM = materialOf("cadmium", 48) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Cd"
        molar = 112.4
        tempBoil = 1040
        tempMelt = 594
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val INDIUM = materialOf("indium", 49) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "In"
        molar = 114.8
        tempBoil = 2345
        tempMelt = 430
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TIN = materialOf("tin", 50) {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.AQUA to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Sn"
        molar = 118.7
        tempBoil = 2875
        tempMelt = 505
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val ANTIMONY = materialOf("antimony", 51) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sb"
        molar = 121.8
        tempBoil = 1860
        tempMelt = 904
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TELLURIUM = materialOf("tellurium", 52) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Te"
        molar = 127.6
        tempBoil = 1261
        tempMelt = 723
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val IODINE = materialOf("iodine", 53) {
        color = HiiragiColor.DARK_PURPLE.rgb
        formula = "I"
        molar = 126.9
        tempBoil = 457
        tempMelt = 387
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val XENON = materialOf("xenon", 54) {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Xe"
        molar = 131.3
        tempBoil = 165
        tempMelt = 161
    }

    //    6th Period    //

    @JvmField
    val CAESIUM = materialOf("caesium", 55) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE to 4, HiiragiColor.BLUE to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Cs"
        molar = 132.9
        tempBoil = 944
        tempMelt = 302
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val BARIUM = materialOf("barium", 56) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ba"
        molar = 137.3
        tempBoil = 2170
        tempMelt = 1000
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Lanthanides Start    //

    @JvmField
    val LANTHANUM = materialOf("lanthanum", 57) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "La"
        molar = 138.9
        tempBoil = 3737
        tempMelt = 1193
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val CERIUM = materialOf("cerium", 58) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ce"
        molar = 140.1
        tempBoil = 3716
        tempMelt = 1068
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PRASEODYMIUM = materialOf("praseodymium", 59) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Pr"
        molar = 140.9
        tempBoil = 3793
        tempMelt = 1208
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val NEODYMIUM = materialOf("neodymium", 60) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Nd"
        molar = 144.2
        tempBoil = 3347
        tempMelt = 1297
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PROMETHIUM = materialOf("promethium", 61) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Pm"
        //molar = 145.0
        tempBoil = 3237
        tempMelt = 1315
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val SAMARIUM = materialOf("samarium", 62) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Sm"
        molar = 150.4
        tempBoil = 2067
        tempMelt = 1345
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val EUROPIUM = materialOf("europium", 63) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Eu"
        molar = 152.0
        tempBoil = 1802
        tempMelt = 1099
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val GADOLINIUM = materialOf("gadolinium", 64) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Gd"
        molar = 157.3
        tempBoil = 3546
        tempMelt = 1585
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TERBIUM = materialOf("terbium", 65) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tb"
        molar = 158.9
        tempBoil = 3503
        tempMelt = 1629
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val DYSPROSIUM = materialOf("dysprosium", 66) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Dy"
        molar = 157.3
        tempBoil = 2840
        tempMelt = 1680
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val HOLMIUM = materialOf("holmium", 67) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ho"
        molar = 164.9
        tempBoil = 2993
        tempMelt = 1734
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ERBIUM = materialOf("erbium", 68) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Er"
        molar = 167.3
        tempBoil = 3141
        tempMelt = 1802
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val THULIUM = materialOf("thulium", 69) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tm"
        molar = 168.9
        tempBoil = 2223
        tempMelt = 1818
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val YTTERBIUM = materialOf("ytterbium", 70) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Yb"
        molar = 173.0
        tempBoil = 1469
        tempMelt = 1097
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val LUTETIUM = materialOf("lutetium", 71) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Lu"
        molar = 175.0
        tempBoil = 3675
        tempMelt = 1925
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Lanthanides End    //

    @JvmField
    val HAFNIUM = materialOf("hafnium", 72) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Hf"
        molar = 178.5
        tempBoil = 4876
        tempMelt = 2506
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TANTALUM = materialOf("tantalum", 73) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ta"
        molar = 180.9
        tempBoil = 5731
        tempMelt = 3290
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val TUNGSTEN = materialOf("tungsten", 74) {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 2, HiiragiColor.DARK_GRAY to 1).rgb
        crystalType = CrystalType.METAL
        formula = "W"
        molar = 183.8
        tempBoil = 5828
        tempMelt = 3695
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val RHENIUM = materialOf("rhenium", 75) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Re"
        molar = 186.2
        tempBoil = 5869
        tempMelt = 3459
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val OSMIUM = materialOf("osmium", 76) {
        color = HiiragiColor.mixColor(HiiragiColor.BLUE to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Os"
        molar = 190.2
        tempBoil = 5285
        tempMelt = 3306
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val IRIDIUM = materialOf("iridium", 77) {
        color = HiiragiColor.mixColor(HiiragiColor.AQUA to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Ir"
        molar = 192.2
        tempBoil = 4701
        tempMelt = 2719
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val PLATINUM = materialOf("platinum", 78) {
        color = HiiragiColor.mixColor(HiiragiColor.GREEN to 1, HiiragiColor.WHITE to 3).rgb
        crystalType = CrystalType.METAL
        formula = "Pt"
        molar = 195.1
        tempBoil = 4098
        tempMelt = 2041
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val GOLD = materialOf("gold", 79) {
        color = HiiragiColor.mixColor(HiiragiColor.GOLD, HiiragiColor.YELLOW).rgb
        crystalType = CrystalType.METAL
        formula = "Au"
        molar = 197.0
        tempBoil = 3129
        tempMelt = 1337
        validShapes.addAll(MaterialType.METAL_ADVANCED)
        if (RMConfig.MATERIAL.disableVanillaParts) {
            validShapes.remove("block")
            validShapes.remove("ingot")
            validShapes.remove("nugget")
        }
    }

    @JvmField
    val MERCURY = materialOf("mercury", 80) {
        formula = "Hg"
        molar = 200.6
        tempBoil = 670
        tempMelt = 234
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val THALLIUM = materialOf("thallium", 81) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Tl"
        molar = 204.4
        tempBoil = 1749
        tempMelt = 577
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val LEAD = materialOf("lead", 82) {
        color = HiiragiColor.mixColor(HiiragiColor.DARK_BLUE, HiiragiColor.DARK_GRAY, HiiragiColor.WHITE).rgb
        crystalType = CrystalType.METAL
        formula = "Pb"
        molar = 207.2
        tempBoil = 2022
        tempMelt = 601
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val BISMUTH = materialOf("bismuth", 83) {
        color = HiiragiColor.AQUA.rgb
        crystalType = CrystalType.METAL
        formula = "Bi"
        molar = 209.0
        tempBoil = 1837
        tempMelt = 545
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val POLONIUM = materialOf("polonium", 84) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Po"
        //molar = 209.0/210.0
        tempBoil = 1235
        tempMelt = 527
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val ASTATINE = materialOf("astatine", 85) {
        color = HiiragiColor.BLACK.rgb
        formula = "At"
        //molar = 210.0
        tempBoil = 610
        tempMelt = 575
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val RADON = materialOf("radon", 86) {
        color = HiiragiColor.LIGHT_PURPLE.rgb
        formula = "Rn"
        //molar = 222.0
        tempBoil = 211
        tempMelt = 202
    }

    //    7th Period    //

    @JvmField
    val FRANCIUM = materialOf("francium", 87) {
        color = HiiragiColor.DARK_BLUE.rgb
        formula = "Fr"
        //molar = 223.0
        tempBoil = 890
        tempMelt = 281
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val RADIUM = materialOf("radium", 88) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ra"
        //molar = 226.0
        tempBoil = 2010
        tempMelt = 973
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    //    Actinides Start    //

    @JvmField
    val ACTINIUM = materialOf("actinium", 89) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Ac"
        //molar = 227.0
        tempBoil = 3471
        tempMelt = 1323
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val THORIUM = materialOf("thorium", 90) {
        color = HiiragiColor.mixColor(HiiragiColor.BLACK to 2, HiiragiColor.DARK_GREEN to 1, HiiragiColor.GRAY to 1).rgb
        crystalType = CrystalType.METAL
        formula = "Th"
        molar = 232.0
        tempBoil = 5061
        tempMelt = 2115
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PROTACTINIUM = materialOf("protactinium", 91) {
        color = HiiragiColor.GRAY.rgb
        crystalType = CrystalType.METAL
        formula = "Pa"
        molar = 231.0
        tempBoil = 4300
        tempMelt = 1841
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val URANIUM = materialOf("uranium", 92) {
        color = HiiragiColor.GREEN.rgb
        crystalType = CrystalType.METAL
        formula = "U"
        molar = 238.0
        tempBoil = 4404
        tempMelt = 1405
        validShapes.addAll(MaterialType.METAL_ADVANCED)
    }

    @JvmField
    val NEPTUNIUM = materialOf("neptunium", 93) {
        color = HiiragiColor.BLUE.rgb
        crystalType = CrystalType.METAL
        formula = "Np"
        //molar = 237.0
        tempBoil = 4273
        tempMelt = 917
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val PLUTONIUM = materialOf("plutonium", 94) {
        color = HiiragiColor.RED.rgb
        crystalType = CrystalType.METAL
        formula = "Pu244"
        molar = 244.1
        tempBoil = 3501
        tempMelt = 913
        validShapes.addAll(MaterialType.METAL_COMMON)
    }

    @JvmField
    val AMERICIUM = materialOf("americium", 95) {
        crystalType = CrystalType.METAL
        formula = "Am"
        //molar = 243.0
        tempBoil = 1880
        tempMelt = 1449
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CURIUM = materialOf("curium", 96) {
        crystalType = CrystalType.METAL
        formula = "Cm"
        //molar = 247.0
        tempBoil = 3383
        tempMelt = 1613
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val BERKELIUM = materialOf("berkelium", 97) {
        crystalType = CrystalType.METAL
        formula = "Bk"
        //molar = 247.0
        tempBoil = 2900
        tempMelt = 1259
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val CALIFORNIUM = materialOf("californium", 98) {
        crystalType = CrystalType.METAL
        formula = "Cf"
        //molar = 251.0/252.0
        tempBoil = 1743
        tempMelt = 1173
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val EINSTEINIUM = materialOf("einsteinium", 99) {
        crystalType = CrystalType.METAL
        formula = "Es"
        //molar = 252.0
        tempBoil = 1269
        tempMelt = 1133
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val FERMIUM = materialOf("fermium", 100) {
        crystalType = CrystalType.METAL
        formula = "Fm"
        //molar = 257.0
        //tempBoil =
        //tempMelt = 1125/1800
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val MENDELEVIUM = materialOf("mendelevium", 101) {
        crystalType = CrystalType.METAL
        formula = "Md"
        //molar = 258.0
        //tempBoil =
        //tempMelt = 1100
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val NOBELIUM = materialOf("nobelium", 102) {
        crystalType = CrystalType.METAL
        formula = "No"
        //molar = 259.0
        //tempBoil =
        //tempMelt = 1100
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val LAWRENCIUM = materialOf("lawrencium", 103) {
        crystalType = CrystalType.METAL
        formula = "Lr"
        //molar = 262.0/266.0
        //tempBoil =
        //tempMelt = 1900
        validShapes.addAll(MaterialType.SOLID)
    }

    //    Actinides End    //

    @JvmField
    val RUTHERFORDIUM = materialOf("rutherfordium", 104) {
        crystalType = CrystalType.METAL
        formula = "Lr"
        //molar = 261.1/267.0
        //tempBoil = 5800
        //tempMelt = 2400
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val DUBNIUM = materialOf("dubnium", 105) {
        crystalType = CrystalType.METAL
        formula = "Db"
        //molar = 265.0/268.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val SEABORGIUM = materialOf("seaborgium", 106) {
        crystalType = CrystalType.METAL
        formula = "Sg"
        //molar = 269.0/271.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val BOHRIUM = materialOf("bohrium", 107) {
        crystalType = CrystalType.METAL
        formula = "Bh"
        //molar = 270.0/272.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val HASSIUM = materialOf("hassium", 108) {
        crystalType = CrystalType.METAL
        formula = "Hs"
        //molar = 269.0/277.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val MEITNERIUM = materialOf("meitnerium", 109) {
        crystalType = CrystalType.METAL
        formula = "Mt"
        //molar = 276.0/278.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val DARMSTADTIUM = materialOf("darmstadtium", 110) {
        crystalType = CrystalType.METAL
        formula = "Ds"
        //molar = 281.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val ROENTGENIUM = materialOf("roentgenium", 111) {
        crystalType = CrystalType.METAL
        formula = "Rg"
        //molar = 280.0/281.0/282.0
        //tempBoil =
        //tempMelt =
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val COPERNICIUM = materialOf("copernicium", 112) {
        crystalType = CrystalType.METAL
        formula = "Cn"
        //molar = 285.0
        //tempBoil = 340
        //tempMelt = 283
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val NIHONIUM = materialOf("nihonium", 113) {
        crystalType = CrystalType.METAL
        formula = "Nh"
        //molar = 278.0/286.0
        //tempBoil = 1400
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val FLEROVIUM = materialOf("flerovium", 114) {
        crystalType = CrystalType.METAL
        formula = "Fl"
        //molar = 289.0
        //tempBoil =
        //tempMelt = 284
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val MOSCOVIUM = materialOf("moscovium", 115) {
        crystalType = CrystalType.METAL
        formula = "Mc"
        //molar = 289.0/290.0
        //tempBoil = 1400
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val LIVERMORIUM = materialOf("livermorium", 116) {
        crystalType = CrystalType.METAL
        formula = "Lv"
        //molar = 293.0
        //tempBoil = 1100
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val TENNESSINE = materialOf("tennessine", 117) {
        crystalType = CrystalType.METAL
        formula = "Ts"
        //molar = 293.0/294.0
        //tempBoil = 883
        //tempMelt = 700
        validShapes.addAll(MaterialType.SOLID)
    }

    @JvmField
    val OGANESSON = materialOf("oganesson", 118) {
        crystalType = CrystalType.METAL
        formula = "Og"
        //molar = 294.0
        //tempBoil = 450
        //tempMelt = 352
        validShapes.addAll(MaterialType.SOLID)
    }

    //    Isotope    //

    @JvmField
    val DEUTERIUM = isotopeOf("deuterium", 120, HYDROGEN) {
        formula = "D"
        molar = 2.0
    }

    @JvmField
    val TRITIUM = isotopeOf("tritium", 121, HYDROGEN) {
        formula = "T"
        molar = 3.0
    }

    @JvmField
    val URANIUM235 = isotopeOf("uranium235", 122, URANIUM) {
        formula = "U235"
        molar = 235.0
    }

    fun register(registry: MutableList<HiiragiMaterial>) {
        // --1st Period--
        registry.add(HYDROGEN)
        registry.add(HELIUM)
        // --2nd Period--
        registry.add(LITHIUM)
        registry.add(BERYLLIUM)
        registry.add(BORON)
        registry.add(CARBON)
        registry.add(NITROGEN)
        registry.add(OXYGEN)
        registry.add(FLUORINE)
        registry.add(NEON)
        // --3rd Period--
        registry.add(SODIUM)
        registry.add(MAGNESIUM)
        registry.add(ALUMINIUM)
        registry.add(SILICON)
        registry.add(PHOSPHORUS)
        registry.add(SULFUR)
        registry.add(CHLORINE)
        registry.add(ARGON)
        // --4th Period--
        registry.add(POTASSIUM)
        registry.add(CALCIUM)
        registry.add(SCANDIUM)
        registry.add(TITANIUM)
        registry.add(VANADIUM)
        registry.add(CHROMIUM)
        registry.add(MANGANESE)
        registry.add(IRON)
        registry.add(COBALT)
        registry.add(NICKEL)
        registry.add(COPPER)
        registry.add(ZINC)
        registry.add(GALLIUM)
        registry.add(GERMANIUM)
        registry.add(ARSENIC)
        registry.add(SELENIUM)
        registry.add(BROMINE)
        registry.add(KRYPTON)
        // --5th Period--
        registry.add(RUBIDIUM)
        registry.add(STRONTIUM)
        registry.add(YTTRIUM)
        registry.add(ZIRCONIUM)
        registry.add(NIOBIUM)
        registry.add(MOLYBDENUM)
        registry.add(TECHNETIUM)
        registry.add(RUTHENIUM)
        registry.add(RHODIUM)
        registry.add(PALLADIUM)
        registry.add(SILVER)
        registry.add(CADMIUM)
        registry.add(INDIUM)
        registry.add(TIN)
        registry.add(ANTIMONY)
        registry.add(TELLURIUM)
        registry.add(IODINE)
        registry.add(XENON)
        // --6th Period--
        registry.add(CAESIUM)
        registry.add(BARIUM)
        // --Lanthanides--
        if (RMConfig.MATERIAL.lanthanoides) {
            registry.add(LANTHANUM)
            registry.add(CERIUM)
            registry.add(PRASEODYMIUM)
            registry.add(NEODYMIUM)
            registry.add(PROMETHIUM)
            registry.add(SAMARIUM)
            registry.add(EUROPIUM)
            registry.add(GADOLINIUM)
            registry.add(TERBIUM)
            registry.add(DYSPROSIUM)
            registry.add(HOLMIUM)
            registry.add(ERBIUM)
            registry.add(THULIUM)
            registry.add(YTTERBIUM)
            registry.add(LUTETIUM)
        }
        registry.add(HAFNIUM)
        registry.add(TANTALUM)
        registry.add(TUNGSTEN)
        registry.add(RHENIUM)
        registry.add(OSMIUM)
        registry.add(IRIDIUM)
        registry.add(PLATINUM)
        registry.add(GOLD)
        registry.add(MERCURY)
        registry.add(THALLIUM)
        registry.add(LEAD)
        registry.add(BISMUTH)
        registry.add(POLONIUM)
        registry.add(ASTATINE)
        registry.add(RADON)
        // --7th Period--
        registry.add(FRANCIUM)
        registry.add(RADIUM)
        // --Actinides Start--
        registry.add(ACTINIUM)
        registry.add(THORIUM)
        registry.add(PROTACTINIUM)
        registry.add(URANIUM)
        registry.add(NEPTUNIUM)
        registry.add(PLUTONIUM)
        if (RMConfig.MATERIAL.transUran) {
            registry.add(AMERICIUM)
            registry.add(CURIUM)
            registry.add(BERKELIUM)
            registry.add(CALIFORNIUM)
            registry.add(EINSTEINIUM)
            registry.add(FERMIUM)
            registry.add(MENDELEVIUM)
            registry.add(NOBELIUM)
            registry.add(LAWRENCIUM)
            // --Actinides End--
            registry.add(RUTHERFORDIUM)
            registry.add(DUBNIUM)
            registry.add(SEABORGIUM)
            registry.add(BOHRIUM)
            registry.add(HASSIUM)
            registry.add(MEITNERIUM)
            registry.add(DARMSTADTIUM)
            registry.add(ROENTGENIUM)
            registry.add(COPERNICIUM)
            registry.add(NIHONIUM)
            registry.add(FLEROVIUM)
            registry.add(MOSCOVIUM)
            registry.add(LIVERMORIUM)
            registry.add(TENNESSINE)
            registry.add(OGANESSON)
        }
        // --Isotope--
        registry.add(DEUTERIUM)
        registry.add(TRITIUM)
        registry.add(URANIUM235)
    }
}