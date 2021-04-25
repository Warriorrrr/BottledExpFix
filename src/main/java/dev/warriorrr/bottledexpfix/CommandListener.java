package dev.warriorrr.bottledexpfix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (!event.getMessage().startsWith("/bottle store"))
            return;
        
        String[] message = event.getMessage().split(" ");
        int amountOrdered = 0;

        try {
            amountOrdered = Integer.parseInt(message[2]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return;
        }

        if (amountOrdered < 0)
            event.setCancelled(true);
    }
}
