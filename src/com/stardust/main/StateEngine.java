package com.stardust.main;

public class StateEngine 
{
    public static GameState state;
    public static MenuState menuState;
    
    enum GameState
    {
        STATE_MENU,
        STATE_WORLD,
        STATE_TOWN,
        STATE_STORE,
        STATE_ITEMMENU
    };
    
    enum MenuState
    {
        MAIN,
        ITEM,
        SKILL,
        EQUIP,
        STATUS
    };
    
    public StateEngine()
    {
        state = GameState.STATE_TOWN;
        menuState = MenuState.MAIN;
    }
    public void update()
    {
        
    }
}
