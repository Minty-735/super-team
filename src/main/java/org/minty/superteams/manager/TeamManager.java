package org.minty.superteams.manager;

import org.bukkit.entity.Player;
import org.minty.superteams.util.PlayerUtils;

import java.util.HashMap;
import java.util.Map;

public class TeamManager {

    public final Map<String, String> playerTeam = new HashMap<>();
//    {PlayerName,TeamName}

    public void addToTeam(Player player, String teamName) {
        playerTeam.put(player.getName(), teamName);
        PlayerUtils.addTeamEffect(player,teamName);

    }

    public void removeFromTeam(Player player) {
        playerTeam.remove(player.getName());
        PlayerUtils.removeEffect(player);

    }

    public String getPlayerTeam(Player player) {
        return playerTeam.get(player.getName());
    }

}
