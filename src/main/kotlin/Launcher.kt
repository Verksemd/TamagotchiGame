import Logic.Save
import UI.MainWindow
import java.io.File

object Launcher {
    @JvmStatic
    fun main(args: Array<String>) {
        val saveDir = File(Save.SAVE_DIR)
        if (!saveDir.exists()) {
            saveDir.mkdirs()
        }
        MainWindow()
    }
}
