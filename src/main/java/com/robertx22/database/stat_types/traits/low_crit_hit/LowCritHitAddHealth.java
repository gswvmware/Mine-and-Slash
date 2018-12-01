package com.robertx22.database.stat_types.traits.low_crit_hit;

import com.robertx22.database.stat_types.defense.Dodge;
import com.robertx22.database.stat_types.traits.bases.BaseTraitLowCritHit;
import com.robertx22.saveclasses.Unit;

public class LowCritHitAddHealth extends BaseTraitLowCritHit {

    @Override
    public void affectStats(Unit unit) {
	unit.MyStats.get(Dodge.GUID).Multi += 15;

    }

    @Override
    public String descSuffix() {
	return " Health +15% Multi";
    }

    @Override
    public String Guid() {
	return "LowCritHitAddHealthMulti";
    }

    @Override
    public String Name() {
	return "Health On Low Crit";
    }

}
