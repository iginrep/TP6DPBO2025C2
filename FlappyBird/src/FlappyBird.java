import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.KeyEvent;


public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int frameWidth = 360;
    int frameHeight = 640;

    // image attributes
    Image backgroundImage;

    Image birdImage;

    Image lowerPipeImage;

    Image upperPipeImage;

    // Player
    int playerStartPosX = frameWidth / 8;

    int playerStartPosY = frameHeight / 2;

    int playerWidth = 34;

    int playerHeight = 24;

    Player player;

    // pipes attributes
    int pipeStartPosX = frameWidth;

    int pipeStartPosY = 0;

    int pipeWidth = 64;

    int pipeHeight = 512;

    ArrayList<Pipe> pipes;

    //game logic
    Timer gameloop;

    Timer pipesCooldown;

    int gravity = 1;

    int score = 0;
    JLabel scoreLabel;

    // Constructor
    public FlappyBird(){
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setFocusable(true);
        addKeyListener(this);

        // Load images
        backgroundImage = new ImageIcon("src/assets/background.png").getImage();
        birdImage = new ImageIcon("src/assets/bird.png").getImage();
        lowerPipeImage = new ImageIcon("src/assets/lowerPipe.png").getImage();
        upperPipeImage = new ImageIcon("src/assets/upperPipe.png").getImage();

        // Create player
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();

        // Create pipes
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pipa");
                placePipes();
            }
        });
        pipesCooldown.start();

        gameloop = new Timer(1000/60, this);
        gameloop.start();

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        this.add(scoreLabel);
    }

    public void draw(Graphics g) {
        // Draw background
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null);

        // Draw player
        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);

        // Draw pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }
    }

    public void placePipes(){
        int randomPosY = (int) (pipeStartPosY - pipeHeight/4 - Math.random() * (pipeHeight/2));
        int openingSpace = frameHeight/4;

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeHeight), pipeWidth, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    public void move(){
        player .setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        for (int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipe.getVelocityX());

            // Deteksi tabrakan dengan pipa
            if (player.getBounds().intersects(pipe.getBounds())) {
                gameOver();
                return;
            }
        }

        // Periksa jika pemain jatuh ke bawah layar
        if (player.getPosY() + player.getHeight() >= frameHeight) {
            gameOver();
        }

        // Logika untuk menghitung skor
        for (int i = 0; i < pipes.size(); i += 2) { // Iterasi setiap 2 pipa (atas dan bawah)
            if (i + 1 < pipes.size()) { // Pastikan ada pasangan pipa
                Pipe upperPipe = pipes.get(i);
                Pipe lowerPipe = pipes.get(i + 1);

                if (!upperPipe.isPassed() && upperPipe.getPosX() + upperPipe.getWidth() < player.getPosX() &&
                        !lowerPipe.isPassed() && lowerPipe.getPosX() + lowerPipe.getWidth() < player.getPosX()) {
                    upperPipe.setPassed(true);
                    lowerPipe.setPassed(true);
                    score++;
                    scoreLabel.setText("Score: " + score);
                }
            }
        }
    }

    public void gameOver() {
        gameloop.stop();
        pipesCooldown.stop();
        JOptionPane.showMessageDialog(this, "Click 'R' if you want to restart the game.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void restartGame() {
        // Reset player position and velocity
        player.setPosX(playerStartPosX);
        player.setPosY(playerStartPosY);
        player.setVelocityY(0);

        // Clear pipes
        pipes.clear();

        // Restart timers
        gameloop.start();
        pipesCooldown.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setVelocityY(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
