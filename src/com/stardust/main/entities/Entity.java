package com.stardust.main.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity 
{
    public int x, y, sx, sy;
    
    public static final int SPEED = 2;
    
    BufferedImage image;
    
    public void update()
    {
    }
    
    public void render(Graphics g)
    {
    }
}
