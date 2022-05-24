package cfd.hireme.bosses.mobs.tier3;

import org.bukkit.entity.EntityType;

import cfd.hireme.bosses.Morebosses;
import cfd.hireme.bosses.items.ItemType;
import cfd.hireme.bosses.mobs.blueprints.BHostile;
import cfd.hireme.bosses.mobs.interfaces.ISizeable;
import cfd.hireme.bosses.utilities.Random;

public class BSlime extends BHostile implements ISizeable {
	private final int SIZE = Morebosses.getConfigurationHandler().openBossConfiguration("Tier3\\Slime.yml")
			.getInt("Slime.size");

	public BSlime() {
		this.setExperience(Random.random(18, 27));
		this.addSpoil(ItemType.SPOILS_TIER3.getInterface());
	}

	@Override
	public EntityType getEntityType() {
		return EntityType.SLIME;
	}

	@Override
	public int getBossId() {
		return 7;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.SIZE;
	}

	@Override
	public double getSpawnChance() {
		return Morebosses.getConfigurationHandler().openBossConfiguration("Tier3\\Slime.yml").getDouble("Slime.rate");

	}

}
