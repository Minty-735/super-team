package org.minty.superteams.manager;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.minty.superteams.util.PlayerUtils;

import java.util.HashMap;
import java.util.Map;

public class TeamManager {

    public final Map<String, String> playerTeam = new HashMap<>();
//    {PlayerName,TeamName}

    public void addToTeam(Player player, String teamName) {
        playerTeam.put(player.getName(), teamName);
        PlayerUtils.addTeamEffect(player, teamName);

    }

    public void removeFromTeam(Player player) {
        playerTeam.remove(player.getName());
        PlayerUtils.removeEffect(player);

    }

    public String getPlayerTeam(Player player) {
        return playerTeam.get(player.getName());
    }


    public boolean isTwoPlayerInOneTeam(Player damager, Player victim) {

        if (damager instanceof Player && victim instanceof Player) {
            Player attacker = (Player) damager;
            Player defender = (Player) victim;

            String attackerTeam = this.getPlayerTeam(attacker);
            String defenderTeam = this.getPlayerTeam(defender);

            if (attackerTeam != null && attackerTeam.equals(defenderTeam)) {
                return true;
            }
        }
        return false;
    }

}
