package com.stardust.main;


public class Interaction 
{
    
    Long now = 0L;
    Long lastMove = 0L;
    final Long moveSpeed = 100000000L;
    
    public Interaction()
    {
    }
    
    public void update()
    {
        interact();
        nextLine();
    }
    
    public void nextLine()
    {
        
        now = System.nanoTime();
        if((now - lastMove) >= moveSpeed)
        {
            if(Input.a && Game.dialogChoice != Game.dialog.text.length - 8 && 
                    StateEngine.dialogState == StateEngine.DialogState.DIALOG_ON)
            {
                Game.dialogChoice++;
            }
            if(Input.a && Game.dialogChoice == Game.dialog.text.length - 8 &&
                    StateEngine.dialogState == StateEngine.DialogState.DIALOG_ON)
            {
                StateEngine.dialogState = StateEngine.DialogState.DIALOG_OFF;
                Game.dialogRender = false;
                Game.dialogChoice = 0;
            }
            lastMove = now;
        }
        
        
    }
    
    public void interact()
    {
        if(Game.stateEngine.state == StateEngine.GameState.STATE_SHOP)
        {
            if(Game.player.x >= 313 &&
                    Game.player.x <= 323 &&
                    Game.player.y >= 319 &&
                    Game.player.y <= 329)
            {
                if(Input.a)
                {
                    StateEngine.dialogState = StateEngine.DialogState.DIALOG_ON;
                    Game.dialogRender = true;
                }
                if(Input.x)
                {
                    StateEngine.dialogState = StateEngine.DialogState.DIALOG_OFF;
                    Game.dialogRender = false;
                    Game.dialogChoice = 0;
                }
                
            }
        }
    }
}
