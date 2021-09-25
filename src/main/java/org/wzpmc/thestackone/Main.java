package org.wzpmc.thestackone;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.wzpmc.thestackone.Events.OnPlayerCraft;
import org.wzpmc.thestackone.Events.OnPlayerGetItems;
import org.wzpmc.thestackone.Events.OnPlayerJoin;
import org.wzpmc.thestackone.Events.OnServerTick;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new OnPlayerJoin(),this);
        pluginManager.registerEvents(new OnServerTick(),this);
        //pluginManager.registerEvents(new OnPlayerCraft(),this);
        //pluginManager.registerEvents(new OnPlayerGetItems(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
