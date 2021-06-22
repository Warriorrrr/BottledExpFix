package dev.warriorrr.bottledexpfix;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class BottledExpFix extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler(ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().startsWith("/bottle store max"))
            event.setMessage("/bottle store " + event.getPlayer().getLevel() + "L");
    }

    @EventHandler
    public void onAnvilUse(PrepareAnvilEvent event) {
        ItemStack firstItem = event.getInventory().getItem(0);
        if (firstItem == null || !firstItem.getType().equals(Material.EXPERIENCE_BOTTLE))
            return;

        ItemMeta meta = firstItem.getItemMeta();
        if (meta == null || meta.getLore() == null)
            return;

        if (meta.getLore().get(0).contains("Stored Exp:"))
            event.setResult(null);
    }
}
