package org.minty.superteams.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.minty.superteams.manager.TeamManager;

public class Join implements Listener {
    private final TeamManager manager;

    public Join(TeamManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {

        if (manager.getPlayerTeam(event.getPlayer()) != null){
            manager.addToTeam(event.getPlayer(),manager.getPlayerTeam(event.getPlayer()));

        }else {
            for (Player player : Bukkit.getOnlinePlayers()){
                if (player.isOp())player.sendMessage("Player " + ChatColor.RED + event.getPlayer()+ChatColor.RESET + " not in team");
            }
        }

    }
}
