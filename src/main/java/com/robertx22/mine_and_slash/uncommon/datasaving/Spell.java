package com.robertx22.mine_and_slash.uncommon.datasaving;

import com.robertx22.mine_and_slash.saveclasses.item_classes.SpellItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.base.LoadSave;

import info.loenwind.autosave.Reader;
import info.loenwind.autosave.Writer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Spell {

    private static final String LOC = "SPELL_ITEM_DATA";

    public static SpellItemData Load(ItemStack stack) {

    	if (stack == null) {
    	    return null;
    	}
    	if (!stack.hasTagCompound()) {
    	    return null;
    	}

    	SpellItemData data = null;
    	if (stack.getTagCompound().hasKey(LOC)) {
    	    NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag(LOC);
    	    data = new SpellItemData();
    	    Reader.read(nbt, data);
    	}

    	return data;

        }

        public static void Save(ItemStack stack, SpellItemData spell) {
    	if (stack == null) {
    	    return;
    	}
    	if (!stack.hasTagCompound()) {
    	    stack.setTagCompound(new NBTTagCompound());
    	}

    	if (spell != null) {
    	    NBTTagCompound object_nbt = new NBTTagCompound();
    	    Writer.write(object_nbt, spell);
    	    NBTTagCompound new_nbt = stack.getTagCompound();
    	    new_nbt.setTag(LOC, object_nbt);
    	    new_nbt.setInteger("rarity", spell.rarity);
    	    stack.setTagCompound(new_nbt);

    	}
        }


}
