package intelliractive.hp_printer

import org.bukkit.ChatColor
import org.bukkit.block.Block
import org.bukkit.Material
import org.bukkit.Material.*
import org.bukkit.Material.GRAY_TERRACOTTA
import java.io.ByteArrayInputStream
import org.bukkit.Material.COBWEB as web
import  org.bukkit.Material.SNOW as snow
import org.bukkit.Material.GRASS_BLOCK as grass

import org.bukkit.Material.RED_CONCRETE as rc
import org.bukkit.Material.WHITE_CONCRETE as wc
import org.bukkit.Material.GRAY_CONCRETE as gc
import org.bukkit.Material.GREEN_CONCRETE as grc
import org.bukkit.Material.YELLOW_CONCRETE as yc
import org.bukkit.Material.BLACK_CONCRETE as bc
import org.bukkit.Material.ORANGE_CONCRETE as oc
import org.bukkit.Material.BROWN_CONCRETE as brc
import org.bukkit.Material.LIGHT_BLUE_CONCRETE as lbc
import org.bukkit.Material.BLUE_CONCRETE as blc
import org.bukkit.Material.LIME_CONCRETE as lc
import org.bukkit.Material.LIGHT_GRAY_CONCRETE as lgc

import org.bukkit.Material.WHITE_CONCRETE_POWDER as wcp
import org.bukkit.Material.BLACK_CONCRETE_POWDER as blackcp
import org.bukkit.Material.YELLOW_CONCRETE_POWDER as ycp
import org.bukkit.Material.ORANGE_CONCRETE_POWDER as ocp
import org.bukkit.Material.BROWN_CONCRETE_POWDER as bcp
import org.bukkit.Material.BLUE_CONCRETE_POWDER as blcp
import org.bukkit.Material.LIGHT_BLUE_CONCRETE_POWDER as lbcp
import org.bukkit.Material.GREEN_CONCRETE_POWDER as gcp
import org.bukkit.Material.LIME_CONCRETE_POWDER as lcp
import org.bukkit.Material.RED_CONCRETE_POWDER as rcp

import org.bukkit.Material.WHITE_WOOL as ww
import org.bukkit.Material.BLACK_WOOL as bw
import org.bukkit.Material.BROWN_WOOL as brw
import org.bukkit.Material.LIGHT_BLUE_WOOL as lbw
import org.bukkit.Material.BLUE_WOOL as blw
import org.bukkit.Material.RED_WOOL as rw
import org.bukkit.Material.LIME_WOOL as lw
import org.bukkit.Material.YELLOW_WOOL as yw
import org.bukkit.Material.GREEN_WOOL as gw
import org.bukkit.Material.PINK_WOOL as pw
import org.bukkit.Material.GRAY_WOOL as grayw
import org.bukkit.Material.LIGHT_GRAY_WOOL as lgrayw
import org.bukkit.Material.PURPLE_WOOL as ppw
import org.bukkit.Material.ORANGE_WOOL as ow

import org.bukkit.Material.BLUE_TERRACOTTA as bt
import org.bukkit.Material.LIGHT_BLUE_TERRACOTTA as lbt
import org.bukkit.Material.RED_TERRACOTTA as rt
import org.bukkit.Material.LIME_TERRACOTTA as lt
import org.bukkit.Material.YELLOW_TERRACOTTA as yt
import org.bukkit.Material.GREEN_TERRACOTTA as gt
import org.bukkit.Material.BLACK_TERRACOTTA as blkt
import org.bukkit.Material.BROWN_TERRACOTTA as brt
import org.bukkit.Material.WHITE_TERRACOTTA as wt
import org.bukkit.Material.ORANGE_TERRACOTTA as ot
import org.bukkit.Material.PINK_TERRACOTTA as pt
import org.bukkit.Material.GRAY_TERRACOTTA as grt
import org.bukkit.Material.LIGHT_GRAY_TERRACOTTA as lgt
import org.bukkit.Material.PURPLE_TERRACOTTA as ppt

import org.bukkit.Material.BIRCH_WOOD as birch

import org.bukkit.Material.OAK_LOG as oaklog

import org.bukkit.Material.STRIPPED_OAK_LOG as stroak

