package cfd.hireme.bosses.mobs.tier3.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cfd.hireme.bosses.Morebosses;
import cfd.hireme.bosses.events.EntityDamageByBossEvent;
import cfd.hireme.bosses.mobs.tier3.BWitherSkeleton;

public class AbilityWitherSkeleton implements Listener {
	private final boolean ENABLED = Morebosses.getConfigurationHandler()
			.openBossConfiguration("Tier3\\WitherSkeleton.yml").getBoolean("WitherSkeleton.ability.enabled");

	@EventHandler
	public void OnDamage(EntityDamageByBossEvent e) {
		if (this.ENABLED) {
			if (e.getBoss() instanceof BWitherSkeleton) {
				if (!e.getEntity().isDead()) {
					if (((LivingEntity) e.getEntity()).addPotionEffect(
							new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1, false, false))) {
					}
				}
			}
		}
	}
}
