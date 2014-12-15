package com.stardust.main;

import com.stardust.main.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player 
{
    public int x, y, sx, sy;
    public int hp, sp, atk, def, spd, lvl, exp, next;
    
    public static final int SPEED = 2;
    public static int lastLook = 3;
    
    private BufferedImage image;
    
    public Player(int x, int y, int sx, int sy)
    {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
        setStats();
    }
    
    public void update()
    {
        switch(lastLook)
        {
            case 0:
            {
                image = Assets.playerUp;
                break;
            }
            case 1:
            {
                image = Assets.playerDn;
                break;
            }
            case 2:
            {
                image = Assets.playerLt;
                break;
            }
            case 3:
            {
                image = Assets.playerRt;
                break;
            }
        }
    }
    
    public void render(Graphics g)
    {
        g.drawImage(image, x, y, sx, sy, null);
    }

    public void setStats()
    {
        hp = Integer.parseInt(Game.stats.text[0]);
        sp = Integer.parseInt(Game.stats.text[1]);
        atk = Integer.parseInt(Game.stats.text[6]);
        def = Integer.parseInt(Game.stats.text[7]);
        spd = Integer.parseInt(Game.stats.text[8]);
        lvl = Integer.parseInt(Game.stats.text[9]);
        exp = Integer.parseInt(Game.stats.text[10]);
        next = Integer.parseInt(Game.stats.text[11]);
    }
}
