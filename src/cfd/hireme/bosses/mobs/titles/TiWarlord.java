package cfd.hireme.bosses.mobs.titles;

import cfd.hireme.bosses.mobs.interfaces.ITitle;

public class TiWarlord implements ITitle {

	@Override
	public double getDamageMultiplier() {
		// TODO Auto-generated method stub
		return 1.6;
	}

	@Override
	public double getHealthMultiplier() {
		// TODO Auto-generated method stub
		return 1.6;
	}

	@Override
	public double getSpeedMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinions() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getTitleName() {
		// TODO Auto-generated method stub
		return "Warlord";
	}

	@Override
	public boolean isBossTitle() {
		// TODO Auto-generated method stub
		return false;
	}
}
