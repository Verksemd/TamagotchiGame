package Logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

public class Save {
    private static Save temporary;
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

    public static void load() {
        Gson gson = new GsonBuilder().create();
        Save mySave = null;
        try (FileReader reader = new FileReader(Save.SAVE_FILE)) {
            mySave = gson.fromJson(reader, Save.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        temporary = mySave;
    }

    public void conserve() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(Save.SAVE_FILE)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTemporary() {
        temporary = new Save();
        temporary.name = "Milashka";
        temporary.age = 0;
        temporary.breed = "Australian Heeler";
        temporary.happiness = 100;
        temporary.energy = 100;
        temporary.fullness = 100;
        temporary.cleanliness = 100;
        temporary.savedAt = (int) (new Date().getTime() / 1000);
    }

    public static Save getTemporary() {
        Save result = temporary;

        temporary = null;

        return result;
    }
}
