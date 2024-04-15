package org.minty.superteams.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.minty.superteams.manager.TeamManager;

public class FriendlyFire implements Listener {
    private final TeamManager manager;

    public FriendlyFire(TeamManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity victim = event.getEntity();

        if (damager instanceof Player && victim instanceof Player) {
            Player attacker = (Player) damager;
            Player defender = (Player) victim;

            String attackerTeam = manager.getPlayerTeam(attacker);
            String defenderTeam = manager.getPlayerTeam(defender);

            if (attackerTeam != null && attackerTeam.equals(defenderTeam)) {
                event.setCancelled(true);
            }
        }
    }
}
