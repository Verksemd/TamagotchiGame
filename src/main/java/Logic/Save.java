package Logic;

import java.nio.file.Paths;

public class Save {
    public static final String SAVE_DIR =
            Paths.get(System.getProperty("user.home"), "Tamagotchi").toString();
    public static final String SAVE_FILE = Paths.get(SAVE_DIR, "game_save.json").toString();
    public String name;
    public int age;
    public String breed;
    public int fullness;
    public int cleanliness;
    public int energy;
    public int happiness;
}
