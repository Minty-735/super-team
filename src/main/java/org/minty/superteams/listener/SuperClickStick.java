package org.minty.superteams.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.minty.superteams.manager.NbtTagManager;
import org.minty.superteams.manager.TeamManager;
import org.minty.superteams.util.PlayerUtils;
import org.minty.superteams.util.Team;

public class SuperClickStick implements Listener {
//    todo add team manager

    private final TeamManager manager;

    public SuperClickStick(TeamManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void addToTeam(PlayerInteractEntityEvent event) {
        ItemStack item = event.getPlayer().getActiveItem();
        String teamName = getCommandName(item);
        if (teamName != null) {

//            Player player = event.getPlayer();

            if (event.getRightClicked() instanceof Player) {
                Player target = (Player) event.getRightClicked();
                manager.addToTeam(target, teamName);

            }
        }
    }

    @EventHandler
    public void changeTeam(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        String teamName = getCommandName(item);
        Team currentTeam = Team.fromName(teamName);
        if (teamName != null) {
            if (event.getAction().isRightClick()) {
                NbtTagManager.setNBTTag(item, "ColorTeam", currentTeam.getNextTeamName());
                ChatColor color;
                switch (teamName) {
                    case "blue":
                        color = ChatColor.BLUE;
                        break;
                    case "green":
                        color = ChatColor.GREEN;
                        break;
                    case "yellow":
                        color = ChatColor.YELLOW;
                        break;

                    case "white":
                        color = ChatColor.WHITE;
                        break;

                    default:
                        color = ChatColor.RESET;
                        break;

                }
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(color + "SuperStick");
                item.setItemMeta(meta);
            }
        }
    }


    public String getCommandName(ItemStack item) {
        if (NbtTagManager.getNBTTag(item, "isEnable").equalsIgnoreCase("enable")) {
            String teamName = NbtTagManager.getNBTTag(item, "ColorTeam");
            return teamName;
        }
        return null;
    }

}
