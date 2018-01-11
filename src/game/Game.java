package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Canvas implements Runnable{
    
    /* Variables */
    private static final long serialVersionUID = 1L; //What is this??
    
    private boolean isRunning = false;
    private Thread thread; //What is thread
    private Handler handler;
    
    /**
     * Game Constructor
     */
    public Game(){
        new Window(1000,1000, "Penis Game", this);
        start();
        
        handler = new Handler();
        this.addKeyListener (new KeyInput(handler));
        
        handler.addObject(new Player(500,500, ID.Player, handler));
    }
    
    /**
     * Start Thread
     */
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    /**
     * Stop Thread
     */
    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Game Loop
     * Notch's game loop, pls no sue
     */
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 100000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            render();
            frames++;
   
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;    
            }
        }
        stop();
    }
    
    /**
     * Tick (Used by game loop)
     */
    public void tick(){
        handler.tick();
    }
    
    /**
     * Render (Used by game loop)
     */
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3); //Creates a buffer of 3 frames preloaded behind the current frame.
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        //////////////DrawStuff//////////////////
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);
        
        handler.render(g);
        
        /////////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    
    
    
    /**
     * Main Class
     * @param args 
     */
    public static void main(String[] args) {
        new Game();
    }
    
}
