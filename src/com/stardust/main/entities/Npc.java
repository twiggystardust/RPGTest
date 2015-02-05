package com.stardust.main.entities;

import com.stardust.main.Game;
import com.stardust.main.gfx.Assets;
import java.awt.Graphics;
import java.util.Random;


public class Npc extends Entity
{
    private Random rand;
    private Long now = 0L;
    private Long lastMove = 0L;
    private final Long moveSpeed = 900000000L;
    public static int lastLook = 0;
    //private final int MOVE_AMOUNT = 
    
    public Npc(int x, int y, int sx, int sy)
    {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
    }
    
    public void update()
    {
        switch(lastLook)
        {
            case 0:
            {
                image = Assets.npcUp;
                break;
            }
            case 1:
            {
                image = Assets.npcDn;
                break;
            }
            case 2:
            {
                image = Assets.npcLt;
                break;
            }
            case 3:
            {
                image = Assets.npcRt;
                break;
            }
        }
        npcLogic();
        x = Game.npcX;
        y = Game.npcY;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(image, x, y, sx, sy, null);
    }
    
    public void npcLogic()
    {
        rand = new Random();
        
        now = System.nanoTime();
        
        if((now - lastMove) >= moveSpeed)
        {
            if(rand.nextFloat() >= .4)
            {
                Game.npcX += 8;
                lastLook = 3;
            }
            else if(rand.nextFloat() >= .3)
            {
                Game.npcX -= 8;
                lastLook = 2;
            }
            else if(rand.nextFloat() >= .2)
            {
                Game.npcY += 8;
                lastLook = 1;
            }
            else if(rand.nextFloat() >= .1)
            {
                Game.npcY -= 8;
                lastLook = 0;
            }
            lastMove = now;
        }
    }
}
