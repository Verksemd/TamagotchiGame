import Logic.Save;
import UI.MainWindow;
import java.io.File;

public class Launcher {
    public static void main(String[] args) {
        File saveDir = new File(Save.SAVE_DIR);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        new MainWindow();
    }
}
