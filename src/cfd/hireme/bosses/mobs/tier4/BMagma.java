package cfd.hireme.bosses.mobs.tier4;

import org.bukkit.entity.EntityType;

import cfd.hireme.bosses.Morebosses;
import cfd.hireme.bosses.items.ItemType;
import cfd.hireme.bosses.mobs.blueprints.BHostile;
import cfd.hireme.bosses.mobs.interfaces.ISizeable;
import cfd.hireme.bosses.utilities.Random;

public class BMagma extends BHostile implements ISizeable {
	private final int SIZE = Morebosses.getConfigurationHandler().openBossConfiguration("Tier4\\MagmaCube.yml")
			.getInt("Magma.size");

	public BMagma() {
		this.setExperience(Random.random(27, 35));
		// this.addSpoil();
		this.addSpoil(ItemType.SPOILS_TIER4.getInterface().getFinalizedItem());
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.MAGMA_CUBE;
	}

	@Override
	public int getBossId() {
		return 10;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.SIZE;
	}

	@Override
	public double getSpawnChance() {
		return Morebosses.getConfigurationHandler().openBossConfiguration("Tier4\\MagmaCube.yml")
				.getDouble("Magma.rate");

	}

}
