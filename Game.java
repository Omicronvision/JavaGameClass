package com.example.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -1448834159463009096L;

    public static final int WIDTH = 640; //size x of the game
    public static final int HEIGHT = 480; //size y of the game
    private Thread thread; //declare the thread
    private boolean running = false; //boolean running

    public Game()
    {
        new Window(WIDTH, HEIGHT, "RGAME", this); //set game settings
    }
    public synchronized void start() //when the game start...
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop() //when the game stop...
    {
        try {
            thread.join();
            running = false;
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run() //when the game run...
    {
        /*
        POPULAR USED GAME LOOP
        */
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    private void tick()
    {

    }
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.dispose();
        bs.show();
    }

    public static void main(String[] args)
    {
        new Game(); //create a new game
    }

}
