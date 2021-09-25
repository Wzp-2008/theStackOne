package org.wzpmc.thestackone.Events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;

public class OnPlayerCraft implements Listener {
    @EventHandler
    public void OnPlayerCraft(CraftItemEvent event) {
        Recipe recipe = event.getRecipe();
        ItemStack stack = recipe.getResult();
        CraftingInventory ci = event.getInventory();
        for (int i = 0; i < ci.getSize(); i++) {
            ci.setItem(i,null);
        }
        Player player = (Player) event.getWhoClicked();
        World world = player.getWorld();
        ItemStack s = stack.asOne();
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
    }
}
