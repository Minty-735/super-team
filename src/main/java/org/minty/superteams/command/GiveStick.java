package org.minty.superteams.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.minty.superteams.manager.NbtTagManager;

public class GiveStick implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player;

        if (commandSender instanceof Player) {

            player = (Player) commandSender;
        } else {
            commandSender.sendMessage("Only for player");
            return false;
        }

        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "SuperStick");
//        meta.set
//        stick = NbtTagManager.setNBTTag(stick, "isEnable", "enable");
        stick = NbtTagManager.setNBTTag(stick, "ColorTeam", "blue");
        stick.setItemMeta(meta);
        player.getInventory().addItem(stick);
        return false;
    }
}
