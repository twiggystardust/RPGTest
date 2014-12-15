package com.stardust.main;

import com.stardust.main.gfx.Assets;
import com.stardust.main.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TileMap
{   
   
   private final static int TILE_SIZE = 32;
   private int numTiles;
   //placeholder for each tile 
   private static BufferedImage[] tiles = new BufferedImage[37];
   
   //array of tile types
   private int[][] map = new int[TILE_SIZE][TILE_SIZE];
   //position coordinates
   private int posX, posY;
   //Edge of map Cooridinates
   public static int sx, sy;
   private String fileName;
   public static int x = 0, y = 0;
   
   public TileMap(int posX, int posY, String fileName, int numTiles) throws IOException
   {
       this.numTiles = numTiles;
       this.fileName = fileName;
       this.posX = posX;
       this.posY = posY;
       this.sx = map.length * numTiles;
       this.sy = map.length * numTiles;
       
       setTile();
       
   }
   
   public void render(Graphics g)
   {
       for(int y = 0; y < numTiles; y++)
       {       
           for(int  x= 0; x < numTiles; x++)
           {
               int textureType = map[x][y];
               BufferedImage texture = tiles[textureType]; 
               g.drawImage(texture, posX, posY, null);
               posY += TILE_SIZE;
           }
           posX += TILE_SIZE;
           posY = Game.mapY;
       }
       posX = Game.mapX;
       posY = Game.mapY;
       
   }

    
   private static void setTile()
   {
       tiles[0] = Assets.grass;
       tiles[1] = Assets.dirt;
       tiles[2] = Assets.water;
       tiles[3] = Assets.tree;
       tiles[4] = Assets.multiTree;
       tiles[5] = Assets.NSpath;
       tiles[6] = Assets.uprtPath;
       tiles[7] = Assets.EWpath;
       tiles[8] = Assets.upltPath;
       tiles[9] = Assets.dnltPath;
       tiles[10] = Assets.dnrtPath;
       tiles[11] = Assets.watgrsdn;
       tiles[12] = Assets.watgrslt;
       tiles[13] = Assets.watgrsup;
       tiles[14] = Assets.watgrsrt;
       tiles[15] = Assets.watgrsSE;
       tiles[16] = Assets.watgrsSW;
       tiles[17] = Assets.watgrsNW;
       tiles[18] = Assets.watgrsNE;
       tiles[19] = Assets.wallWood;
       tiles[20] = Assets.pointer;
       tiles[21] = Assets.pathOpRt;
       tiles[22] = Assets.pathOpLt;
       tiles[23] = Assets.pathOpDn;
       tiles[24] = Assets.pathOpUp;
       tiles[25] = Assets.pathOpAll;
       tiles[26] = Assets.roughWood;
       tiles[27] = Assets.pathOpen;
       tiles[28] = Assets.counter;
       tiles[29] = Assets.storeDude;
       tiles[30] = Assets.pot;
       tiles[31] = Assets.singleHouse;
       tiles[32] = Assets.doubleHouse;
       tiles[33] = Assets.wepBanner;
       tiles[34] = Assets.armBanner;
       tiles[35] = Assets.innBanner;
       tiles[36] = Assets.blankTile;
   }
   
   public void fileParser() throws IOException
   {
       BufferedReader in = new BufferedReader(new FileReader(fileName));
       
       String line;
       
       while((line = in.readLine()) != null)
       {
           String[] values = line.split(",");
           
           for(String str : values)
           {
               int str_int = Integer.parseInt(str);
               map[x][y] = str_int;
               ++y;
           }
           ++x;
           y = 0;
       }
       x = 0;
       
       in.close();
   }         
}
