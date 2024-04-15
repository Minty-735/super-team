package org.minty.superteams;

import org.bukkit.plugin.java.JavaPlugin;
import org.minty.superteams.command.GiveStick;
import org.minty.superteams.command.SwitchTeam;
import org.minty.superteams.compliter.NameCompliter;
import org.minty.superteams.listener.FriendlyFire;
import org.minty.superteams.listener.SuperClickStick;
import org.minty.superteams.manager.TeamManager;

public final class Super_teams extends JavaPlugin {

    @Override
    public void onEnable() {
        METADATA.PLUGIN = this;
        saveDefaultConfig();
        TeamManager manager = new TeamManager();
        getCommand("give_stick").setExecutor(new GiveStick());
        getCommand("switch").setExecutor(new SwitchTeam(manager));
        getCommand("switch").setTabCompleter(new NameCompliter());//todo

        getServer().getPluginManager().registerEvents(new FriendlyFire(manager),this);
        getServer().getPluginManager().registerEvents(new SuperClickStick(manager),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
