package entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
    }

    public void setDefaultValues() {

        x = 700;
        y = 150;
        speed = 4;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void update() {
        collisionOn = false;
        gp.tileM.checkerTile0(this);
        gp.tileM.checkerTile1(this);
        gp.tileM.checkerTile2(this);
        gp.tileM.checkerTile3(this);
        if ((keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) && (!collisionOn)) {
            if(keyH.upPressed) {
                if (y > 0) {
                    direction = "up";
                    y -= speed;
                }
            }
            else if (keyH.downPressed) {
                if (y < 336) {
                    direction = "down";
                    y += speed;
                }
            }
            else if (keyH.leftPressed) {
                if (x > 96) {
                    direction = "left";
                    x -= speed;
                }
            }
            else if (keyH.rightPressed) {
                if (x < 720) {
                    direction = "right";
                    x += speed;
                }
            }

//            if (!collisionOn) {
//                switch (direction) {
//                    case "up":
//                        y -= speed;
//                        break;
//                    case "down":
//                        y += speed;
//                        break;
//                    case "left":
//                        x -= speed;
//                        break;
//                    case "right":
//                        x += speed;
//                        break;
//                }
//            }
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSizePlayer, gp.tileSizePlayer);
        try {
            if (gp.getLives() == 8) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/pizza8.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
            if (gp.getLives() == 7) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/hcl.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
            if (gp.getLives() == 6) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/pizza8.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
            if (gp.getLives() == 5) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/hcl.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
            if (gp.getLives() == 4) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/pizza8.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
            if (gp.getLives() == 3) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/hcl.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
            if (gp.getLives() == 2) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/pizza8.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
            if (gp.getLives() == 1) {
                g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/tiles/hcl.png")), x, y, gp.tileSizePlayer, gp.tileSizePlayer, null);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }



}
