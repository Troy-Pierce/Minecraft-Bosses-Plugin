package cfd.hireme.bosses.mobs;

import java.util.ArrayList;
import java.util.List;

import cfd.hireme.bosses.mobs.interfaces.ITitle;
import cfd.hireme.bosses.mobs.titles.TiAgile;
import cfd.hireme.bosses.mobs.titles.TiAngra;
import cfd.hireme.bosses.mobs.titles.TiInvincible;
import cfd.hireme.bosses.mobs.titles.TiOverlord;
import cfd.hireme.bosses.mobs.titles.TiStrong;
import cfd.hireme.bosses.mobs.titles.TiWarlord;
import cfd.hireme.bosses.mobs.titles.TiWeak;
import cfd.hireme.bosses.utilities.Random;

public enum TitleType {
	WARLORD(new TiWarlord()), AGILE(new TiAgile()), ANGRA(new TiAngra()), INVINCIBLE(new TiInvincible()),
	STRONG(new TiStrong()), WEAK(new TiWeak()), OVERLORD(new TiOverlord());

	private ITitle ititle;

	TitleType(ITitle title) {
		this.ititle = title;
	}

	public ITitle getTitle() {
		return this.ititle;
	}

	public static TitleType getRandomTitle() {
		List<TitleType> availableTypes = new ArrayList<TitleType>();
		for(TitleType type : TitleType.values()) {
			if(!type.getTitle().isBossTitle()) {
				availableTypes.add(type);
			}
		}
		return availableTypes.get(Random.random(0, availableTypes.size()-1));
	}
}
