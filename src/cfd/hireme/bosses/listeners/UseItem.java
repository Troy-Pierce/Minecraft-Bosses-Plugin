package cfd.hireme.bosses.listeners;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import cfd.hireme.bosses.Morebosses;
import cfd.hireme.bosses.enchantments.EnchantmentHandler;
import cfd.hireme.bosses.inventory.Holder;
import cfd.hireme.bosses.items.ItemType;
import cfd.hireme.bosses.items.blueprints.BSpoilbag;
import cfd.hireme.bosses.items.data.ItemSpoil;
import cfd.hireme.bosses.items.data.Spoil;
import cfd.hireme.bosses.items.interfaces.ISpoilbag;
import cfd.hireme.bosses.utilities.ExtraUtilities;
import cfd.hireme.bosses.utilities.Random;
import cfd.hireme.bosses.utilities.Tagger;

public class UseItem implements Listener {
	@EventHandler
	public void onUse(PlayerInteractEvent e) {
		// Check spoil
		if (e.getItem() != null) {
			if (e.getItem().hasItemMeta()) {
				if (Tagger.hasSpoilTag(e.getItem())) {
					if (ItemType.getFromName(
							"SPOILS_TIER" + Integer.toString(Tagger.getLevelFromSpoilTag(e.getItem()))) != null) {
						ItemType type = ItemType.getFromName(
								"SPOILS_TIER" + Integer.toString(Tagger.getLevelFromSpoilTag(e.getItem())));
						if (type.getInterface() instanceof ISpoilbag) {
							ISpoilbag spoil = (ISpoilbag) type.getInterface();
							e.getItem().setAmount(e.getItem().getAmount() - 1);
							int size = ExtraUtilities.getDynamicSize(spoil.getDropCount());
							if (size < 27) {
								size = 27;
							}
							Inventory inventory = Bukkit.createInventory(new Holder(), size, "Spoils");
							if (spoil.getDrops().size() > 0) {
								int items = 1;
								for (Object obj : spoil.getDrops()) {
									// SPOIL ITEMSPOIL
									if (obj instanceof ItemSpoil) {
										if (((ItemSpoil) obj).isGuaranteed()) {
											inventory.setItem(BSpoilbag.getSlot(inventory),
													((ItemSpoil) obj).getItem());
											items++;
										}
									}
								}
								for (int i = items; i <= spoil.getDropCount(); i++) {
									Object obj = spoil.getDrops().get(Random.random(0, spoil.getDrops().size() - 1));
									// SPOIL - ITEMSTACK
									if (obj instanceof ItemStack) {
										inventory.setItem(BSpoilbag.getSlot(inventory), (@Nullable ItemStack) obj);
										// SPOIL - SPOIL
									} else if (obj instanceof Spoil) {
										Spoil object = (Spoil) obj;
										if (!object.isEnchantable()) {
											inventory.setItem(BSpoilbag.getSlot(inventory),
													new ItemStack(object.getMaterial(),
															Random.random(object.getMin(), object.getMax())));
										} else {
											boolean canEnchant = false;
											if (object.isForcedEnchant()) {
												canEnchant = true;
											} else {
												if (Random.random(0.50)) {
													canEnchant = true;
												}
											}
											ItemStack item = new ItemStack(object.getMaterial(),
													Random.random(object.getMin(), object.getMax()));
											if (canEnchant) {
												Enchantment enchant = object.getRandomEnchantment();
												int max = enchant.getMaxLevel();
												if (max > object.getLimit()) {
													max = object.getLimit();
												}
												int level = Random.random(enchant.getStartLevel(), max);
												ItemMeta meta = item.getItemMeta();
												if (item.getType() == Material.ENCHANTED_BOOK) {
													((EnchantmentStorageMeta) meta).addStoredEnchant(enchant, level,
															false);
												} else {
													meta.addEnchant(enchant, level, false);
												}
												if (Morebosses.getEnchantmentHandler().getEnchantments()
														.containsValue(enchant)) {
													meta.setLore(Arrays.asList(ChatColor.GRAY
															+ EnchantmentHandler.getNumeral(enchant, level)));
												}
												item.setItemMeta(meta);
											}
											inventory.setItem(BSpoilbag.getSlot(inventory), item);
										}
										// SPOIL - ITEMSPOIL
									} else if (obj instanceof ItemSpoil) {
										ItemSpoil object = (ItemSpoil) obj;
										if (!object.isGuaranteed()) {
											inventory.setItem(BSpoilbag.getSlot(inventory), object.getItem());
										} else {
											i--;
										}
									}
								}
							}
							e.getPlayer().openInventory(inventory);
						}
					}
				}
			}
		}
	}
}
