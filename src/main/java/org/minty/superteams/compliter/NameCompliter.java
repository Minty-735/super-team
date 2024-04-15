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
            return Bukkit.getOnlinePlayers()
                    .stream()
                    .map(player -> player.getName())
                    .filter(name -> name.startsWith(args[1]))
                    .toList();
        } else {
            List.of("blue", "green", "white", "yellow")
                    .stream()
                    .filter(name -> name.startsWith(args[0]))
                    .toList();
        }
        return null;
    }
}
