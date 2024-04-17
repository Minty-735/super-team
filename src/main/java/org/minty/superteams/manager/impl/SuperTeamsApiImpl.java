package org.minty.superteams.manager.impl;

import org.bukkit.entity.Player;
import org.minty.superteams.manager.SuperTeamsApi;
import org.minty.superteams.manager.TeamManager;

public class SuperTeamsApiImpl implements SuperTeamsApi {
    private final TeamManager manager;

    public SuperTeamsApiImpl(TeamManager manager) {
        this.manager = manager;
    }

    @Override
    public String getPlayerTeam(Player player) {
        return manager.getPlayerTeam(player);
    }

    @Override
    public void addPlayerToTeam(Player player, String teamName) {
        manager.addToTeam(player,teamName);
    }
}
