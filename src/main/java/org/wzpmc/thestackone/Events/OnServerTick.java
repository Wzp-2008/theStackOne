package org.wzpmc.thestackone.Events;

import com.destroystokyo.paper.event.server.ServerTickEndEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.wzpmc.thestackone.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class OnServerTick implements Listener {
    @EventHandler
    public void OST(ServerTickEndEvent event){
        Plugin plugin = Main.getPlugin(Main.class);
        for (Player onlinePlayer : plugin.getServer().getOnlinePlayers()) {
            int index1 = 0;
            for (ItemStack storageContent : onlinePlayer.getInventory().getStorageContents()) {
                if(storageContent != null && storageContent.getAmount() > onlinePlayer.getInventory().getMaxStackSize()){
                    onlinePlayer.getInventory().setItem(index1,null);
                    ArrayList<ItemStack> items = new ArrayList<>();
                    for (int i = 0; i < storageContent.getAmount(); i++) {
                        items.add(storageContent.asOne());
                    }
                    int index = 0;
                    for (ItemStack content : onlinePlayer.getInventory().getStorageContents()) {
                        if(content == null){
                            onlinePlayer.getInventory().setItem(index,items.get(0));
                            items.remove(0);
                        }
                        index ++;
                    }
                    if(items.size() != 0){
                        for (ItemStack item : items) {
                            onlinePlayer.getWorld().dropItem(onlinePlayer.getLocation(),item);
                        }
                    }
                }
                index1++;
            }
        }
    }
}
