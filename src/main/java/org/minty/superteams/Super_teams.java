package org.minty.superteams;

import org.bukkit.plugin.java.JavaPlugin;
import org.minty.superteams.command.GetList;
import org.minty.superteams.command.SetTeleportPoint;
import org.minty.superteams.command.SwitchTeam;
import org.minty.superteams.command.TeleportToTeamPoint;
import org.minty.superteams.compliter.NameCompliter;
import org.minty.superteams.listener.FriendlyFire;
import org.minty.superteams.manager.TeamManager;

public final class Super_teams extends JavaPlugin {

    @Override
    public void onEnable() {
        METADATA.PLUGIN = this;
        saveDefaultConfig();
        TeamManager manager = new TeamManager();
//        getCommand("give_stick").setExecutor(new GiveStick());
        getCommand("switch").setExecutor(new SwitchTeam(manager));
        getCommand("switch").setTabCompleter(new NameCompliter());//todo
        getCommand("set_teleport_pos").setExecutor(new SetTeleportPoint());
        getCommand("getList").setExecutor(new GetList(manager));
        getCommand("teleport_to_team_point").setExecutor(new TeleportToTeamPoint(manager));

        getServer().getPluginManager().registerEvents(new FriendlyFire(manager),this);
//        getServer().getPluginManager().registerEvents(new SuperClickStick(manager),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
