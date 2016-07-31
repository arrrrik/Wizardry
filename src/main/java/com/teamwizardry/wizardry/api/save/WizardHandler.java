package com.teamwizardry.wizardry.api.save;

import com.teamwizardry.wizardry.api.spell.event.SpellCastEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Saad on 6/19/2016.
 */
public class WizardHandler {

    public static final WizardHandler INSTANCE = new WizardHandler();
    private int tickCooldown = 0;

    private WizardHandler() {
        MinecraftForge.EVENT_BUS.register(this);

        CapabilityManager.INSTANCE.register(IWizardData.class, new Capability.IStorage<IWizardData>() {
            @Override
            public NBTBase writeNBT(Capability<IWizardData> capability, IWizardData instance, EnumFacing side) {
                return null;
            }

            @Override
            public void readNBT(Capability<IWizardData> capability, IWizardData instance, EnumFacing side, NBTBase nbt) {
            }
        }, () -> {
            throw new UnsupportedOperationException();
        });
    }

    public static IWizardData.BarData getEntityData(EntityPlayer entity) {
        IWizardData.BarData ret = new IWizardData.BarData();
        ret.burnoutAmount = WizardryDataHandler.getBurnoutAmount(entity);
        ret.burnoutMax = WizardryDataHandler.getBurnoutMax(entity);
        ret.manaAmount = WizardryDataHandler.getMana(entity);
        ret.manaMax = WizardryDataHandler.getManaMax(entity);

        return ret;
    }

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent.Entity event) {
        if (event.getEntity() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation("barData"), new WizardryDataProvider());
        }
    }

    @SubscribeEvent
    public void playerUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            if (tickCooldown >= 5) {
                tickCooldown = 0;

                EntityPlayer player = (EntityPlayer) event.getEntity();
                IWizardData.BarData provider = getEntityData(player);
                if (provider.manaAmount < provider.manaMax)
                    WizardryDataHandler.setMana(player, provider.manaAmount + 1);
                if (provider.burnoutAmount > 0)
                    WizardryDataHandler.setBurnoutAmount(player, provider.burnoutAmount - 1);

            } else tickCooldown++;
        }
    }

    @SubscribeEvent
    public void spellCast(SpellCastEvent event) {
        // TODO
    }
}