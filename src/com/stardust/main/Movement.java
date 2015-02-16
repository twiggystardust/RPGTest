package com.stardust.main;

import com.stardust.main.entities.Player;

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
        
        menuDisplay();
        menuMove();
        
        if(Game.stateEngine.state == StateEngine.GameState.STATE_TOWN)
        {
            mapMove();  
            setTownEdges();
                    
        }
        if(Game.stateEngine.state == StateEngine.GameState.STATE_WORLD)
        {
            setWorldEdges();
            wMapMove();
        }
        if(Game.stateEngine.state == StateEngine.GameState.STATE_SHOP)
        {
            shopMove();
            setShopEdges();
        }
        if(Game.stateEngine.state == StateEngine.GameState.STATE_DUNGEON)
        {
            dungeonMove();
            setDungeonEdges();
        }
        
    }
    
    public void mapMove()
    {
        if(Game.stateEngine.menuState == StateEngine.MenuState.CLOSED)
        {
            if(Input.up)
            {
                Game.mapY += Player.SPEED;
                Game.npcY += Player.SPEED;
                Player.lastLook = 0;
                Player.walking = true;
            }
            if(Input.dn)
            {
                Game.mapY -= Player.SPEED;
                Game.npcY -= Player.SPEED;
                Player.lastLook = 1;
                Player.walking = true;
            }
            if(Input.lt)
            {
                Game.mapX += Player.SPEED;
                Game.npcX += Player.SPEED;
                Player.lastLook = 2;
                Player.walking = true;
            }
            if(Input.rt)
            {
                Game.mapX -= Player.SPEED;
                Game.npcX -= Player.SPEED;
                Player.lastLook = 3;
                Player.walking = true;
            }
        }
        
    }
    public void wMapMove()
    {
        if(Game.stateEngine.menuState == StateEngine.MenuState.CLOSED)
        {
            if(Input.up)
            {
                Game.wMapY += Player.SPEED;
                Player.lastLook = 0;
                Player.walking = true;
            }
            if(Input.dn)
            {
                Game.wMapY -= Player.SPEED;
                Player.lastLook = 1;
                Player.walking = true;
            }
            if(Input.lt)
            {
                Game.wMapX += Player.SPEED;
                Player.lastLook = 2;
                Player.walking = true;
            }
            if(Input.rt)
            {
                Game.wMapX -= Player.SPEED;
                Player.lastLook = 3;
                Player.walking = true;
            }
        }
    }
    public void dungeonMove()
    {
        if(Game.stateEngine.menuState == StateEngine.MenuState.CLOSED)
        {
            if(Input.up)
            {
                Game.dMapY += Player.SPEED;
                Player.lastLook = 0;
                Player.walking = true;
            }
            if(Input.dn)
            {
                Game.dMapY -= Player.SPEED;
                Player.lastLook = 1;
                Player.walking = true;
            }
            if(Input.lt)
            {
                Game.dMapX += Player.SPEED;
                Player.lastLook = 2;
                Player.walking = true;
            }
            if(Input.rt)
            {
                Game.dMapX -= Player.SPEED;
                Player.lastLook = 3;
                Player.walking = true;
            }
        }
        
    }
    public void setTownEdges()
    {
       if(Game.mapY >= Game.HEIGHT - 32)
       {
           Game.mapY = Game.HEIGHT - 32;
       }
       if(Game.mapY  + Game.tileMap.sy <= Game.HEIGHT)
       {
           Game.mapY = -Game.tileMap.sy + Game.HEIGHT;
       }
       if(Game.mapX >= Game.WIDTH - 32)
       {
           Game.mapX = Game.WIDTH - 32;
       }
       if(Game.mapX + Game.tileMap.sx <= Game.WIDTH)
       {
           Game.mapX = -Game.tileMap.sx + Game.WIDTH;
       }
    }
    
    public void setWorldEdges()
    {
       if(Game.wMapY >= Game.HEIGHT - 32)
       {
           Game.wMapY = Game.HEIGHT - 32;
       }
       if(Game.wMapY  + Game.world.wsy <= Game.HEIGHT)
       {
           Game.wMapY = -Game.world.wsy + Game.HEIGHT;
       }
       if(Game.wMapX >= Game.WIDTH - 32)
       {
           Game.wMapX = Game.WIDTH - 32;
       }
       if(Game.wMapX + Game.world.wsx <= Game.WIDTH)
       {
           Game.wMapX = -Game.world.wsx + Game.WIDTH;
       }
    }
    public void setDungeonEdges()
    {
       if(Game.dMapX <= -608 && Game.dMapX >= -672)
       {
           if(Game.dMapY + Game.dungeonMap.dsy <= Game.HEIGHT)
           {
               Game.dMapY = -Game.dungeonMap.dsy + Game.HEIGHT;
           }
       }       
       else if(Game.dMapY >= Game.HEIGHT - 96)
       {
           Game.dMapY = Game.HEIGHT - 96;
       }
       else if(Game.dMapY  + Game.dungeonMap.dsy <= Game.HEIGHT + 64)
       {
           Game.dMapY = -Game.dungeonMap.dsy + Game.HEIGHT + 64;
       }
       if(Game.dMapX >= Game.WIDTH - 96)
       {
           Game.dMapX = Game.WIDTH - 96;
       }
       if(Game.dMapX + Game.dungeonMap.dsx <= Game.WIDTH + 64)
       {
           Game.dMapX = -Game.dungeonMap.dsx + Game.WIDTH + 64;
       }
    }
    
    public void menuDisplay()
    {
        
        if(Input.spc && Game.stateEngine.menuState != StateEngine.MenuState.MAIN)
        {
            Game.stateEngine.menuState = StateEngine.MenuState.MAIN;
        }
        if(Input.ent && Game.stateEngine.menuState != StateEngine.MenuState.CLOSED)
        {
            Game.stateEngine.menuState = StateEngine.menuState.CLOSED;
        }
    }
    
    public void menuMove()
    {
        if(Game.stateEngine.menuState == StateEngine.MenuState.MAIN)
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
            if(Input.a)
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
    
    public void shopMove()
    {
        if(Game.stateEngine.menuState == StateEngine.MenuState.CLOSED)
        {
            if(Input.up)
            {
                Game.player.y -= Player.SPEED;
                Player.lastLook = 0;
                Player.walking = true;
            }
            if(Input.dn)
            {
                Game.player.y += Player.SPEED;
                Player.lastLook = 1;
                Player.walking = true;
            }
            if(Input.lt)
            {
                Game.player.x -= Player.SPEED;
                Player.lastLook = 2;
                Player.walking = true;
            }
            if(Input.rt)
            {
                Game.player.x += Player.SPEED;
                Player.lastLook = 3;
                Player.walking = true;
            }
        }
    }
    
    public void setShopEdges()
    {
        if(Game.player.x >= 314 && Game.player.x <= 322)
        {
        }
        else if(Game.player.y >= (Game.HEIGHT * Game.SCALE) - 256)
        {
            Game.player.y = (Game.HEIGHT * Game.SCALE) - 256;
        }
        if(Game.player.y <= 256)
        {
            Game.player.y = 256;
        }
        if(Game.player.x >= (Game.WIDTH * Game.SCALE) - 256)
        {
            Game.player.x = (Game.WIDTH * Game.SCALE) - 256;
        }
        if(Game.player.x <= 256)
        {
            Game.player.x = 256;
        }
    }
        
}