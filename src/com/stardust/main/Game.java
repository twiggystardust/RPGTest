package com.stardust.main;

import com.stardust.main.gfx.Assets;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable
{
    public static final int WIDTH = 320, HEIGHT = 320, SCALE = 2;
    public static boolean running = false;
    public Thread gameThread;
    public static JFrame frame;
    
    
    public static StateEngine stateEngine;
    public static TileMap tileMap;
    public static TileMap layer2;
    public static TileMap layer3;
    public Assets assets;
    public Input input;
    public Movement move;
    public static Player player;
    public static Menu menu;
    public static Menu itemMenu;
    public static Menu skillMenu;
    public static Menu equipMenu;
    public static Menu statusMenu;
    public static Pointer pointer;
    public static DialogLoader stats;
    
    public static int mapX = 0, mapY= 0;
    
    public void init() throws IOException
    {
        initAll();
        
        this.addKeyListener(input);
    }
    
    public synchronized void start()
    {
        if(running)return;          
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public synchronized void stop()
    {
        if(!running)return;
        running = false;
        try
        {
            gameThread.join();
        } catch (InterruptedException e)
        {
        }
    }
    
    public void run()
    {
        try
        {
            init();
        } catch (IOException e)
        {
        }
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60D;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1)
            {
                update();
                delta--;
            }
            render();
        }
        stop();
    }
    
    public void update()
    {
        move.update();
        player.update();
    }
    
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //START RENDER
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        switch(StateEngine.state)
        {
            case STATE_TOWN:
            {
                tileMap.render(g);
                layer2.render(g);
                layer3.render(g);
                player.render(g);
                break;
            }
            case STATE_MENU:
            {
                switch(StateEngine.menuState)
                {
                    case MAIN:
                    {
                        if(Menu.firstPass)
                        {
                            pointer.x = 335;
                            pointer.y = 148;
                            Menu.firstPass = false;
                        }
                        tileMap.render(g);
                        layer2.render(g);
                        layer3.render(g);
                        menu.render(g);
                        pointer.render(g);
                        g.setColor(Color.WHITE);
                        g.setFont(new Font("Algerian", Font.TRUETYPE_FONT, 18));
                        g.drawString(Integer.toString(player.hp), 189, 207);
                        g.drawString(Integer.toString(player.sp), 189, 247);
                        break;
                    }
                    case ITEM:
                    {
                        if(Menu.firstPass)
                        {
                            pointer.x = 155;
                            pointer.y = 172;
                            Menu.firstPass = false;
                        }
                        tileMap.render(g);
                        layer2.render(g);
                        layer3.render(g);
                        itemMenu.render(g);
                        pointer.render(g);
                        break;
                    }
                    case SKILL:
                    {
                       if(Menu.firstPass)
                        {
                            pointer.x = 155;
                            pointer.y = 172;
                            Menu.firstPass = false;
                        }
                        tileMap.render(g);
                        layer2.render(g);
                        layer3.render(g);
                        skillMenu.render(g);
                        pointer.render(g);
                        break;
                    }
                    case EQUIP:
                    {
                       if(Menu.firstPass)
                        {
                            pointer.x = 167;
                            pointer.y = 337;
                            Menu.firstPass = false;
                        }
                        tileMap.render(g);
                        layer2.render(g);
                        layer3.render(g);
                        equipMenu.render(g);
                        pointer.render(g);
                        g.setColor(Color.WHITE);
                        g.setFont(new Font("Algerian", Font.TRUETYPE_FONT, 14));
                        g.drawString(stats.text[2], 239, 357);
                        break;
                    }
                    case STATUS:
                    {
                        tileMap.render(g);
                        layer2.render(g);
                        layer3.render(g);
                        statusMenu.render(g);
                        g.setColor(Color.WHITE);
                        g.setFont(new Font("Algerian", Font.TRUETYPE_FONT, 14));
                        g.drawString(Integer.toString(player.hp), 176, 371);
                        g.drawString(Integer.toString(player.sp), 176, 401);
                        g.drawString(Integer.toString(player.atk), 287, 356);
                        g.drawString(Integer.toString(player.def), 287, 386);
                        g.drawString(Integer.toString(player.spd), 287, 416);
                        g.drawString(Integer.toString(player.lvl), 376, 356);
                        g.drawString(Integer.toString(player.exp), 376, 386);
                        g.drawString(Integer.toString(player.next), 376, 416);                        
                        break;
                    }
                }
                        
                break;
            }
        }
       
        //END RENDER
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args)
    {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        frame = new JFrame("RPG Test");
        frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.setVisible(true);
        
        game.start();
    }
    
    public void initAll() throws IOException
    {
        stateEngine = new StateEngine();
        assets = new Assets();
        
        stats = new DialogLoader("res/stats.txt");
        stats.fileReader();
        tileMap = new TileMap(mapX, mapY, "res/tileMap3.txt");
        layer2 = new TileMap(mapX, mapY, "res/newLayer2.txt");
        layer3 = new TileMap(mapX, mapY, "res/newLayer3.txt");
        tileMap.fileParser();
        layer2.fileParser();
        layer3.fileParser();
        player = new Player(HEIGHT, WIDTH, 32, 32);
        menu = new Menu(135, 135, 345, 345, Assets.menu);
        itemMenu = new Menu(135, 135, 345, 345, Assets.itemMenu);
        skillMenu = new Menu(135, 135, 345, 345, Assets.skillMenu);
        equipMenu = new Menu(135, 135, 345, 345, Assets.equipMenu);
        statusMenu = new Menu(135, 135, 345, 345, Assets.statusMenu);
        pointer = new Pointer(335, 148, 32, 32);
        
        input = new Input();
        move = new Movement();
    }
}
