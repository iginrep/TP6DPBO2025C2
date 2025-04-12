import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {
    public StartMenu() {
        // Set up the JFrame
        setTitle("Start Menu");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create a panel for the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        // Create a button to start the game
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the StartMenu and open the FlappyBird game
                dispose();
                JFrame gameFrame = new JFrame("Flappy Bird");
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setSize(360, 640);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.setResizable(false);

                FlappyBird flappyBird = new FlappyBird();
                gameFrame.add(flappyBird);
                gameFrame.pack();
                flappyBird.requestFocus();
                gameFrame.setVisible(true);
            }
        });

        // Create a button to exit the application
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });

        // Add the buttons to the panel
        panel.add(startButton);
        panel.add(exitButton);

        // Add the panel to the frame
        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);
    }
}