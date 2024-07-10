package Logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Save {
    public static final String SAVE_DIR =
            Paths.get(System.getProperty("user.home"), "Tamagotchi").toString();
    private static final String SAVE_FILE = Paths.get(SAVE_DIR, "game_save.json").toString();
    public String name;
    public int age;
    public String breed;
    public int fullness;
    public int cleanliness;
    public int energy;
    public int happiness;
    public int savedAt;

    public static Save load() {
        Gson gson = new GsonBuilder().create();
        Save mySave = null;
        try (FileReader reader = new FileReader(Save.SAVE_FILE)) {
            mySave = gson.fromJson(reader, Save.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return mySave;
    }

    public void conserve() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(Save.SAVE_FILE)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
