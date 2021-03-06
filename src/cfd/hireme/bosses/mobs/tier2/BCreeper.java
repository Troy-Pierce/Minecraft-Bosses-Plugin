package cfd.hireme.bosses.mobs.tier2;

import org.bukkit.entity.EntityType;

import cfd.hireme.bosses.Morebosses;
import cfd.hireme.bosses.items.ItemType;
import cfd.hireme.bosses.mobs.blueprints.BHostile;
import cfd.hireme.bosses.mobs.interfaces.IAbility;

public class BCreeper extends BHostile implements IAbility {
	public BCreeper() {
		this.setExperience(17);
		this.addSpoil(ItemType.SPOILS_TIER2.getInterface());
	}

	@Override
	public EntityType getEntityType() {
		// TODO Auto-generated method stub
		return EntityType.CREEPER;
	}

	@Override
	public int getBossId() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public double getHealthMultiplier() {
		return 1.2;
	}

	@Override
	public double getSpeedMultiplier() {
		return 1.85;
	}

	@Override
	public double getArmorMultiplier() {
		return 1.1;
	}

	@Override
	public double getArmorStrengthMultiplier() {
		return 1.1;
	}

	@Override
	public double getKnockbackResistance() {
		return 1;
	}

	@Override
	public double getDamageMultiplier() {
		return 1;
	}

	@Override
	public double getAttackSpeedMultiplier() {
		return 1;
	}

	@Override
	public double getFollowRange() {
		return 4.5;
	}

	@Override
	public double getSpawnChance() {
		return Morebosses.getConfigurationHandler().openBossConfiguration("Tier2\\Creeper.yml")
				.getDouble("Creeper.rate");

	}
}
