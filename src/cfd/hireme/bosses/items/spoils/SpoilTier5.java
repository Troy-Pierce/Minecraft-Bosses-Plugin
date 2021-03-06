package cfd.hireme.bosses.items.spoils;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;

import cfd.hireme.bosses.items.ItemType;

public class SpoilTier5 extends SpoilTier4 {
	public SpoilTier5() {
		this.addItemGuarantee(ItemType.GHAST_TISSUE.getInterface().getFinalizedItem(), true, 5, 9);
		this.addItemGuarantee(ItemType.BANNER_OVERLORD.getInterface().getFinalizedItem(), true, 1, 1);
	}

	@Override
	public NamespacedKey getNamespacedKey() {
		return NamespacedKey.minecraft("spoilbag-tier5");
	}

	@Override
	public int getDropCount() {
		return 13;
	}

	@Override
	public ChatColor getNameColor() {
		return ChatColor.DARK_PURPLE;
	}

	@Override
	public int getTagId() {
		return 5;
	}
}
