package com.teamwizardry.wizardry.init;


import com.teamwizardry.wizardry.common.block.BlockCraftingPlate;
import com.teamwizardry.wizardry.common.block.BlockMagiciansWorktable;
import com.teamwizardry.wizardry.common.block.BlockManaBattery;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Saad on 3/24/2016.
 */
public class ModBlocks {

    public static BlockCraftingPlate craftingPlate;
    public static BlockMagiciansWorktable magiciansWorktable;
    public static BlockManaBattery battery;

    public static void init() {
        craftingPlate = new BlockCraftingPlate();
        magiciansWorktable = new BlockMagiciansWorktable();
        battery = new BlockManaBattery();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        craftingPlate.initModel();
        magiciansWorktable.initModel();
        battery.initModel();
    }
}