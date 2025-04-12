import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Create a StartMenu instance
        StartMenu startMenu = new StartMenu();
        startMenu.setVisible(true);
        // Set the default close operation
        startMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size and location of the StartMenu
        startMenu.setSize(360, 640);
        startMenu.setLocationRelativeTo(null);
        startMenu.setResizable(false);
        // Set the StartMenu to be visible
        startMenu.setVisible(true);
    }
}
