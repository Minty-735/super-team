package org.minty.superteams.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.minty.superteams.METADATA;
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
        if (playerTeam.containsKey(player)) {
            return playerTeam.get(player.getName());
        }
        return null;
    }

    public Map<String, String> getAllTeams() {
        return playerTeam;
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


    public void saveAllToCfg() {
        FileConfiguration config = METADATA.PLUGIN.getConfig();
        for (String playerName : playerTeam.keySet()) {
            config.set(playerName, playerTeam.get(playerName));

        }
        METADATA.PLUGIN.saveConfig();

    }
}
