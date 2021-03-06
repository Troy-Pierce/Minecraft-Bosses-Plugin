package cfd.hireme.bosses.mobs.tier5;

import org.bukkit.entity.EntityType;

import cfd.hireme.bosses.mobs.blueprints.BHostile;
import cfd.hireme.bosses.mobs.interfaces.IAbility;
import cfd.hireme.bosses.mobs.interfaces.IAvian;
import cfd.hireme.bosses.mobs.interfaces.IRaid;

public class BGhast extends BHostile implements IAbility, IAvian, IRaid {
	public BGhast() {
		this.setExperience(30);
		// this.addSpoil();
	}

	@Override
	public EntityType getEntityType() {
		// TODO Auto-generated method stub
		return EntityType.GHAST;
	}

	@Override
	public int getBossId() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public double getFlightMultiplier() {
		// TODO Auto-generated method stub
		return 1.45;
	}

	@Override
	public void setFlightMultiplier(double d) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getHealthMultiplier() {
		return 21.6;
	}

	@Override
	public double getSpeedMultiplier() {
		return 1.2;
	}

	@Override
	public double getArmorMultiplier() {
		return 13.5;
	}

	@Override
	public double getArmorStrengthMultiplier() {
		return 10;
	}

	@Override
	public double getKnockbackResistance() {
		return 100;
	}

	@Override
	public double getDamageMultiplier() {
		return 8.3;
	}

	@Override
	public double getAttackSpeedMultiplier() {
		return 1;
	}

	@Override
	public double getFollowRange() {
		return 1000;
	}

	@Override
	public int getMinions() {
		return 0;
	}
}
