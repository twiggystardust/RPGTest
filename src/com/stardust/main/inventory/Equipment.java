package com.stardust.main.inventory;

import static com.stardust.main.Game.player;


public class Equipment extends Item
{

    public Equipment(String name, int price, int power, String type)
    {
        super(name, price, power, type);
    }
    
    public void equip()
    {        
        if(type == "Sword")
        {
            player.atk += power;
            player.rHand = name;            
        }
        if(type == "Sheild")
        {
            player.def += power;
            player.lHand = name;
        }
        if(type == "Armor")
        {
            player.def += power;
            player.body = name;
        }
        if(type == "Greaves")
        {
            player.def += power;
            player.legs = name;
        }
    }
}
