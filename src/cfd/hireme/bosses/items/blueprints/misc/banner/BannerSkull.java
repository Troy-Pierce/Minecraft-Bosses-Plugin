package cfd.hireme.bosses.items.blueprints.misc.banner;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import cfd.hireme.bosses.items.blueprints.BLootable;

public class BannerSkull extends BLootable {
	@Override
	public ItemStack getItem() {
		ItemStack item = new ItemStack(Material.RED_BANNER);
		BannerMeta meta = (BannerMeta) item.getItemMeta();
		List<Pattern> patterns = new ArrayList<Pattern>();
		patterns.add(new Pattern(DyeColor.YELLOW, PatternType.GRADIENT_UP));
		patterns.add(new Pattern(DyeColor.ORANGE, PatternType.GRADIENT));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.SKULL));
		meta.setPatterns(patterns);
		meta.setDisplayName("Death's Banner");
		item.setItemMeta(meta);
		return item;
	}

	@Override
	public NamespacedKey getNamespacedKey() {
		return NamespacedKey.minecraft("death-banner");
	}

	@Override
	public ChatColor getNameColor() {
		return ChatColor.GOLD;
	}

	public static double getDropRate() {
		return 0.01;
	}

}
