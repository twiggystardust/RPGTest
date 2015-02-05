package com.stardust.main.gfx.tilemaps;

import com.stardust.main.*;
import java.awt.image.BufferedImage;

public class Tile
{
    public int type;
    public static boolean collidable = false;
    public static int x, y;
    public static int inum;
    public static BufferedImage image;
    public static int textureType;

    public static BufferedImage Tile(BufferedImage tileImage, int num)
    {
        image = tileImage;
        inum = num;
        
        return image;        
    }
    
    public void update()
    {
        setCoords();
        getCollidable();
        defineCollidable();
    }
    
    private static void getCollidable()
    {
        switch(textureType)
        {
            case 2:
            {
                collidable = true;
                break;
            }
            case 3:
            {
                collidable = true;
                break;
            }
            case 4:
            {
                collidable = true;
                break;
            }
            case 11:
            {
                collidable = true;
                break;
            }
            case 12:
            {
                collidable = true;
                break;
            }
            case 13:
            {
                collidable = true;
                break;
            }
            case 14:
            {
                collidable = true;
                break;
            }
            case 15:
            {
                collidable = true;
                break;
            }
            case 16:
            {
                collidable = true;
                break;
            }
            case 17:
            {
                collidable = true;
                break;
            }
            case 18:
            {
                collidable = true;
                break;
            }
            case 19:
            {
                collidable = true;
                break;
            }
            case 37:
            {
                collidable = true;
                break;
            }
            case 38:
            {
                collidable = true;
                break;
            }case 39:
            {
                collidable = true;
                break;
            }
            case 40:
            {
                collidable = true;
                break;
            }
            case 41:
            {
                collidable = true;
                break;
            }
            case 42:
            {
                collidable = true;
                break;
            }
            case 43:
            {
                collidable = true;
                break;
            }
            case 44:
            {
                collidable = true;
                break;
            }
            default:
            {
                collidable = false;
                break;
            }
        }
    }
    
    
    public static void defineCollidable()
    {
        if(TileMap.tileImage[inum].collidable)
        {
            System.out.println("this is a collidable tile");
        }
        else
        {
            System.out.println("this tile is not collidable");
        }
        
        
    }
    
    public static void setCoords()
    {
        if(Game.stateEngine.state == StateEngine.GameState.STATE_TOWN)
       {
           x = (Game.WIDTH - Game.mapX) / 32;
           y = (Game.HEIGHT - Game.mapY) / 32;
           
            
           textureType = Game.tileMap.map[x][y];
                     
                    
                    
       }
       if(Game.stateEngine.state == StateEngine.GameState.STATE_WORLD)
       {
           x = (Game.player.x - Game.wMapX) / 32;
           y = (Game.player.y - Game.wMapY) / 32;
           
            
           textureType = Game.world.worldMap[x][y];
       }
    }
}
