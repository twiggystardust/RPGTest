package com.stardust.main;

import com.stardust.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Menu 
{
    public int x, y, sx, sy;
    
    public static boolean firstPass = true;
    
    private BufferedImage image;
    
    public Menu(int x, int y, int sx, int sy, BufferedImage image)
    {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
        this.image = image;
    }
    
    
    
    public void render(Graphics g)
    {
        g.drawImage(image, x, y, sx, sy, null);
    }
}
