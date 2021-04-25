package dev.warriorrr.bottledexpfix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BottledExpFix extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new CommandListener(), this);
    }
}
