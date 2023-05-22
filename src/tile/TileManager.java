package tile;

import Main.GamePanel;
import entity.Entity;
import entity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;
    int xLocation0 = 144;
    int xLocation1 = 96;
    int xLocation2= 192;
    int xLocation3= 240;
    int xLocation4 = 672;
    int yLocation4 = 700;
    int yLocation0 = (int) (Math.random() * 336);
    int yLocation1 = (int) (Math.random() * 336);
    int yLocation2 = (int) (Math.random() * 336);
    int yLocation3 = (int) (Math.random() * 336);
    double speed = 3;

    public TileManager(GamePanel gp) {

        this.gp = gp;
        tile = new Tile[200];
        getTileImage();
    }

    public void getTileImage() {
        try {
            for(int i = 0; i < 145; i++) {
                tile[i] = new Tile();
            }
            for(int i = 0; i < 24; i++) {
                tile[i].image = ImageIO.read(getClass().getResourceAsStream("/tiles/liver.png"));
            }
            for(int i = 24; i < 38; i++) {
                tile[i].image = ImageIO.read(getClass().getResourceAsStream("/tiles/hcl.png"));
            }
            for(int i = 38; i < 141; i++) {
                tile[i].image = ImageIO.read(getClass().getResourceAsStream("/tiles/background.png"));
            }
            for(int i = 141; i < 145; i++) {
                tile[i].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bile.png"));
                tile[i].collision = true;
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int i = 0; i < 9; i++) {
            g2.drawImage(tile[i].image, 0, (48*i), gp.tileSize, gp.tileSize, null);
        }
        for (int i = 0; i < 9; i++) {
            g2.drawImage(tile[i+12].image, 48, (48*i), gp.tileSize, gp.tileSize, null);
        }
        for (int i = 0; i < 20; i++) {
            g2.drawImage(tile[i+24].image, (96 + (48*i)), 384, gp.tileSize, gp.tileSize, null);
        }
        for (int i = 2; i < 16; i++) {
            for (int x = 0; x < 8; x++) {
                g2.drawImage(tile[i + 37].image, (i * 48), (x * 48), gp.tileSize, gp.tileSize, null);
            }
        }
        g2.drawImage(tile[141].image, xLocation0, yLocation0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[142].image, xLocation1, yLocation1, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[143].image, xLocation2, yLocation2, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[144].image, xLocation3, yLocation3, gp.tileSize, gp.tileSize, null);


    }

    public void checkerTile0(Player player) {
        if (((player.getX() + 48) <= (xLocation0 + 65)) && ((player.getX() + 48) >= (xLocation0 + 31))) {
            if (player.getY() > yLocation0 && (player.getY()) < (yLocation0 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation0 = 96;
                yLocation0 = (int) (Math.random() * 336);
            }
            if ((player.getY() + 43) >= yLocation0 && (player.getY() + 20) <= yLocation0) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation0 = 96;
                yLocation0 = (int) (Math.random() * 336);
            }
            if ((player.getY() - 8) <= (yLocation0 + 48) && (player.getY() + 18) >= (yLocation0 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation0 = 96;
                yLocation0 = (int) (Math.random() * 336);
            }
        }

    }
    public void checkerTile1(Player player) {
        if (((player.getX() + 48) <= (xLocation1 + 65)) && ((player.getX() + 48) >= (xLocation1 + 31))) {
            if (player.getY() > yLocation1 && (player.getY()) < (yLocation1 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation1 = 96;
                yLocation1 = (int) (Math.random() * 336);
            }
            if ((player.getY() + 43) >= yLocation1 && (player.getY() + 20) <= yLocation1) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation1 = 96;
                yLocation1 = (int) (Math.random() * 336);
            }
            if ((player.getY() - 8) <= (yLocation1 + 48) && (player.getY() + 18) >= (yLocation1 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation1 = 96;
                yLocation1 = (int) (Math.random() * 336);
            }
        }

    }
    public void checkerTile2(Player player) {
        if (((player.getX() + 48) <= (xLocation2 + 65)) && ((player.getX() + 48) >= (xLocation2 + 31))) {
            if (player.getY() > yLocation2 && (player.getY()) < (yLocation2 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation2 = 96;
                yLocation2 = (int) (Math.random() * 336);
            }
            if ((player.getY() + 43) >= yLocation2 && (player.getY() + 20) <= yLocation2) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation2 = 96;
                yLocation2 = (int) (Math.random() * 336);
            }
            if ((player.getY() - 8) <= (yLocation2 + 48) && (player.getY() + 18) >= (yLocation2 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation2 = 96;
                yLocation2 = (int) (Math.random() * 336);
            }
        }

    }
    public void checkerTile3(Player player) {
        if (((player.getX() + 48) <= (xLocation3 + 65)) && ((player.getX() + 48) >= (xLocation3 + 31))) {
            if (player.getY() > yLocation3 && (player.getY()) < (yLocation3 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation3 = 96;
                yLocation3 = (int) (Math.random() * 336);
            }
            if ((player.getY() + 43) >= yLocation3 && (player.getY() + 20) <= yLocation3) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation3 = 96;
                yLocation3 = (int) (Math.random() * 336);
            }
            if ((player.getY() - 8) <= (yLocation3 + 48) && (player.getY() + 18) >= (yLocation3 + 48)) {
                player.collisionOn = false;
                gp.updateLife();
                xLocation3 = 96;
                yLocation3 = (int) (Math.random() * 336);
            }
        }

    }
    public void updateSpeed() {
        if (speed < 12) {
            speed += 0.01;
        }
    }
    public void updateBlock0() {
        xLocation0+=speed;
        if (xLocation0 > 720) {
            xLocation0 = 96;
            yLocation0 = (int) (Math.random() * 336);
        }
    }
    public void updateBlock1() {
        xLocation1+=speed;
        if (xLocation1 > 720) {
            xLocation1 = 96;
            yLocation1 = (int) (Math.random() * 336);
        }
    }
    public void updateBlock2() {
        xLocation2+=speed;
        if (xLocation2 > 720) {
            xLocation2 = 96;
            yLocation2 = (int) (Math.random() * 336);
        }
    }
    public void updateBlock3() {
        xLocation3+=speed;
        if (xLocation3 > 720) {
            xLocation3 = 96;
            yLocation3 = (int) (Math.random() * 336);
        }
    }
}
