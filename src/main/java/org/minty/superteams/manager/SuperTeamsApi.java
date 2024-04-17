package org.minty.superteams.manager;

import org.bukkit.entity.Player;

public interface SuperTeamsApi {
    String getPlayerTeam(Player player);

    // Метод для добавления игрока в команду
    void addPlayerToTeam(Player player, String teamName);


}
