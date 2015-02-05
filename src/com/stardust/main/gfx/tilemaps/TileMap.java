package com.stardust.main.gfx.tilemaps;

import com.stardust.main.gfx.Assets;
import com.stardust.main.Game;
import com.stardust.main.StateEngine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TileMap
{   
   
   private final int TILE_SIZE = 32;
   private final int WORLD_TILE = 50;
   private final int STORE_TILE = 20;
   private int numTiles;
   //placeholder for each tile 
   public static BufferedImage[] tiles = new BufferedImage[45];
   public static Tile[] tileImage = new Tile[45];
   
   //array of tile types
   public int[][] map = new int[TILE_SIZE][TILE_SIZE];
   public int[][] worldMap = new int[WORLD_TILE][WORLD_TILE];
   public int[][] storeMap = new int[STORE_TILE][STORE_TILE];
   //position coordinates
   private int posX, posY;
   //Edge of map Cooridinates
   public static int sx, sy, wsx, wsy, stx, sty;
   private String fileName;
   public static int x = 0, y = 0;
   
   public TileMap(int posX, int posY, String fileName, int numTiles) throws IOException
   {
       this.numTiles = numTiles;
       this.fileName = fileName;
       this.posX = posX;
       this.posY = posY;
       if(numTiles == TILE_SIZE)
       {
            this.sx = map.length * TILE_SIZE;
            this.sy = map.length * TILE_SIZE;
       }
       if(numTiles == WORLD_TILE)
       {
           this.wsx = worldMap.length * TILE_SIZE;
           this.wsy = worldMap.length * TILE_SIZE;
       }
       if(numTiles == STORE_TILE)
       {
           this.stx = storeMap.length * TILE_SIZE;
           this.sty = storeMap.length * TILE_SIZE;
       }
       setTile();       
   }
   
   public void render(Graphics g)
   {
       if(Game.stateEngine.state == StateEngine.GameState.STATE_TOWN)
       {
           
            for(int y = 0; y < numTiles; y++)
            {       
                for(int x = 0; x < numTiles; x++)
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
       if(Game.stateEngine.state == StateEngine.GameState.STATE_WORLD)
       {
           for(int y = 0; y < numTiles; y++)
            {       
                for(int x = 0; x < numTiles; x++)
                {
                    int textureType = worldMap[x][y];
                    BufferedImage texture = tiles[textureType]; 
                    g.drawImage(texture, posX, posY, null);
                    posY += TILE_SIZE;
                }
                posX += TILE_SIZE;
                posY = Game.wMapY;
            }
            posX = Game.wMapX;
            posY = Game.wMapY;
       }
       
       if(Game.stateEngine.state == StateEngine.GameState.STATE_SHOP)
       {
           
            for(int y = 0; y < numTiles; y++)
            {       
                for(int x = 0; x < numTiles; x++)
                {
                    int textureType = storeMap[x][y];
                    BufferedImage texture = tiles[textureType]; 
                    g.drawImage(texture, posX, posY, null);
                    posY += TILE_SIZE;
                }
                posX += TILE_SIZE;
                posY = Game.sMapY;
            }
            posX = Game.sMapX;
            posY = Game.sMapY;
       }
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
       tiles[37] = Assets.townTile;
       tiles[38] = Assets.mtnTile;
       tiles[39] = Assets.mtnTileLt;
       tiles[40] = Assets.mtnTileRt;
       tiles[41] = Assets.mtnTileCtTp;
       tiles[42] = Assets.mtnTileLtTp;
       tiles[43] = Assets.mtnTileRtTp;
       tiles[44] = Assets.mtnCave;
   }
   
   public void fileParser() throws IOException
   {
       BufferedReader in = new BufferedReader(new FileReader(fileName));
       
       String line;           
       if(numTiles == TILE_SIZE)
       {
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
       }
       
       if(numTiles == WORLD_TILE)
       {
           while((line = in.readLine()) != null)
           {
                String[] values = line.split(",");

                for(String str : values)
                {
                    int str_int = Integer.parseInt(str);
                    worldMap[x][y] = str_int;
                    ++y;
                }
                ++x;
                y = 0;
            }
            x = 0;
       }
       
       if(numTiles == STORE_TILE)
       {
           while((line = in.readLine()) != null)
           {
                String[] values = line.split(",");

                for(String str : values)
                {
                    int str_int = Integer.parseInt(str);
                    storeMap[x][y] = str_int;
                    ++y;
                }
                ++x;
                y = 0;
            }
            x = 0;
       }
       
       in.close();
   } 
   
   public static void setTileImage()
   {
       for(int i = 0; i < tiles.length; i++)
       {
           tileImage[i].Tile(tiles[i], i);
       }
   }
}
