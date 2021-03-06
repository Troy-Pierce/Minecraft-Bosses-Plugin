package cfd.hireme.bosses.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.IOUtils;

import cfd.hireme.bosses.Morebosses;

public class ConfigurationHandler {
	private Morebosses plugin = Morebosses.getPlugin(Morebosses.class);
	private File nameFile;
	private String jarPath = "src/cfd/hireme/bosses/resources/";

	public ConfigurationHandler() {
		this.checkFiles();
	}

	public void checkFile(String fileName, String pathOutput) {
		try {
			File file = new File(pathOutput + "\\" + fileName);
			copyFile(file, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkFiles() {
		final List<String> WORLDS = Arrays.asList("Colosseum", "Ghast");
		final List<String> BOSS_CONFIGS = Arrays.asList("Tier1/Bee.yml", "Tier1/Drowned.yml", "Tier1/Skeleton.yml",
				"Tier1/Zombie.yml", "Tier2/Blaze.yml", "Tier2/Creeper.yml", "Tier2/Stray.yml", "Tier2/Guardian.yml",
				"Tier2/Phantom.yml", "Tier3/Slime.yml", "Tier3/WitherSkeleton.yml", "Tier4/Pigman.yml",
				"Tier4/MagmaCube.yml", "Tier4/Ravager.yml");
		final List<String> ENCHANT_CONFIGS = Arrays.asList("bleed.yml", "ember.yml", "fleet.yml", "lifesteal.yml",
				"replenish.yml");
		final List<String> RAID_CONFIGS = Arrays.asList("GladiatorRaid.yml", "GhastRaid.yml");
		if (!(plugin.getDataFolder().exists())) {
			plugin.getDataFolder().mkdir();
		}
		this.nameFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\names.txt");
		if (!this.nameFile.exists()) {
			try {
				this.copyFile(this.nameFile, false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (String configs : BOSS_CONFIGS) {
			File configFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\Bosses\\" + configs);
			if (!configFile.exists()) {
				try {
					String splitName = configs.split("/")[1];
//					configFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\Bosses\\" + splitName);
					configFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\" + splitName);
					this.copyFile(configFile, false);
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (String enchantName : ENCHANT_CONFIGS) {
			enchantName = enchantName.toLowerCase();
			File configFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\Enchantments\\" + enchantName);
			if (!configFile.exists()) {
				configFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\" + enchantName);
				try {
					this.copyFile(configFile, false);
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (String worldName : WORLDS) {
			File worldFile = new File(
					Bukkit.getServer().getWorldContainer().getAbsolutePath() + "\\Morebosses-" + worldName);
			if (!worldFile.exists()) {
				try {
					this.copyFile(worldFile, true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				File dataFile = new File(Bukkit.getServer().getWorldContainer().getAbsolutePath() + "\\Morebosses-"
						+ worldName + "\\data.yml");
				if (!dataFile.exists()) {
					try {
						this.copyFile(dataFile, false);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		for (String raidName : RAID_CONFIGS) {
			File raidFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\Raids\\" + raidName);
			if (!raidFile.exists()) {
				raidFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\" + raidName);
				try {
					this.copyFile(raidFile, true);
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public @Nonnull YamlConfiguration openConfiguration(String name, String path) {
		File configFile = new File(path + "\\" + name);
		if (!configFile.exists()) {
			this.checkFiles();
		}
		return YamlConfiguration.loadConfiguration(configFile);
	}

	public YamlConfiguration openBossConfiguration(String name) {
		File configFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\Bosses\\" + name);
		if (!configFile.exists()) {
			this.checkFiles();
		}
		return YamlConfiguration.loadConfiguration(configFile);
	}

	public YamlConfiguration openEnchantmentConfiguration(String name) {
		File configFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\Enchantments\\" + name);
		if (!configFile.exists()) {
			this.checkFiles();
		}
		return YamlConfiguration.loadConfiguration(configFile);
	}

	public YamlConfiguration openRaidConfiguration(String name) {
		File raidFile = new File(plugin.getDataFolder().getAbsolutePath() + "\\Raids\\" + name);
		if (raidFile.exists()) {
			this.checkFiles();
		}
		return YamlConfiguration.loadConfiguration(raidFile);
	}

	private void copyFile(File file, boolean isArena) throws IOException, URISyntaxException {
//		if (isArena) {
//			Console.print("Boss Arena: " + file.getName());
//		} else {
//			Console.print("File: " + file.getName());
//		}
		JarFile jar = new JarFile(
				Morebosses.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		Enumeration<JarEntry> entries = jar.entries();
		String directory = file.getParentFile().getAbsolutePath();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (entry.getName().contains("resources/") && entry.getName().contains(file.getName())) {
				String newName = entry.getName().substring(this.jarPath.length());
				try {
					File checkFile = new File(file.getParentFile().getAbsolutePath() + "\\" + newName);
					if (!checkFile.exists()) {
						if (!checkFile.getParentFile().exists()) {
							checkFile.getParentFile().mkdirs();
							Console.print("New Directory: " + checkFile.getParentFile().getAbsolutePath());
						}
						InputStream inStream = plugin.getResource(entry.getName());
						File tempFile = new File(file.getParentFile().getAbsolutePath() + "\\" + newName);
						File.createTempFile(file.getParentFile().getAbsolutePath() + "\\" + newName, null);
						FileOutputStream outStream = new FileOutputStream(tempFile);
						IOUtils.copy(inStream, outStream);
						inStream.close();
						outStream.close();
						directory = tempFile.getParentFile().getAbsolutePath();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		jar.close();
		Console.print("Copied: " + file.getName() + " to " + directory);
	}
}
