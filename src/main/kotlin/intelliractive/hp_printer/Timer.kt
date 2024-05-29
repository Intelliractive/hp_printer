package intelliractive.hp_printer

import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable

class Timer(var seconds: Int, var onTick: () -> Unit = {}, var onTimeIsUp: () -> Unit = {}) {
    var state: String = "on"
    var runnable = object : BukkitRunnable() {
        override fun run() {
            if (seconds <= 0) {
                onTimeIsUp()
                // Timer has finished
                state = "off"
                cancel()
            } else {
                onTick()
                // Decrement the timer
                seconds--
            }
        }
    }

    fun countDown() {
        runnable.runTaskTimer(Bukkit.getPluginManager().getPlugin("hp_printer")!!, 0, 20)
    }
}