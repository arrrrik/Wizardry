package com.teamwizardry.wizardry.common.item;

import com.teamwizardry.librarianlib.common.base.item.ItemMod;
import com.teamwizardry.wizardry.Wizardry;
import com.teamwizardry.wizardry.common.achievement.Achievements;
import com.teamwizardry.wizardry.common.achievement.IPickupAchievement;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Saad on 6/12/2016.
 */
public class ItemPhysicsBook extends ItemMod implements IPickupAchievement {

    public ItemPhysicsBook() {
        super("physics_book");
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
    	if(worldIn.isRemote) Wizardry.guide.display();
        return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item) {
        return Achievements.PHYSICSBOOK;
    }
}
