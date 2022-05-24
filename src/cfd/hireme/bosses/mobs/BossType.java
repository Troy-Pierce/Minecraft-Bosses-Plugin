package cfd.hireme.bosses.mobs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.EntityType;

import cfd.hireme.bosses.mobs.interfaces.IBoss;
import cfd.hireme.bosses.mobs.tier1.BBee;
import cfd.hireme.bosses.mobs.tier1.BDrowned;
import cfd.hireme.bosses.mobs.tier1.BSkeleton;
import cfd.hireme.bosses.mobs.tier1.BZombie;
import cfd.hireme.bosses.mobs.tier2.BBlaze;
import cfd.hireme.bosses.mobs.tier2.BCreeper;
import cfd.hireme.bosses.mobs.tier2.BStray;
import cfd.hireme.bosses.mobs.tier3.BSlime;
import cfd.hireme.bosses.mobs.tier3.BWitherSkeleton;
import cfd.hireme.bosses.mobs.tier4.BMagma;
import cfd.hireme.bosses.mobs.tier4.BPigman;
import cfd.hireme.bosses.mobs.tier4.BRavager;
import cfd.hireme.bosses.mobs.tier5.BGhast;

public enum BossType {
	BEE(new BBee()), DROWNED(new BDrowned()), ZOMBIE(new BZombie()), SKELETON(new BSkeleton()), BLAZE(new BBlaze()),
	CREEPER(new BCreeper()), STRAY(new BStray()), SLIME(new BSlime()), WITHER_SKELETON(new BWitherSkeleton()),
	PIG_ZOMBIE(new BPigman()), MAGMA_CUBE(new BMagma()), RAVAGER(new BRavager()), GHAST(new BGhast());

	public static BossType getFromName(String name) {
		for (BossType type : BossType.values()) {
			if (type.name().toLowerCase().equals(name.toLowerCase())) {
				return type;
			}
		}
		return null;
	}

	public static BossType getFromId(int id) {
		for (BossType type : BossType.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		return null;
	}

	public static BossType[] getFromInterfaceClass(Class<? extends IBoss> clazz) {
		List<BossType> type = new ArrayList<BossType>();
		for (BossType bossType : BossType.values()) {
			if (bossType.getInterface().getClass() == clazz) {
				type.add(bossType);
			}
		}
		BossType[] array = new BossType[type.size()];
		type.toArray(array);
		return array;
	}

	public static BossType[] getFromEntityType(EntityType entityType) {
		List<BossType> type = new ArrayList<BossType>();
		for (BossType bossType : BossType.values()) {
			if (bossType.getEntityType() == entityType) {
				type.add(bossType);
			}
		}
		BossType[] array = new BossType[type.size()];
		type.toArray(array);
		return array;
	}

	private final IBoss iBoss;

	BossType(final IBoss iBoss) {
		this.iBoss = iBoss;
	}

	public IBoss getInterface() {
		return this.iBoss;
	}

	public EntityType getEntityType() {
		return this.iBoss.getEntityType();
	}

	public int getId() {
		return this.iBoss.getBossId();
	}
}
