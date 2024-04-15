package org.minty.superteams.util;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.minty.superteams.METADATA;

import java.util.List;

public class PlayerUtils {
    static FileConfiguration config = METADATA.PLUGIN.getConfig();

    static ConfigurationSection teamsSection = config.getConfigurationSection("teams");

    public static void addTeamEffect(Player player, String team) {
        removeEffect(player);
        ConfigurationSection teamSection = teamsSection.getConfigurationSection(team);
        List<String> effects = teamSection.getStringList("effects");
        for (String effectName : effects) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effectName), Integer.MAX_VALUE, 0, false, false));
//        todo check work in game
        }
        setPrefix(player, team);
    }

    public static void removeEffect(Player player) {
        player.getActivePotionEffects().clear();
    }

    public static void setPrefix(Player player, String team) {
        String prefix = teamsSection.getConfigurationSection(team).getString("prefix");
        ChatColor color = getTeamColor(team);
        player.setDisplayName(color + prefix + " " + player.getName() + ChatColor.RESET);
        player.setPlayerListName(color + prefix + " " + player.getName());


    }

    private static ChatColor getTeamColor(String team) {
        switch (team) {
            case "blue":
                return ChatColor.BLUE;
            case "green":
                return ChatColor.GREEN;
            case "yellow":
                return ChatColor.YELLOW;
            case "white":
                return ChatColor.WHITE;
            default:
                return ChatColor.RESET;


        }
    }
}
