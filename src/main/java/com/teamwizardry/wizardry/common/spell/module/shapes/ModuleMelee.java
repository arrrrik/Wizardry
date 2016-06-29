package com.teamwizardry.wizardry.common.spell.module.shapes;

import net.minecraft.nbt.NBTTagCompound;
import com.teamwizardry.wizardry.api.module.Module;
import com.teamwizardry.wizardry.api.module.attribute.Attribute;
import com.teamwizardry.wizardry.api.spell.ModuleType;

public class ModuleMelee extends Module {
    @Override
    public ModuleType getType() {
        return ModuleType.SHAPE;
    }

    @Override
    public String getDescription()
    {
    	return "Casts the spell on the object you are looking at.";
    }
    
    @Override
    public NBTTagCompound getModuleData() {
    	NBTTagCompound compound = super.getModuleData();
    	compound.setDouble(MANA, attributes.apply(Attribute.MANA, 10));
    	compound.setDouble(BURNOUT, attributes.apply(Attribute.BURNOUT, 10));
        return compound;
    }
}