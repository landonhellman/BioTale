package Main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }


    public void checkTile(Entity entity) {
        System.out.println("1");
        int entityLeftWorldX = entity.solidArea.x;
        System.out.println("B");
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        System.out.println("C");
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        System.out.println("D");
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        System.out.println("E");

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        System.out.println("F");
        int entityRightCol = entityRightWorldX/gp.tileSize;
        System.out.println("G");
        int entityTopRow = entityTopWorldY/gp.tileSize;
        System.out.println("H");
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        System.out.println("I");

        int tileNum1, tileNum2;
        System.out.println("J");


        switch(entity.direction) {
            case "up":
                System.out.println("1");
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                System.out.println("2");
                //tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                System.out.println("3");
                //tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                System.out.println("4");
                if (gp.tileM.tile[141].collision || gp.tileM.tile[142].collision || gp.tileM.tile[143].collision || gp.tileM.tile[144].collision) {
                    System.out.println("5");
                    entity.collisionOn = true;
                }
                System.out.println("6 break");
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }

    }
}
