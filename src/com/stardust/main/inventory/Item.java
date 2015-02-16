package com.stardust.main.inventory;

public abstract class Item 
{
    public String name;
    public int price;
    public int power;
    public String type;
    
    public Item(String name, int price, int power, String type)
    {
        this.name = name;
        this.price = price;
        this.power = power;
        this.type = type;
    }
}
