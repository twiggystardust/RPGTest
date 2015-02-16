package com.stardust.main.gfx;

import com.stardust.main.Game;
import java.awt.image.BufferedImage;

public class Assets 
{
     public ImageLoader loader;
     public static SpriteSheet sheet, playerSheet, menuSheet, itemSheet, skillSheet, equipSheet, statusSheet, npcSheet, dialogSheet;
     private BufferedImage tileImage, playerImage, menuImage, itemImage, skillImage, equipImage, statusImage, npcImage, textImage;
     public static BufferedImage grass, dirt, water, tree, multiTree, NSpath, uprtPath; 
     public static BufferedImage EWpath, upltPath, dnltPath, dnrtPath, sprite, watgrsdn;
     public static BufferedImage watgrslt, watgrsup, watgrsrt, watgrsSE, watgrsSW, watgrsNW;
     public static BufferedImage watgrsNE, pointer, pathOpRt, pathOpLt, pathOpDn, pathOpUp;
     public static BufferedImage pathOpAll, wallWood, roughWood, pathOpen, counter, storeDude, pot;
     public static BufferedImage playerUp, playerUp1, playerUp2, playerDn, playerDn1, playerDn2, playerLt, playerLt1, playerLt2, playerRt, playerRt1, playerRt2;
     public static BufferedImage npcUp, npcDn, npcLt, npcRt;
     public static BufferedImage singleHouse, doubleHouse, wepBanner, armBanner, innBanner, blankTile;
     public static BufferedImage mtnTile, mtnTileLt, mtnTileRt, mtnTileCtTp, mtnTileRtTp, mtnTileLtTp, mtnCave;
     public static BufferedImage menu, itemMenu, skillMenu, equipMenu, statusMenu, townTile, dialogBox;
     public static BufferedImage mtnWall, mtnWall1, mtnWall2,mtnWall3, mtnWall4, mtnWall5, mtnWall6, mtnWall7, mtnWall8, mtnWall9, mtnWall10;
     public static BufferedImage mtnWall11, mtnWall12, mtnWall13, mtnWall14, mtnWall15, mtnWall16, mtnWall17, mtnWall18, mtnWall19, mtnWall20, mtnWall21, mtnWall22;
     
     public Assets()
     {
         loader = new ImageLoader();
         
         tileImage = loader.load("/tileSheet.png");
         playerImage = loader.load("/newSpriteSheet11.png");
         npcImage = loader.load("/npcSpriteSheet.png");
         menuImage = loader.load("/menu.png");
         itemImage = loader.load("/itemMenu.png");
         skillImage = loader.load("/skillMenu.png");
         equipImage = loader.load("/equipMenu.png");
         statusImage = loader.load("/statusMenu.png");
         textImage = loader.load("/dialogBox.png");
         
         sheet = new SpriteSheet(tileImage);
         playerSheet = new SpriteSheet(playerImage);
         npcSheet = new SpriteSheet(npcImage);
         menuSheet = new SpriteSheet(menuImage);
         itemSheet = new SpriteSheet(itemImage);
         skillSheet = new SpriteSheet(skillImage);
         equipSheet = new SpriteSheet(equipImage);
         statusSheet = new SpriteSheet(statusImage);
         dialogSheet = new SpriteSheet(textImage);
         
         menu = menuSheet.crop(0, 0, 345, 345);
         itemMenu = itemSheet.crop(0, 0, 345, 345);
         skillMenu = skillSheet.crop(0, 0, 345, 345);
         equipMenu = equipSheet.crop(0, 0, 345, 345);
         statusMenu = statusSheet.crop(0, 0, 345, 345);
         dialogBox = dialogSheet.crop(0, 0, 635, 200);
         
         
         
         setTileImages();
         setPlayerImage();
         setNpcImage();
     }
     
