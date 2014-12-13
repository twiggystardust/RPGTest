package com.stardust.main;

import java.awt.image.BufferedImage;

public class Tile
{
    public int type;
    public boolean collidable;
    public int x, y;
    BufferedImage image;

    public Tile(BufferedImage image)
    {
        this.image = image;
    }
    
    
   
}
