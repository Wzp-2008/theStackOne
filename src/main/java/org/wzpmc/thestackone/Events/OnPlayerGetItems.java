package org.wzpmc.thestackone.Events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


import java.util.ArrayList;

import static org.bukkit.event.inventory.InventoryAction.MOVE_TO_OTHER_INVENTORY;


public class OnPlayerGetItems implements Listener {
    @EventHandler
    public void All(InventoryClickEvent event)
    {
        Inventory inventory = event.getInventory();
        Inventory clickedInventory = event.getClickedInventory();
        if(inventory == clickedInventory){
            InventoryAction action = event.getAction();
            if(action.equals(MOVE_TO_OTHER_INVENTORY)){
                ItemStack stack = event.getCurrentItem();
                Player player = (Player) event.getWhoClicked();
                World world = player.getWorld();
                ItemStack s = stack.asOne();
                int slot = event.getSlot();
                ArrayList<ItemStack> items = new ArrayList<>();
                for (int i = 0; i < stack.getAmount(); i++) {
                    items.add(s);
                }
                Inventory i = player.getInventory();
                int index = 0;
                for (ItemStack content : i.getStorageContents()) {
                    if(content == null){
                        i.setItem(index,items.get(0));
                        items.remove(0);
                    }
                    index ++;
                }
                if(items.size() != 0){
                    for (ItemStack item : items) {
                        world.dropItem(player.getLocation(),item);
                    }
                }
                inventory.setItem(slot,null);
                event.setResult(Event.Result.DENY);
            }
        }
    }
}
