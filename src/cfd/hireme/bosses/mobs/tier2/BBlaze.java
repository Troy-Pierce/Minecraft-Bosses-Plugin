package cfd.hireme.bosses.mobs.tier2;

import org.bukkit.entity.EntityType;

import cfd.hireme.bosses.Morebosses;
import cfd.hireme.bosses.items.ItemType;
import cfd.hireme.bosses.mobs.blueprints.BHostile;
import cfd.hireme.bosses.mobs.interfaces.IAbility;
import cfd.hireme.bosses.mobs.interfaces.IAvian;

public class BBlaze extends BHostile implements IAbility, IAvian {
	public BBlaze() {
		this.setExperience(17);
		this.addSpoil(ItemType.SPOILS_TIER2.getInterface());
	}

	@Override
	public EntityType getEntityType() {
		// TODO Auto-generated method stub
		return EntityType.BLAZE;
	}

	@Override
	public int getBossId() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public double getFlightMultiplier() {
		// TODO Auto-generated method stub
		return 1.15;
	}

	@Override
	public void setFlightMultiplier(double d) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getHealthMultiplier() {
		return 4.6;
	}

	@Override
	public double getSpeedMultiplier() {
		return 1.2;
	}

	@Override
	public double getArmorMultiplier() {
		return 3.2;
	}

	@Override
	public double getArmorStrengthMultiplier() {
		return 2.5;
	}

	@Override
	public double getKnockbackResistance() {
		return 1;
	}

	@Override
	public double getDamageMultiplier() {
		return 1.4;
	}

	@Override
	public double getAttackSpeedMultiplier() {
		return 1;
	}

	@Override
	public double getFollowRange() {
		return 4;
	}

	@Override
	public double getSpawnChance() {
		return Morebosses.getConfigurationHandler().openBossConfiguration("Tier2\\Blaze.yml").getDouble("Blaze.rate");

	}
}
