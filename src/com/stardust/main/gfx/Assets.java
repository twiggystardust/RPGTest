package com.stardust.main.gfx;

import com.stardust.main.Game;
import java.awt.image.BufferedImage;

public class Assets 
{
     public ImageLoader loader;
     public static SpriteSheet sheet, playerSheet, menuSheet, itemSheet, skillSheet, equipSheet, statusSheet, npcSheet;
     private BufferedImage tileImage, playerImage, menuImage, itemImage, skillImage, equipImage, statusImage, npcImage;
     public static BufferedImage grass, dirt, water, tree, multiTree, NSpath, uprtPath; 
     public static BufferedImage EWpath, upltPath, dnltPath, dnrtPath, sprite, watgrsdn;
     public static BufferedImage watgrslt, watgrsup, watgrsrt, watgrsSE, watgrsSW, watgrsNW;
     public static BufferedImage watgrsNE, pointer, pathOpRt, pathOpLt, pathOpDn, pathOpUp;
     public static BufferedImage pathOpAll, wallWood, roughWood, pathOpen, counter, storeDude, pot;
     public static BufferedImage playerUp, playerDn, playerLt, playerRt, npcUp, npcDn, npcLt, npcRt;
     public static BufferedImage singleHouse, doubleHouse, wepBanner, armBanner, innBanner, blankTile;
     public static BufferedImage menu, itemMenu, skillMenu, equipMenu, statusMenu, townTile;
     
     public Assets()
     {
         loader = new ImageLoader();
         
         tileImage = loader.load("/tileSheet.png");
         playerImage = loader.load("/newSpriteSheet.png");
         npcImage = loader.load("/npcSpriteSheet.png");
         menuImage = loader.load("/menu.png");
         itemImage = loader.load("/itemMenu.png");
         skillImage = loader.load("/skillMenu.png");
         equipImage = loader.load("/equipMenu.png");
         statusImage = loader.load("/statusMenu.png");
         
         sheet = new SpriteSheet(tileImage);
         playerSheet = new SpriteSheet(playerImage);
         npcSheet = new SpriteSheet(npcImage);
         menuSheet = new SpriteSheet(menuImage);
         itemSheet = new SpriteSheet(itemImage);
         skillSheet = new SpriteSheet(skillImage);
         equipSheet = new SpriteSheet(equipImage);
         statusSheet = new SpriteSheet(statusImage);
         
         menu = menuSheet.crop(0, 0, 345, 345);
         itemMenu = itemSheet.crop(0, 0, 345, 345);
         skillMenu = skillSheet.crop(0, 0, 345, 345);
         equipMenu = equipSheet.crop(0, 0, 345, 345);
         statusMenu = statusSheet.crop(0, 0, 345, 345);
         
         
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
     }
     
     
     
     //MAKE TOWN TILE AT LEAST 64X64
     
     
     
     public void setPlayerImage()
     {
         playerUp = playerSheet.crop (0, 1, 32, 32);
         playerDn = playerSheet.crop(0, 0, 32, 32);
         playerLt = playerSheet.crop(1, 1, 32, 32);
         playerRt = playerSheet.crop(1, 0, 32, 32);
     }
     
     public void setNpcImage()
     {
         npcUp = npcSheet.crop(0, 1, 32, 32);
         npcDn = npcSheet.crop(0, 0, 32, 32);
         npcLt = npcSheet.crop(1, 1, 32, 32);
         npcRt = npcSheet.crop(1, 0, 32, 32);
     }
     
}

