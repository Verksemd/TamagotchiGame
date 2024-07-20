package UI.Scene;

import java.awt.*;
import javax.swing.*;

public interface Scene {
    JMenuBar getMenu();

    Component toComponent();

    void refresh();
}
