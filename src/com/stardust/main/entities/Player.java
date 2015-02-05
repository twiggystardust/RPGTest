package com.stardust.main.entities;

import com.stardust.main.Game;
import com.stardust.main.gfx.Assets;
import java.awt.Graphics;

public class Player extends Entity
{
    public int hp, sp, atk, def, spd, lvl, exp, next;
    
    public static int lastLook = 3;
    private int anim = 0;
    public static boolean walking = false;
    
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
        if(anim < 7500)
        {
            anim++;
        }
        else
        {
            anim = 0;
        }
        switch(lastLook)
        {
            case 0:
            {
                image = Assets.playerUp;
                if(walking)
                {
                    if(anim % 20 > 10)
                    {
                        image = Assets.playerUp1;
                    }
                    else
                    {
                        image = Assets.playerUp2;
                    }
                }
                break;
            }
            case 1:
            {
                image = Assets.playerDn;
                if(walking)
                {
                    if(anim % 20 > 10)
                    {
                        image = Assets.playerDn1;
                    }
                    else
                    {
                        image = Assets.playerDn2;
                    }
                }
                break;
            }
            case 2:
            {
                image = Assets.playerLt;
                if(walking)
                {
                    if(anim % 20 > 10)
                    {
                        image = Assets.playerLt1;
                    }
                    else
                    {
                        image = Assets.playerLt2;
                    }
                }
                break;
            }
            case 3:
            {
                image = Assets.playerRt;
                if(walking)
                {
                    if(anim % 20 > 10)
                    {
                        image = Assets.playerRt1;
                    }
                    else
                    {
                        image = Assets.playerRt2;
                    }
                }
                break;
            }
        }
        walking = false;
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
