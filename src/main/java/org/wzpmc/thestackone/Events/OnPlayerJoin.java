package org.wzpmc.thestackone.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().getInventory().setMaxStackSize(1);
    }
}
