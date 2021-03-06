package com.stardust.main;


public class Transition 
{
    public Transition()
    {
    }
    
    public static void update()
    {
        if(Game.stateEngine.state != StateEngine.GameState.STATE_TOWN &&
                Game.stateEngine.state != StateEngine.GameState.STATE_SHOP &&
                Game.stateEngine.state != StateEngine.GameState.STATE_DUNGEON)
        {
            if(Game.wMapX <= -920 && 
                    Game.wMapX >= -960 && 
                    Game.wMapY <= -770 && 
                    Game.wMapY >= -800)
            {
                Game.stateEngine.state = StateEngine.GameState.STATE_TOWN;
                Game.mapX = 260;
                Game.mapY = -32;
            }
            if(Game.wMapX <= -80 &&
                    Game.wMapX >= -112 &&
                    Game.wMapY <= -96 &&
                    Game.wMapY >= -110)
            {
                Game.stateEngine.state = StateEngine.GameState.STATE_DUNGEON;
                Game.dMapX = -644;
                Game.dMapY = -736;
            }
            
        }
        if(Game.stateEngine.state != StateEngine.GameState.STATE_WORLD && Game.stateEngine.state == StateEngine.GameState.STATE_TOWN)
        {
            if(Game.mapX >= 287 && Game.mapY >= -34 && Game.mapY <= -30)
            {
                Game.stateEngine.state = StateEngine.GameState.STATE_WORLD;
                Game.wMapX = -898;
                Game.wMapY = -784;
            }          
        }
        if(Game.stateEngine.state != StateEngine.GameState.STATE_SHOP)
        {
            if(Game.mapX <= -124 && Game.mapX >= -132 && Game.mapY <= -158 && Game.mapY >= -162)
            {
                Game.stateEngine.state = StateEngine.GameState.STATE_SHOP;
                Game.player.x = 318;
                Game.player.y = 384;
            }
        }
        
        if(Game.stateEngine.state == StateEngine.GameState.STATE_SHOP)
        {
            if(Game.player.x >= 314 && Game.player.x <= 322 && Game.player.y >= (Game.HEIGHT * Game.SCALE) - 215)
            {
                Game.stateEngine.state = StateEngine.GameState.STATE_TOWN;
                Game.player.x = Game.WIDTH - 32;
                Game.player.y = Game.HEIGHT - 32;
            }
        }
        if(Game.stateEngine.state == StateEngine.GameState.STATE_DUNGEON)
        {
            if(Game.dMapX <= -608 && Game.dMapX >= -672 && Game.dMapY < -Game.dungeonMap.dsy + Game.HEIGHT + 32 && Game.stateEngine.state != StateEngine.GameState.STATE_WORLD)
            {
                Game.stateEngine.state = StateEngine.GameState.STATE_WORLD;
                Game.wMapX = -96;
                Game.wMapY = -116;
            }
        }
    }   
}
