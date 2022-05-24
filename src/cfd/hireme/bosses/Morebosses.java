// MoreBosses Recode
package cfd.hireme.bosses;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cfd.hireme.bosses.commands.CommandArena;
import cfd.hireme.bosses.commands.CommandSpawn;
import cfd.hireme.bosses.enchantments.EnchantmentHandler;
import cfd.hireme.bosses.inventory.Holder;
import cfd.hireme.bosses.listeners.Anvil;
import cfd.hireme.bosses.listeners.Damaged;
import cfd.hireme.bosses.listeners.Death;
import cfd.hireme.bosses.listeners.OnInventoryClose;
import cfd.hireme.bosses.listeners.OnJoin;
import cfd.hireme.bosses.listeners.OnSpawn;
import cfd.hireme.bosses.listeners.Pickup;
import cfd.hireme.bosses.listeners.UseItem;
import cfd.hireme.bosses.mobs.BarHandler;
import cfd.hireme.bosses.mobs.MobHandler;
import cfd.hireme.bosses.mobs.tier1.abilities.AbilityBee;
import cfd.hireme.bosses.mobs.tier2.abilities.AbilityBlaze;
import cfd.hireme.bosses.mobs.tier2.abilities.AbilityCreeper;
import cfd.hireme.bosses.mobs.tier2.abilities.AbilityStray;
import cfd.hireme.bosses.mobs.tier3.abilities.AbilitySlime;
import cfd.hireme.bosses.mobs.tier3.abilities.AbilityWitherSkeleton;
import cfd.hireme.bosses.mobs.tier4.abilities.AbilityMagma;
import cfd.hireme.bosses.raids.GhastRaid;
import cfd.hireme.bosses.raids.GladiatorRaid;
import cfd.hireme.bosses.raids.WorldHandler;
import cfd.hireme.bosses.utilities.ConfigurationHandler;
import cfd.hireme.bosses.utilities.Console;
import cfd.hireme.bosses.utilities.UpdateChecker;
import net.md_5.bungee.api.ChatColor;

public class Morebosses extends JavaPlugin {
	private static BarHandler barHandler;
	private static ConfigurationHandler configHandler;
	private static EnchantmentHandler enchantmentHandler;
	private static WorldHandler worldHandler;

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		configHandler = new ConfigurationHandler();
		try {
			enchantmentHandler = new EnchantmentHandler();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		barHandler = new BarHandler();
		worldHandler = new WorldHandler();
		// Events
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Death(), this);
		pm.registerEvents(new Damaged(), this);
		pm.registerEvents(new Anvil(), this);
		pm.registerEvents(new UseItem(), this);
		pm.registerEvents(new OnSpawn(), this);
		pm.registerEvents(new Pickup(), this);
		pm.registerEvents(new OnJoin(), this);
		pm.registerEvents(new OnInventoryClose(), this);
		pm.registerEvents(GhastRaid.getInstance(), this);
		pm.registerEvents(GladiatorRaid.getInstance(), this);
		// Boss abilities
		pm.registerEvents(new AbilityBee(), this);
		pm.registerEvents(new AbilityBlaze(), this);
		pm.registerEvents(new AbilityCreeper(), this);
		pm.registerEvents(new AbilityStray(), this);
		pm.registerEvents(new AbilitySlime(), this);
		pm.registerEvents(new AbilityWitherSkeleton(), this);
		pm.registerEvents(new AbilityMagma(), this);
		// Commands
		new CommandSpawn();
		new CommandArena();
		// Arenas
		Console.print("MoreBosses Loaded!");
		Console.print(ChatColor.RED + "Plugin DOES NOT support server reloads!");
		Console.print("Version " + this.getDescription().getVersion());
		if (this.getConfig().getBoolean("plugin.check_version")) {
			Console.print("Checking for updates...");
			try {
				if (UpdateChecker.isUpdateAvailable()) {
					Console.print("> New version available!");
					Console.print("> Latest Release: " + UpdateChecker.getCurrentSpigotVersion());
					Console.print("> " + UpdateChecker.getSpigotUrl());
				} else {
					Console.print("> Plugin up to date!");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override()
	public void onDisable() {
		// Clear bosses
		try {
			for (World world : Bukkit.getWorlds()) {
				for (Entity entity : world.getEntities()) {
					if (entity.hasMetadata("MoreBosses-BossId")) {
						entity.remove();
					}
				}
			}
		} catch (Exception e) {
			Console.print(ChatColor.RED + "Failed to remove bosses");
		}
		// Close illegal inventories
		try {
			if (Bukkit.getOnlinePlayers().size() > 0) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (player.getOpenInventory() != null) {
						if (player.getOpenInventory().getTopInventory().getHolder() instanceof Holder) {
							player.closeInventory();
						}
					}
				}
			}
		} catch (Exception e) {
			Console.print(ChatColor.RED + "Failed to close inventories");
		}
		getBarHandler().removeAllBars();
//		getWorldHandler().unregisterAllArenas();
//		if (getEnchantmentHandler().getEnchantments().size() > 0) {
//			for (Enchantment enchantment : getEnchantmentHandler().getEnchantments().values()) {
//				getEnchantmentHandler().unregisterEnchantment(enchantment);
//				Console.print("Unregistered Enchantment: " + enchantment.getName().toUpperCase());
//			}
//		}
//		if (getEnchantmentHandler().getCustomEnchantments().size() > 0) {
//			for (Enchantment enchantment : getEnchantmentHandler().getCustomEnchantments().values()) {
//				getEnchantmentHandler().unregisterEnchantment(enchantment);
//				Console.print("Unregistered Enchantment: " + enchantment.getName().toUpperCase());
//			}
//		}

	}
	
	public static EnchantmentHandler getEnchantmentHandler() {
		return enchantmentHandler;
	}

	public static MobHandler getMobHandler() {
		return new MobHandler();
	}

	public static ConfigurationHandler getConfigurationHandler() {
		return configHandler;
	}

	public static BarHandler getBarHandler() {
		return barHandler;
	}

	public static WorldHandler getWorldHandler() {
		return worldHandler;
	}

	public static GhastRaid getGhastRaid() {
		return GhastRaid.getInstance();
	}
}
