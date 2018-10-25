package com.robertx22.database.stats.types.traits.bad_and_good;

import com.robertx22.database.stats.types.offense.PhysicalDamage;
import com.robertx22.saveclasses.Unit;
import com.robertx22.stats.IAffectsOtherStats;
import com.robertx22.stats.Trait;

public class Barbarian extends Trait implements IAffectsOtherStats {

	public static String GUID = "Barbarian";

	@Override
	public String Name() {
		return GUID;
	}

	@Override
	public void TryAffectOtherStats(Unit unit) {

		unit.mana().Multi -= 15;
		unit.Stats.get(PhysicalDamage.GUID).Multi += 15;

	}

}
