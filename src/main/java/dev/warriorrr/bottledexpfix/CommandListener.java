package dev.warriorrr.bottledexpfix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (!event.getMessage().startsWith("/bottle store"))
            return;
        
        int amountOrdered = 0;

        try {
            amountOrdered = Integer.parseInt(event.getMessage().split(" ")[2]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return;
        }

        if (amountOrdered < 0)
            event.setMessage("/bottle store 0"); //Will cause bottledexp to send the standard usage message.
    }
}
