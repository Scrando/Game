package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
    private Handler handler;
    private int size = 5;
    private int xoff, yoff;
    
    public Bullet(float x, float y, ID id, Direction dir, Handler handler, float velX2, float velY2) {
        super(x, y, id);
        float velX = 0,velY = 0;
        
        this.xoff = (int)size/2;
        this.yoff = (int)size/2;
        
        float velMod = 0.7f;
        
        if (dir == Direction.Up){
            this.velX = velX2;
            this.velY = -velMod;
        }else if (dir == Direction.Down){
            this.velX = velX2;
            this.velY = velMod;  
        }else if (dir == Direction.Left){
            this.velX = -velMod;
            this.velY = velY2;  
        }else{ //Right
            this.velX = velMod;
            this.velY = velY2;  
        }
        
    }

    
    public void tick() {
        x += this.velX;
        y += this.velY;
        
        
        int widthBorder = 969;
        int heightBorder = 946;
        
        if (x<0 || x>widthBorder || y<0 || y>heightBorder){
            this.removed = true;
        }
        
    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x-this.xoff, (int)y-this.yoff, size, size); 
    }

    
    public Rectangle getBounds() {  
        return new Rectangle((int)x,(int)y,5,5);
    }
    
}
