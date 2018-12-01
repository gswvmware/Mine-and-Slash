package com.robertx22.database.stat_types.elementals.all_damage;

import com.robertx22.uncommon.enumclasses.Elements;

public class AllFireDamage extends AllEleDamageBase {
    public static String GUID = "All Fire Damage";

    @Override
    public String Guid() {
	return GUID;
    }

    @Override
    public Elements Element() {
	return Elements.Fire;
    }

    @Override
    public String Name() {
	return "All Fire Damage";
    }

}
