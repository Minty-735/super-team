package org.minty.superteams.command;

import com.destroystokyo.paper.utils.PaperPluginLogger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.minty.superteams.manager.TeamManager;
import org.minty.superteams.util.PlayerUtils;

import javax.swing.text.PlainDocument;

public class SwitchTeam implements CommandExecutor {
    private final TeamManager manager;

    public SwitchTeam(TeamManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player;
        if (commandSender instanceof Player) {
            player = (Player) commandSender;
        } else {
            return false;
        }
        for (int i = 1; i < args.length; i++) {
            manager.addToTeam(
                    Bukkit.getPlayer(args[i])
                    , args[0]);

        }
        return true;
    }
}
