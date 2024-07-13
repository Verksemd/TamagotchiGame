package UI;

import java.awt.*;
import javax.swing.*;

public interface Scene {
    JMenuBar getMenu();

    Component toComponent();

    void refresh();
}
