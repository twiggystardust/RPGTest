package com.stardust.main;

import com.stardust.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Pointer 
{
    public int x, y, sx, sy;
    
    private BufferedImage image;
    
    public Pointer(int x, int y, int sx, int sy)
    {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
        image = Assets.pointer;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(image, x, y, sx, sy, null);
    }
}