import org.bukkit.Material.DARK_OAK_PLANKS as dopl
import org.bukkit.Material.OAK_PLANKS as oak

import org.bukkit.Material.BRICKS as bricks
import org.bukkit.Material.BRICK_STAIRS as brst

import org.bukkit.Material.YELLOW_STAINED_GLASS as yglass
import org.bukkit.Material.LIGHT_GRAY_STAINED_GLASS as lgrayglass

enum class Picture(
    val title: String, val lines: List<List<Material>>, val subtitle: String = "", val mapId: Int,
    val materials: Set<Material> = lines.flatten().toSet()
) {
    HenInACoop(
        "A hen in a coop", listOf(
            listOf(stroak, lbc, lbcp, stroak, wt, wt, wt, wt, wt, wt),
            listOf(stroak, lbcp, lbc, stroak, wt, wt, rw, rw, wt, wt),
            listOf(wt, stroak, stroak, wt, wt, wt, ww, ww, ww, wt),
            listOf(wt, wt, wt, wt, wt, wt, ww, bw, ww, wt),
            listOf(wt, ww, ww, ww, ww, ww, ww, ww, yc, wt),
            listOf(ww, ww, ww, ww, ww, ww, ww, ww, ww, wt),
            listOf(brw, ww, ww, ww, ww, ww, ww, ww, ww, brw),
            listOf(brw, brw, ww, ww, ww, ww, ww, ww, brw, brw),
            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw),
            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw)
        ), mapId= 12
    ),
    PenguinInACoat(
        "A penguin in a coat", listOf(
            listOf(ww, ww, grayw, grayw, grayw, grayw, grayw, grayw, ww, ww),
            listOf(grayw, grayw, ww, ww, ww, ww, ww, ww, grayw, grayw),
            listOf(ww, ww, ww, ww, ww, ww, ww, ww, ww, ww),
            listOf(ww, bw, bw, ww, ww, ww, ww, bw, bw, ww),
            listOf(ww, bw, bw, ww, ww, ww, ww, bw, bw, ww),
            listOf(ww, ww, ww, ww, ww, ww, ww, ww, ww, ww),
            listOf(ww, ww, ww, yc, yc, yc, yc, ww, ww, ww),
            listOf(brw, ww, ww, ww, yc, yc, ww, ww, ww, brw),
            listOf(brw, brw, ww, ww, ww, ww, ww, ww, brw, brw),
            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw),
        ), "Not a horse ☻", 11
    ),
    TwoKTonsOfTNT(
        "250 thousand tons of TNT", listOf(
            listOf(wc, lbc, lbc, lbc, ww, ww, lbc, lbc, lbc, lbc),
            listOf(wc, lbc, ww, lbc, lbc, lbc, lbc, ww, lbc, lbc),
            listOf(wc, wc, wc, wc, wc, wc, wc, lgrayglass, lgrayglass, lgrayglass),
            listOf(wc, wc, lgc, lgc, lgc, wc, wc, wc, lgrayglass, lgrayglass),
            listOf(lbc, lgc, lgc, lgc, lbc, lbc, lbc, lbc, lbc, lbc),
            listOf(rc, wcp, lbc, lbc, rc, wcp, lbc, lbc, lbc, lbc),
            listOf(wcp, rc, lbc, lbc, wcp, rc, lbc, lbc, lbc, lbc),

            listOf(lbc, lgc, lgc, lgc, lbc, lbc, lbc, wt, lbc, wt),
            listOf(lbc, lgc, lgc, lgc, lbc, lbc, lbc, grt, lbc, blc),
            listOf(lw, lw, lw, lw, lw, lw, lw, lw, lw, lw),
        ), "${ChatColor.YELLOW}/!\\${ChatColor.RESET}", 6
    ),
    Cup(
        "Cup", listOf(
            listOf(ww, ww, ww, ww, ow, ww, ww, ww, ww, ww),
            listOf(ww, ww, ww, ww, ow, ww, ww, ow, ww, ww),
            listOf(ww, ww, ww, ow, ww, ww, ow, ww, ww, ww),
            listOf(ww, ww, ww, ow, ww, ow, ww, ww, ww, ww),
            listOf(ww, ww, ww, ww, ow, ww, ow, ww, ww, ww),

            listOf(lbt, ww, ww, ww, ww, ww, ww, ww, lbt, ww),
            listOf(lbt, lbt, ww, ww, ww, ww, ww, ww, lbt, lbt),
            listOf(lbt, lbt, lbt, lbt, lbt, lbt, lbt, lbt, ww, lbt),

            listOf(ww, lbt, lbt, lbt, lbt, lbt, lbt, lbt, lbt, ww),
            listOf(blw, blw, lbt, lbt, lbt, lbt, lbt, ww, blw, blw),
            listOf(lbt, blw, blw, blw, blw, blw, blw, blw, ww, lbt)
        ), "of ${ChatColor.GOLD}Java${ChatColor.RESET}?", 3
    ),
    VillageHouse(
        "Village house", listOf(
            listOf(lbw, lbw, lbw, lbw, lbw, lbw, lbw, lbw, lbw, lbw),
            listOf(lbw, wc, wc, lbw, lbw, lbw, lbw, lbw, lbw, lbw),
            listOf(lbw, wc, wc, lbw, lbw, lbw, oak, oak, oak, lbw),

            listOf(lbw, lbw, lbw, lbw, lbw, oak, oak, oak, oak, oak),
            listOf(lbw, lbw, lbw, lbw, oak, oak, oak, oak, oak, oak),
            listOf(lbw, lbw, lbw, lbw, lbw, stroak, wt, wt, wt, stroak),
            listOf(OAK_LEAVES, OAK_LEAVES, lbw, lbw, lbw, stroak, wt, GLASS, wt, stroak),
            listOf(oaklog, OAK_LEAVES, lbw, lbw, lbw, stroak, wt, GLASS, wt, stroak),
            listOf(
                oaklog,
                lbw,
                OAK_FENCE,
                OAK_FENCE,
                OAK_FENCE,
                stroak,
                MOSSY_COBBLESTONE,
                COBBLESTONE,
                COBBLESTONE,
                stroak
            ),
            listOf(DIRT, DIRT, grass, grass, grass, DIRT, DIRT, DIRT, DIRT, DIRT)
        ), mapId = 5
    ),

    /** #### This was the first one! */
    Cow(
        "Cow", listOf(
            listOf(ww, wc, wc, ww, lbw, ww, ww, lbw, yc, yc),
            listOf(wc, ww, wc, ww, lbw, ww, ww, lbw, yc, ycp),
            listOf(ww, wc, ww, lbw, lbw, ww, brt, lbw, lbw, yc),

            listOf(lbc, lbc, lbw, lbw, lbw, lbw, brt, lbw, lbw, lbw),
            listOf(lbc, lbc, lbc, lbc, lbw, lbw, wc, wc, birch, lbw),
            listOf(lbc, lbc, birch, birch, birch, birch, wc, bw, birch, lbw),

            listOf(lw, lw, birch, birch, birch, birch, birch, birch, birch, lbc),
            listOf(lw, birch, birch, birch, birch, birch, birch, birch, birch, lw),
            listOf(lc, lw, birch, birch, pw, lbc, birch, birch, lw, lc),

            listOf(lc, lc, bw, bw, lbc, lw, bw, bw, lc, lc),
        ), "Moo!", 0
    ),
    Beach(
        "Beach", listOf(
            listOf(ycp, yc, lbw, lbc, lbc, lbc, lbc, lbc, ww, ww),
            listOf(yc, yc, lbw, lbw, lbc, lbc, ww, ww, ww, ww),
            listOf(lbw, lbw, lbw, lbw, lbc, lbc, lbc, lbc, lbc, lbc),
            listOf(lbc, lbc, lbw, lbw, lbw, lbc, lbc, lbc, lbc, lbc),
            listOf(pt, pt, pt, pt, lbw, lbw, lbc, lbc, lbc, lbc),
            listOf(wc, lbc, lbc, lbc, lbw, lbw, lbw, lbc, lbc, lbc),
            listOf(wc, lbc, lbc, lbc, lbc, lbw, lbw, lbw, lbc, lbc),
            listOf(wc, oak, oak, lbc, lbc, lbw, lbw, lbw, lbc, lbc),
            listOf(ycp, ycp, ycp, ycp, lbcp, wcp, wcp, wcp, wcp, lbcp),
            listOf(ycp, ycp, ycp, ycp, lbcp, lbcp, lbcp, lbcp, lbcp, lbcp)
        ), mapId = 2
    ),
    Aquarium(
        "Aquarium", listOf(
            listOf(wc, lbc, lbc, lbc, lbc, lbc, lbc, lbc, lbc, blw),
            listOf(lbc, lbc, lbc, lbc, lbc, lbc, yw, yw, blcp, ocp),
            listOf(lbc, wcp, lbc, lbc, lbc, bw, yw, yw, bw, bw),
            listOf(lbc, lbc, lbc, lbc, wcp, lbc, yw, yw, bcp, ocp),
            listOf(lbc, lbc, wcp, lbc, lbc, lbc, lbc, oc, lbc, blw),
            listOf(lbc, lbc, lbc, lbc, lbc, lw, lbc, lbc, lbc, lbc),
            listOf(lbc, wcp, lbc, lbc, lbc, lbc, lw, lbc, lbc, lcp),
            listOf(lbc, rcp, rcp, wcp, lbc, lw, lbc, lbc, lcp, lcp),
            listOf(ocp, rcp, lbc, lbc, lbc, lbc, lw, lw, lcp, lcp),
            listOf(rcp, ocp, rcp, rcp, lbc, lbc, lbc, lw, lbc, lcp)
        ), mapId = 1
    ),
    WinterNight(
        "Winter night", listOf(
            listOf(wc, ww, ww, ww, wc, lbt, bt, bt, bt, web),
            listOf(wc, ww, ww, ww, wc, lbt, bt, bt, web, web),
            listOf(wc, ww, ww, ww, wc, lbt, bt, bt, web, bt),
            listOf(lbt, wc, wc, wc, lbt, lbt, bt, bt, brst, bt),
            listOf(lbt, lbt, lbt, lbt, lbt, bt, bt, bt, bricks, bt),
            listOf(bt, lbt, lbt, lbt, lbt, bt, dopl, dopl, dopl, dopl),
            listOf(bt, bt, bt, bt, bt, dopl, dopl, dopl, dopl, dopl),
            listOf(snow, bt, bt, bt, bt, bt, DARK_OAK_TRAPDOOR, yglass, yglass, yglass),// или дверь?
            listOf(snow, snow, snow, snow, bt, bt, DARK_OAK_TRAPDOOR, dopl, dopl, dopl),// или дверь?
            listOf(snow, snow, snow, snow, snow, snow, dopl, dopl, dopl, dopl)
        ), "One of such with the winds so cold", 4
    ),
    Burger(
        "A burger", listOf(
            listOf(yc, yc, yc, yc, yc, yc, yc, yc, yc, yc),
            listOf(yc, yc, yc, yc, yc, yc, yc, yc, yc, yc),
            listOf(ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp),
            listOf(ocp, wc, wc, ocp, wc, wc, ocp, ocp, wc, wc),
            listOf(rt, rt, rt, rt, rt, rt, rt, ocp, rt, rt),
            listOf(bcp, bcp, bcp, bcp, bcp, bcp, bcp, ocp, bcp, lw),
            listOf(lw, lw, lw, lw, lw, lw, lw, ocp, ocp, lw),
            listOf(lw, grc, gcp, ww, gcp, grc, gcp, ocp, ocp, gcp),
            listOf(yc, yc, yc, yc, yc, yc, ocp, yc, yc, yc),
            listOf(yc, yc, yc, yc, yc, yc, yc, yc, yc, yc),
        ), "M-m, cheeseburger", 7
    ),
    Roblox(
        "Roblox", listOf(
            listOf(gc, gc, gc, gc, gc, gc, gc, gc, gc, gc),
            listOf(gc, gc, gc, gc, wc, gc, gc, gc, gc, gc),
            listOf(gc, gc, gc, wc, wc, wc, wc, gc, gc, gc),
            listOf(gc, gc, gc, wc, wc, wc, wc, wc, wc, gc),
            listOf(gc, gc, wc, wc, wc, wc, wc, wc, wc, wc),
            listOf(gc, gc, wc, wc, wc, gc, wc, wc, wc, gc),
            listOf(gc, wc, wc, wc, wc, wc, wc, wc, wc, gc),
            listOf(gc, gc, wc, wc, wc, wc, wc, wc, gc, gc),
            listOf(gc, gc, gc, gc, wc, wc, wc, wc, gc, gc),
            listOf(gc, gc, gc, gc, gc, gc, wc, gc, gc, gc),
        ), "Life is Roblox", 8
    ),
    LEGOface(
        "A LEGO® face", listOf(
            listOf(ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp),
            listOf(ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp),

            // Eyes
            listOf(ycp, blackcp, blackcp, ycp, ycp, ycp, ycp, blackcp, blackcp, ycp),
            listOf(ycp, blackcp, blackcp, ycp, ycp, ycp, ycp, blackcp, blackcp, ycp),

            listOf(ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp),
            listOf(ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp),
            listOf(ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp),
            listOf(ycp, blackcp, ycp, ycp, ycp, ycp, ycp, ycp, blackcp, ycp),
            listOf(ycp, ycp, blackcp, blackcp, blackcp, blackcp, blackcp, blackcp, ycp, ycp),
            listOf(ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp, ycp)
        ), "Just an ordinary person", 9
    ),
    RobloxConfidentFace(
        "Roblox confident face", listOf(
            listOf(wc, wc, wc, wc, wc, wc, wc, wc, wc, wc),
            listOf(wc, bc, bc, wc, wc, wc, wc, bc, bc, wc),
            listOf(wc, wc, wc, wc, wc, wc, wc, wc, wc, wc),

            // EYES
            listOf(wc, wc, bc, bc, wc, wc, bc, bc, wc, wc),
            listOf(wc, wc, bc, bc, wc, wc, wc, wc, wc, bc),

            // smile
            listOf(wc, wc, wc, wc, wc, wc, bc, bc, bc, wc),
            listOf(bc, wc, wc, wc, bc, bc, wc, wc, wc, wc),
            listOf(wc, bc, bc, bc, wc, wc, wc, wc, wc, wc),

            listOf(wc, wc, wc, wc, wc, wc, wc, wc, wc, wc),
            listOf(wc, wc, wc, wc, wc, wc, wc, wc, wc, wc)
        ), "Is it silent?", 10
    ),
    Sackboy(
        "Sackboy™", listOf(
            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw),
            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw),

            //Глаза
            listOf(brw, ww, bw, bw, brw, brw, ww, bw, bw, brw),
            listOf(brw, bw, bw, bw, brw, brw, bw, bw, bw, brw),
            listOf(brw, bw, bw, bw, brw, brw, bw, bw, bw, brw),

            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw),
            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw),

            // Рот
            listOf(brw, brw, COAL_BLOCK, COAL_BLOCK, COAL_BLOCK, COAL_BLOCK, COAL_BLOCK, COAL_BLOCK, brw, brw),
            listOf(brw, brw, brw, COAL_BLOCK, rw, rw, COAL_BLOCK, brw, brw, brw),

            listOf(brw, brw, brw, brw, brw, brw, brw, brw, brw, brw),
        ), "A knight", 13
    ),
    AmongUsRed(
        "Red astronaut from 'Among Us'™", listOf(
            listOf(lbt, bt, bt, bt, bt, lbt, bt, bt, bt, bt),
            listOf(bt, bt, lbt, rw, rw, rw, rw, bt, bt, bt),
            listOf(bt, bw, bw, bw, bw, rw, rw, rw, bt, bt),
            listOf(bw, lbw, lbw, blw, blw, bw, rw, rw, bt, lbt),
            listOf(bw, lbw, blw, blw, blw, bw, rw, rw, bt, bt),
            listOf(bw, blw, blw, blw, blw, bw, rw, rw, bt, bt),
            listOf(bw, bw, bw, bw, bw, bw, rw, rw, bt, lbt),
            listOf(rw, rw, rw, rw, rw, rw, rw, rw, bt, bt),
            listOf(rw, rw, rw, rw, rw, rw, rw, rw, bt, bt),
            listOf(rw, rw, rw, rw, rw, rw, rw, rw, bt, bt)
        ), "Hear the tune yet?", 14
    )
}