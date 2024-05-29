package intelliractive.hp_printer;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Hp_printer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new Game(this), this);
        getLogger().log(Level.FINEST, "Printer mini-game's loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
