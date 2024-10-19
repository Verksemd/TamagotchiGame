package UI.Scene;

import java.awt.*;
import javax.swing.*;

interface Scene {
    fun getMenu(): JMenuBar?

    fun toComponent(): Component;

    fun refresh();

    fun onClose();
}
