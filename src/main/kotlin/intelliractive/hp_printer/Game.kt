package intelliractive.hp_printer

import org.bukkit.*
import org.bukkit.Bukkit.*
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.entity.FallingBlock
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import kotlin.math.roundToInt

class Game(val plugin: Hp_printer) : Listener {
    private var isGamePlayable = false

    private val world = getWorld("world")!!
    private fun blockAt(x: Int, y: Int, z: Int): Block {
        return world.getBlockAt(x, y, z)
    }

    private val output = listOf(
        // top
        listOf(
            Triple(-6, -46, -10),
            Triple(-5, -46, -10),
            Triple(-4, -46, -10),
            Triple(-3, -46, -10),
            Triple(-2, -46, -10),
            Triple(-1, -46, -10),
            Triple(0, -46, -10),
            Triple(1, -46, -10),
            Triple(2, -46, -10),
            Triple(3, -46, -10)
        ),
        listOf(
            Triple(-6, -47, -10),
            Triple(-5, -47, -10),
            Triple(-4, -47, -10),
            Triple(-3, -47, -10),
            Triple(-2, -47, -10),
            Triple(-1, -47, -10),
            Triple(0, -47, -10),
            Triple(1, -47, -10),
            Triple(2, -47, -10),
            Triple(3, -47, -10)
        ),
        listOf(
            Triple(-6, -48, -10),
            Triple(-5, -48, -10),
            Triple(-4, -48, -10),
            Triple(-3, -48, -10),
            Triple(-2, -48, -10),
            Triple(-1, -48, -10),
            Triple(0, -48, -10),
            Triple(1, -48, -10),
            Triple(2, -48, -10),
            Triple(3, -48, -10)
        ),
        listOf(
            Triple(-6, -49, -10),
            Triple(-5, -49, -10),
            Triple(-4, -49, -10),
            Triple(-3, -49, -10),
            Triple(-2, -49, -10),
            Triple(-1, -49, -10),
            Triple(0, -49, -10),
            Triple(1, -49, -10),
            Triple(2, -49, -10),
            Triple(3, -49, -10)
        ),
        listOf(
            Triple(-6, -50, -10),
            Triple(-5, -50, -10),
            Triple(-4, -50, -10),
            Triple(-3, -50, -10),
            Triple(-2, -50, -10),
            Triple(-1, -50, -10),
            Triple(0, -50, -10),
            Triple(1, -50, -10),
            Triple(2, -50, -10),
            Triple(3, -50, -10)
        ),
        listOf(
            Triple(-6, -51, -10),
            Triple(-5, -51, -10),
            Triple(-4, -51, -10),
            Triple(-3, -51, -10),
            Triple(-2, -51, -10),
            Triple(-1, -51, -10),
            Triple(0, -51, -10),
            Triple(1, -51, -10),
            Triple(2, -51, -10),
            Triple(3, -51, -10)
        ),
        listOf(
            Triple(-6, -52, -10),
            Triple(-5, -52, -10),
            Triple(-4, -52, -10),
            Triple(-3, -52, -10),
            Triple(-2, -52, -10),
            Triple(-1, -52, -10),
            Triple(0, -52, -10),
            Triple(1, -52, -10),
            Triple(2, -52, -10),
            Triple(3, -52, -10)
        ),
        listOf(
            Triple(-6, -53, -10),
            Triple(-5, -53, -10),
            Triple(-4, -53, -10),
            Triple(-3, -53, -10),
            Triple(-2, -53, -10),
            Triple(-1, -53, -10),
            Triple(0, -53, -10),
            Triple(1, -53, -10),
            Triple(2, -53, -10),
            Triple(3, -53, -10)
        ),
        listOf(
            Triple(-6, -54, -10),
            Triple(-5, -54, -10),
            Triple(-4, -54, -10),
            Triple(-3, -54, -10),
            Triple(-2, -54, -10),
            Triple(-1, -54, -10),
            Triple(0, -54, -10),
            Triple(1, -54, -10),
            Triple(2, -54, -10),
            Triple(3, -54, -10)
        ),
        listOf(
            Triple(-6, -55, -10),
            Triple(-5, -55, -10),
            Triple(-4, -55, -10),
            Triple(-3, -55, -10),
            Triple(-2, -55, -10),
            Triple(-1, -55, -10),
            Triple(0, -55, -10),
            Triple(1, -55, -10),
            Triple(2, -55, -10),
            Triple(3, -55, -10)
        )
        // bottom
    )

    private val playingArea = listOf(
        // left
        blockAt(-6, -55, 3),
        blockAt(-5, -55, 3),
        blockAt(-4, -55, 3),
        blockAt(-3, -55, 3),
        blockAt(-2, -55, 3),
        blockAt(-1, -55, 3),
        blockAt(0, -55, 3),
        blockAt(1, -55, 3),
        blockAt(2, -55, 3),
        blockAt(3, -55, 3)
        // right
    )

    private var gameStartTimer = Timer(5).apply {
        onTick = {
            if (getServer().onlinePlayers.size == 10) {
                dispatchCommand(getConsoleSender(), "playsound minecraft:block.bell.use ambient @a")
                broadcastMessage("${ChatColor.GREEN}Starting in ${seconds}s${ChatColor.RESET}")
            }
            else {
                waitForMorePlayers()
                runnable.cancel()
            }
        }
        onTimeIsUp = {
            if (getServer().onlinePlayers.size == 10) {
                isGamePlayable = true
                prepare()
            } else
                waitForMorePlayers()
        }
    }

