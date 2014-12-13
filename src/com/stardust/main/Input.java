package com.stardust.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Input implements KeyListener
{
    public static boolean up = false, dn = false, lt = false, rt = false, spc = false, ent = false; 
    public static boolean a, x;
    
    public void keyTyped(KeyEvent e)
    {
    }
        
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = true;            
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            dn = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            lt = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            rt = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            spc = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            ent = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_X)
        {
            x = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            a = true;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            dn = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            lt = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            rt = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            spc = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            ent = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_X)
        {
            x = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            a = false;
        }
    }
}
