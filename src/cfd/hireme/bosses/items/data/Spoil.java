package cfd.hireme.bosses.items.data;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import cfd.hireme.bosses.utilities.Random;

public class Spoil {
	private Material mat;
	private int min;
	private int max;
	private boolean item;
	private Enchantment[] enchantments = {};
	private int limit = 0;
	private boolean forced = false;

	public Spoil(Material material, int minAmount, int maxAmount, boolean isItem, @Nullable Integer limitEnchant,
			boolean forceEnchant, @Nullable Enchantment... enchantments) {
		this.mat = material;
		this.min = minAmount;
		this.max = maxAmount;
		this.item = isItem;
		if (!(enchantments == null)) {
			if (enchantments.length > 0) {
				this.enchantments = enchantments;
			}
		}
		if (limitEnchant == null) {
			this.limit = 0;
		} else {
			this.limit = limitEnchant;
		}
		this.forced = forceEnchant;
	}

	public Material getMaterial() {
		return this.mat;
	}

	public int getMax() {
		return this.max;
	}

	public int getMin() {
		return this.min;
	}

	public void setMax(int i) {
		this.max = i;
	}

	public void setMin(int i) {
		this.min = i;
	}

	public void setMaterial(Material m) {
		this.mat = m;
	}

	public boolean isItem() {
		return this.item;
	}

	public boolean isLimited() {
		return !(this.limit == 0);
	}

	public int getLimit() {
		return this.limit;
	}

	public boolean isForcedEnchant() {
		return this.forced;
	}

	public boolean isEnchantable() {
		return enchantments.length > 0;
	}

	public Enchantment getRandomEnchantment() {
		return this.enchantments[Random.random(0, this.enchantments.length - 1)];
	}

}
