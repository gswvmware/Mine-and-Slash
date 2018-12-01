package com.robertx22.database.stat_types.traits;

import com.robertx22.database.stat_types.offense.CriticalHit;
import com.robertx22.saveclasses.Unit;
import com.robertx22.stats.IAffectsOtherStats;
import com.robertx22.stats.Trait;

public class Lucky extends Trait implements IAffectsOtherStats {

    public static String GUID = "Lucky";

    @Override
    public String Guid() {
	return GUID;
    }

    @Override
    public void TryAffectOtherStats(Unit unit) {

	unit.MyStats.get(CriticalHit.GUID).Multi += 10;

    }

    @Override
    public String Description() {
	return "+ 10% Critical hit multi";
    }

    @Override
    public String Name() {
	return "Lucky";
    }

}
