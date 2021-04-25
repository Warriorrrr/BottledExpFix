package dev.warriorrr.bottledexpfix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (!event.getMessage().startsWith("/bottle store"))
            return;
        
        String[] message = event.getMessage().split(" ");
        if (message.length < 3)
            return;
        
        int amountOrdered = 0;
        try {
            amountOrdered = Integer.parseInt(message[2]);
        } catch (NumberFormatException e) {
            return;
        }

        if (amountOrdered < 0)
            event.setCancelled(true);
    }
}
