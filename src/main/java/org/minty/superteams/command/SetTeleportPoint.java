package org.minty.superteams.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.minty.superteams.util.PlayerUtils;

import java.util.function.Supplier;

public class SetTeleportPoint implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player player) {
        } else {
            return false;
        }
        PlayerUtils.setTeamTeleport(player.getLocation(), args[0]);
        player.sendMessage("Teleport point set for team " + args[0]);
        Bukkit.getLogger().info("Team " + args[0] + " teleport point set to " + player.getLocation());
        return true;
    }
}
