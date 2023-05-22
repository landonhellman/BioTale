package Main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

import Main.Main;

import static java.lang.System.exit;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    final int scalePlayer = 2;
    public int score;
    public int lives = 8;

    public int tileSize = originalTileSize * scale; // 48x48 tile
    public int tileSizePlayer = originalTileSize * scalePlayer;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    // FPS
    int FPS = 60;
    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    public CollisionChecker cChecker = new CollisionChecker(this);
    Thread gameThread;
    Player player = new Player(this, keyH);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

//    @Override
/*    public void run() {
        double drawInterval = (double) 1000000000/FPS; // 0.01666 sec
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null) {

            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    public void run() {
        double drawInterval = (double) 1000000000/FPS; // 0.01666 sec
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }



            if(timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
            if (lives <= 0) {
                System.out.println("Oh no! The Bile got the pizza. Your final score was " + score + " points. Good job!");
                System.exit(0);
            }

        }
    }

    public void updateScore() {
        score++;
    }
    public void updateLife() {
        lives--;
    }
    public int getLives() {
        return lives;
    }

    public int playerX() {
        return player.x;
    }
    public int playerY() {
        return player.y;
    }

    public void update() {
        player.update();
        tileM.updateBlock0();
        tileM.updateBlock1();
        tileM.updateBlock2();
        tileM.updateBlock3();
        tileM.updateSpeed();
        updateScore();
        System.out.println("Your score is: " + score + ". You have " + lives + " left.");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }


}
