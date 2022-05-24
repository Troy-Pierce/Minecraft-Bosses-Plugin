package cfd.hireme.bosses.items.data;

import org.bukkit.inventory.ItemStack;

import cfd.hireme.bosses.utilities.Random;

public class ItemSpoil {
	private ItemStack item;
	private int min;
	private int max;
	private boolean guaranteed = false;;

	public ItemSpoil(ItemStack item, boolean guaranteed, int min, int max) {
		this.item = item;
		this.guaranteed = guaranteed;
		this.min = min;
		this.max = max;
	}

	public ItemStack getItem() {
		int amount = this.min == this.max ? this.max : Random.random(this.min, this.max);
		this.item.setAmount(amount);
		return this.item;
	}

	public boolean isGuaranteed() {
		return this.guaranteed;
	}

}
