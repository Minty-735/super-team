package org.minty.superteams.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.minty.superteams.manager.TeamManager;
import org.minty.superteams.util.PlayerUtils;

public class TeleportToTeamPoint implements CommandExecutor {
    private final TeamManager manager;

    public TeleportToTeamPoint(TeamManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String team = manager.getPlayerTeam(player);
            if (team != null) {
                PlayerUtils.TeleportToTeam(player, team);

            }

        }

        return false;
    }
}
