package org.minty.superteams.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.minty.superteams.manager.TeamManager;

public class GetList implements CommandExecutor {
    private final TeamManager manager;

    public GetList(TeamManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)) {
            return false;
        }


        player.sendMessage(manager.getAllTeams().toString());
        return true;
    }
}
