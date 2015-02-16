package com.stardust.main;

public class StateEngine 
{
    public static GameState state;
    public static MenuState menuState;
    public static DialogState dialogState;
    
    public enum GameState
    {
        STATE_WORLD,
        STATE_TOWN,
        STATE_SHOP,
        STATE_DUNGEON,
        STATE_ITEMMENU
    };
    
    public enum MenuState
    {
        CLOSED,
        MAIN,
        ITEM,
        SKILL,
        EQUIP,
        STATUS
    };
    
    public enum DialogState
    {
        DIALOG_ON,
        DIALOG_OFF
    };
    
    public StateEngine()
    {
        state = GameState.STATE_WORLD;
        menuState = MenuState.CLOSED;
        dialogState = DialogState.DIALOG_OFF;
        
    }
    public void update()
    {
        
    }
}
