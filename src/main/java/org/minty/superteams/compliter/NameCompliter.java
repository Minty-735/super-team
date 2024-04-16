package org.minty.superteams.compliter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NameCompliter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (args.length > 1) {
            return Bukkit.getOnlinePlayers().stream().map(p -> p.getName()).toList();
        } else if (args.length <= 1) {
            return List.of("blue", "green", "white", "yellow");
        }
        return null;
    }
}