    // count down from 10 to 0 if there are 10 players
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.player.gameMode = GameMode.ADVENTURE

        if (getServer().onlinePlayers.size == 10) {
            gameStartTimer.countDown()
        }
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        isGamePlayable = false
    }

    fun waitForMorePlayers() {
        broadcastMessage("${ChatColor.RED}Not enough players to start. Waiting for more${ChatColor.RESET}")
    }

    // pick the picture players will be printing
    val pic = Picture.entries.random()

    fun prepare() {
        // give the reference to the players
        getServer().onlinePlayers.forEach {
            dispatchCommand(
                getConsoleSender(),
                "give ${it.name} filled_map{map:${pic.mapId}}"
            )
        }
        // send a message to everyone what picture are they 'printing'
        broadcastMessage("${ChatColor.AQUA}You are printing ${ChatColor.RESET}${ChatColor.UNDERLINE}${pic.title}${ChatColor.RESET}")
        // also send a title
        getServer().onlinePlayers.forEach {
            it.sendTitle(pic.title, pic.subtitle, 10, 40, 10)
        }
        // hand out pic's materials
        broadcastMessage("${ChatColor.GOLD}This picture is made of ${ChatColor.UNDERLINE}${pic.materials.size}${ChatColor.RESET} materials. You are given them${ChatColor.RESET}")

        for (material in pic.materials.map { it.toString().lowercase() }) {
            dispatchCommand(
                getConsoleSender(),
                "give @a $material 1"
            )
        }

        // some time to look through the set of resources
        val preparationTimer = Timer(3).apply {
            onTick = {
                if (getServer().onlinePlayers.size == 10 && isGamePlayable) {
                    dispatchCommand(getConsoleSender(), "playsound minecraft:block.note_block.didgeridoo ambient @a")
                    broadcastMessage("${ChatColor.DARK_GREEN}Get ready in ${seconds}s${ChatColor.RESET}")
                } else {
                    waitForMorePlayers()
                    runnable.cancel()
                }
            }
            onTimeIsUp = {
                if (getServer().onlinePlayers.size == 10 && isGamePlayable)
                    play()
                else
                    waitForMorePlayers()
            }
        }
        preparationTimer.countDown()
    }


    fun validateLine(line: List<Material>, round: Int) {
        if (line != output.reversed()[round].map { loc -> blockAt(loc.first, loc.second, loc.third) }) lose(round)
    }

    fun printLine(round: Int) {
        for (block in output.reversed()[round]) {
            for (player in getServer().onlinePlayers) {
                if (player.location.x.roundToInt() == block.first)
                    blockAt(block.first, block.second, block.third).type = player.inventory.itemInMainHand.type
            }
        }
    }

    fun play() {
        broadcastMessage("►${ChatColor.BLACK}S${ChatColor.RESET}T${ChatColor.BLACK}A${ChatColor.RESET}R${ChatColor.BLACK}${ChatColor.RESET}T!!!")

        var round = 0

        // game rounds
        // Changing title timing here!
        dispatchCommand(getConsoleSender(), "title @a times 10 40 10")
        for (line in pic.lines.reversed()) {
            if (isGamePlayable) {
                dispatchCommand(
                    getConsoleSender(),
                    "title @a actionbar {\"text\": \"Get in place with the correct block in hand!\", \"color\": \"yellow\"}"
                )

                val roundTimer = Timer(10).apply {
                    onTick = {
                        dispatchCommand(getConsoleSender(), "playsound minecraft:block.note_block.chime ambient @a")
                        dispatchCommand(
                            getConsoleSender(),
                            "title @a actionbar {\"text\": \"== $seconds ==\", \"color\": \"dark_yellow\"}"
                        )
                    }
                    onTimeIsUp = {
                        printLine(round)
                        validateLine(line, round)
                        round += 1
                    }
                }
                roundTimer.countDown()
            } else
                lose(round)
        }
        win(round)
    }

    fun win(result: Int) {
        broadcastMessage("${ChatColor.WHITE}${ChatColor.MAGIC}${ChatColor.RESET}${ChatColor.GREEN}${ChatColor.BOLD}${ChatColor.UNDERLINE}==== YOU WIN ====${ChatColor.RESET}${ChatColor.WHITE}${ChatColor.MAGIC}${ChatColor.RESET}")
        broadcastMessage("${ChatColor.LIGHT_PURPLE}${ChatColor.BOLD}${ChatColor.ITALIC}You made $result lines out of ${pic.lines.size}!${ChatColor.RESET}")
        // play victory sound
        getServer().onlinePlayers.forEach {
            it.gameMode = GameMode.SPECTATOR
            it.playNote(it.location, Instrument.CHIME, Note.natural(5, Note.Tone.G))
        }
    }

    fun lose(result: Int) {
        broadcastMessage("${ChatColor.WHITE}${ChatColor.MAGIC}${ChatColor.RESET}${ChatColor.DARK_RED}${ChatColor.BOLD}${ChatColor.UNDERLINE}==== GAME OVER ====${ChatColor.RESET}${ChatColor.WHITE}${ChatColor.MAGIC}${ChatColor.RESET}")
        broadcastMessage("${ChatColor.LIGHT_PURPLE}${ChatColor.BOLD}${ChatColor.ITALIC}You made $result lines out of ${pic.lines.size}!${ChatColor.RESET}")
        // play anvil sound
        dispatchCommand(getConsoleSender(), "playsound minecraft:block.anvil.land ambient @a")
        getServer().onlinePlayers.forEach { it.gameMode = GameMode.SPECTATOR }
    }
}
