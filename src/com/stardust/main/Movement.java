package com.stardust.main;

import java.awt.event.KeyEvent;
import java.sql.Time;

public class Movement 
{
    Long now = 0L;
    Long lastMove = 0L;
    final Long moveSpeed = 65000000L;
    private int choice;
    
    public Movement()
    {
    }
    
    public void update()
    {
        mapMove();
        setEdges();
        menuDisplay();
        menuMove();
    }
    
    public void mapMove()
    {
        if(Game.stateEngine.state != StateEngine.GameState.STATE_MENU)
        {
            if(Input.up)
            {
                Game.mapY += Player.SPEED;
                Player.lastLook = 0;
            }
            if(Input.dn)
            {
                Game.mapY -= Player.SPEED;
                Player.lastLook = 1;
            }
            if(Input.lt)
            {
                Game.mapX += Player.SPEED;
                Player.lastLook = 2;
            }
            if(Input.rt)
            {
                Game.mapX -= Player.SPEED;
                Player.lastLook = 3;
            }
        }
        
    }
    
    public void setEdges()
    {
       if(Game.mapY >= Game.HEIGHT)
       {
           Game.mapY = Game.HEIGHT;
       }
       if(Game.mapY  + TileMap.sy <= Game.HEIGHT + 35)
       {
           Game.mapY = -TileMap.sy + Game.HEIGHT + 35;
       }
       if(Game.mapX >= Game.WIDTH)
       {
           Game.mapX = Game.WIDTH;
       }
       if(Game.mapX + TileMap.sx <= Game.WIDTH + 35)
       {
           Game.mapX = -TileMap.sx + Game.WIDTH + 35;
       }
    }
    
    public void menuDisplay()
    {
        if(Input.spc && Game.stateEngine.state != StateEngine.GameState.STATE_MENU)
        {
            Game.stateEngine.state = StateEngine.GameState.STATE_MENU;
        }
        if(Input.ent && Game.stateEngine.state != StateEngine.GameState.STATE_TOWN)
        {
            Game.stateEngine.state = StateEngine.GameState.STATE_TOWN;
        }        
    }
    
    public void menuMove()
    {
        if(Game.stateEngine.state == StateEngine.GameState.STATE_MENU && Game.stateEngine.menuState == StateEngine.MenuState.MAIN)
        {
            now = System.nanoTime();
            
            if((now - lastMove) >= moveSpeed)
            {
                if(Input.dn && Game.pointer.y < 386)
                {
                    Game.pointer.y += 62;
                }
                if(Input.up && Game.pointer.y > 148)
                {
                    Game.pointer.y -= 62;
                }
                lastMove = now;
            }
            setChoice();
            if(Input.a && Game.stateEngine.state != StateEngine.GameState.STATE_ITEMMENU)
            {
                switch(choice)
                {
                    case 0:
                    {
                        Game.stateEngine.menuState = StateEngine.MenuState.ITEM;
                        Menu.firstPass = true;
                        break;
                    }
                    case 1:
                    {
                        Game.stateEngine.menuState = StateEngine.MenuState.SKILL;
                        Menu.firstPass = true;
                        break;
                    }
                    case 2:
                    {
                        Game.stateEngine.menuState = StateEngine.MenuState.EQUIP;
                        Menu.firstPass = true;
                        break;
                    }
                    case 3:
                    {
                        Game.stateEngine.menuState = StateEngine.MenuState.STATUS;
                        Menu.firstPass = true;
                        break;
                    }
                }
            }
        }
        if(Game.stateEngine.menuState == StateEngine.MenuState.ITEM || Game.stateEngine.menuState == StateEngine.MenuState.SKILL || Game.stateEngine.menuState == StateEngine.MenuState.STATUS)
        {
            now = System.nanoTime();
            
            if((now - lastMove) >= moveSpeed)
            {
                if(Input.dn && Game.pointer.y < 430)
                {
                    Game.pointer.y += 15;
                }
                if(Input.up && Game.pointer.y > 172)
                {
                    Game.pointer.y -= 15;
                }
                lastMove = now;
            }
            if(Input.x && Game.stateEngine.menuState != StateEngine.MenuState.MAIN)
            {
                Game.stateEngine.menuState = StateEngine.MenuState.MAIN;
                Menu.firstPass = true;
            }            
        }
        if(Game.stateEngine.menuState == StateEngine.MenuState.EQUIP)
        {
            now = System.nanoTime();
            
            if((now - lastMove) >= moveSpeed)
            {
                if(Input.dn && Game.pointer.y < 338)
                {
                    Game.pointer.y += 59;
                }
                if(Input.up && Game.pointer.y > 338)
                {
                    Game.pointer.y -= 59;
                }
                if(Input.lt && Game.pointer.x > 167)
                {
                    Game.pointer.x -= 134;
                }
                if(Input.rt && Game.pointer.x < 301)
                {
                    Game.pointer.x += 134;
                }
                lastMove = now;
            }
            if(Input.x && Game.stateEngine.menuState != StateEngine.MenuState.MAIN)
            {
                Game.stateEngine.menuState = StateEngine.MenuState.MAIN;
                Menu.firstPass = true;
            }            
        }
    }
    private void setChoice()
    {
        switch(Game.pointer.y)
        {
            case 148:
            {
                choice = 0;
                break;
            }
            case 210:
            {
                choice = 1;
                break;
            }
            case 272:
            {
                choice = 2;
                break;
            }
            case 334:
            {
                choice = 3;
                break;
            }
        }
    }
}