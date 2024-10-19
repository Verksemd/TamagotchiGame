package Logic

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Paths
import java.util.Date
import kotlin.system.exitProcess

class Save {
    companion object {
        private var temporary: Save? = null
        val SAVE_DIR: String = Paths.get(System.getProperty("user.home"), "Tamagotchi").toString()
        private val SAVE_FILE: String = Paths.get(SAVE_DIR, "game_save.json").toString()

        @JvmStatic
        fun load() {
            val gson: Gson = GsonBuilder().create()
            try {
                FileReader(SAVE_FILE).use { reader ->
                    temporary = gson.fromJson(reader, Save::class.java)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                exitProcess(0)
            }
        }

        @JvmStatic
        fun createTemporary() {
            temporary = Save().apply {
                name = "Milashka"
                age = 0
                breed = "Australian Heeler"
                happiness = 100
                energy = 100
                fullness = 100
                cleanliness = 100
                savedAt = (Date().time / 1000).toInt()
            }
        }

        @JvmStatic
        fun getTemporary(): Save? {
            val result = temporary
            temporary = null
            return result
        }
    }

    var name: String = ""
    var age: Int = 0
    var breed: String = ""
    var fullness: Int = 0
    var cleanliness: Int = 0
    var energy: Int = 0
    var happiness: Int = 0
    var savedAt: Int = 0

    fun conserve() {
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        try {
            FileWriter(SAVE_FILE).use { writer ->
                gson.toJson(this, writer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}