     private void setTileImages()
     {
         
         grass = sheet.crop(0, 0, 32, 32);
         dirt = sheet.crop(1, 0, 32, 32);
         water = sheet.crop(2, 0, 32, 32);
         tree = sheet.crop(3, 0, 32, 32);
         multiTree = sheet.crop(4, 0, 32, 32);
         NSpath = sheet.crop(5, 0, 32, 32);
         uprtPath = sheet.crop(6, 0, 32, 32);
         EWpath = sheet.crop(7, 0, 32, 32);
         upltPath = sheet.crop(8, 0, 32, 32);
         dnltPath = sheet.crop(9, 0, 32, 32);
         dnrtPath = sheet.crop(9, 1, 32, 32);
         watgrsdn = sheet.crop(0, 1, 32, 32);
         watgrslt = sheet.crop(1, 1, 32, 32);
         watgrsup = sheet.crop(2, 1, 32, 32);
         watgrsrt = sheet.crop(3, 1, 32, 32);
         watgrsSE = sheet.crop(4, 1, 32, 32);
         watgrsSW = sheet.crop(5, 1, 32, 32);
         watgrsNW = sheet.crop(6, 1, 32, 32);
         watgrsNE = sheet.crop(7, 1, 32, 32);
         wallWood = sheet.crop(6, 3, 32, 32);
         pointer = sheet.crop(4, 2, 32, 32);
         pathOpRt = sheet.crop(5, 2, 32, 32);
         pathOpLt = sheet.crop(6, 2, 32, 32);
         pathOpDn = sheet.crop(7, 2, 32, 32);
         pathOpUp = sheet.crop(8, 2, 32, 32);
         pathOpAll = sheet.crop(9, 2, 32, 32);
         roughWood = sheet.crop(7, 3, 32, 32);
         pathOpen = sheet.crop(8, 3, 32, 32);
         counter = sheet.crop(9, 3, 32, 32);
         storeDude = sheet.crop(8, 4, 32, 32);
         pot = sheet.crop(9, 4, 32, 32);
         singleHouse = sheet.crop(0, 2, 96, 96);
         doubleHouse = sheet.crop(0, 5, 160, 96);
         wepBanner = sheet.crop(3, 3, 32, 32);
         armBanner = sheet.crop(3, 2, 32, 32);
         innBanner = sheet.crop(3, 4, 32, 32);
         blankTile = sheet.crop(4, 4, 32, 32);
         townTile = sheet.crop(5, 4, 64, 64);
         mtnTile = sheet.crop(8, 6, 32, 32);
         mtnTileLt = sheet.crop(7, 6, 32, 32);
         mtnTileRt = sheet.crop(9, 6, 32, 32);
         mtnTileCtTp = sheet.crop(8, 5, 32, 32);
         mtnTileRtTp = sheet.crop(9, 5, 32, 32);
         mtnTileLtTp = sheet.crop(7, 5, 32, 32);
         mtnCave = sheet.crop(6, 6, 32, 32);
         mtnWall = sheet.crop(5, 6, 32, 32);
         mtnWall1 = sheet.crop(5, 7, 32, 32);
         mtnWall2 = sheet.crop(6, 7, 32, 32);
         mtnWall3 = sheet.crop(7, 7, 32, 32);
         mtnWall4 = sheet.crop(8, 7, 32, 32);
         mtnWall5 = sheet.crop(9, 7, 32, 32);
         mtnWall6 = sheet.crop(3, 8, 32, 32);
         mtnWall7 = sheet.crop(4, 8, 32, 32);
         mtnWall8 = sheet.crop(5, 8, 32, 32);
         mtnWall9 = sheet.crop(6, 8, 32, 32);
         mtnWall10 = sheet.crop(7, 8, 32, 32);
         mtnWall11 = sheet.crop(8, 8, 32, 32);
         mtnWall12 = sheet.crop(9, 8, 32, 32);
         mtnWall13 = sheet.crop(0, 9, 32, 32);
         mtnWall14 = sheet.crop(1, 9, 32, 32);
         mtnWall15 = sheet.crop(2, 9, 32, 32);
         mtnWall16 = sheet.crop(3, 9, 32, 32);
         mtnWall17 = sheet.crop(4, 9, 32, 32);
         mtnWall18 = sheet.crop(5, 9, 32, 32);
         mtnWall19 = sheet.crop(6, 9, 32, 32);
         mtnWall20 = sheet.crop(7, 9, 32, 32);
         mtnWall21 = sheet.crop(8, 9, 32, 32);
         mtnWall22 = sheet.crop(9, 9, 32, 32);
     }     
     
     public void setPlayerImage()
     {
         playerUp = playerSheet.crop (0, 0, 32, 32);
         playerUp1 = playerSheet.crop(0, 1, 32, 32);
         playerUp2 = playerSheet.crop(0, 2, 32, 32);
         playerDn = playerSheet.crop(2, 0, 32, 32);
         playerDn1 = playerSheet.crop(2, 1, 32, 32);
         playerDn2 = playerSheet.crop(2, 2, 32, 32);
         playerLt = playerSheet.crop(3, 0, 32, 32);
         playerLt1 = playerSheet.crop(3, 1, 32, 32);
         playerLt2 = playerSheet.crop(3, 2, 32, 32);
         playerRt = playerSheet.crop(1, 0, 32, 32);
         playerRt1 = playerSheet.crop(1, 1, 32, 32);
         playerRt2 = playerSheet.crop(1, 2, 32, 32);
     }
     
     public void setNpcImage()
     {
         npcUp = npcSheet.crop(0, 1, 32, 32);
         npcDn = npcSheet.crop(0, 0, 32, 32);
         npcLt = npcSheet.crop(1, 1, 32, 32);
         npcRt = npcSheet.crop(1, 0, 32, 32);
     }    
}

