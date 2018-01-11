
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.time.LocalTime;



public class Player extends GameObject{
    
    private Handler handler;
    private boolean canShoot;
    private int size = 25;
    private int xoff, yoff;
    
    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.xoff = (int)size/2;
        this.yoff = (int)size/2;
        this.canShoot = true;
    }

    public void tick() {
        x += velX;
        y += velY;
        
        float velMod = 0.5f;
        int widthBorder = 969 + this.xoff;
        int heightBorder = 946 + this.yoff;
        
        System.out.println("--------------");
        System.out.println("x: " + this.x);
        System.out.println("y: " + this.y);
        
        /* Movement */
        if (handler.isUp()){
            if(this.y <= this.yoff){
                velY = 0;
            }else{
                velY = -velMod;
            }
        }else if (!handler.isDown()){
            velY = -0f;
        }
        
        if (handler.isDown()){
            if(this.y >= heightBorder){
                velY = 0;
            }else{
                velY = velMod;
            }
        }else if (!handler.isUp()){
            velY = 0f;
        }
        
        if (handler.isLeft()){
            if(this.x <= xoff){
                velX = 0;
            }else{
                velX = -velMod;
            }
        }else if (!handler.isRight()){
            velX = -0f;
            
        }
        
        if (handler.isRight()){
            if(this.x >= widthBorder){
                velX = 0;
            }else{
                velX = velMod;
            }
        }else if (!handler.isLeft()){
            velX = 0f;
        }
        
        if(!handler.isShootup() && !handler.isShootdown() && !handler.isShootleft() && !handler.isShootright()){
            this.canShoot = true;
        }
        
        
        
        if (handler.isShootup() && this.canShoot == true){
            handler.addObject(new Bullet((int)x,(int)y, ID.Bullet, Direction.Up, handler, velX, velY));
            //handler.setShootup(false);
            this.canShoot = false;
        }else if (handler.isShootdown() && this.canShoot == true){
            handler.addObject(new Bullet((int)x,(int)y, ID.Bullet, Direction.Down, handler, velX, velY));
            //handler.setShootdown(false);
            this.canShoot = false;
        }else if (handler.isShootleft() && this.canShoot == true){
            handler.addObject(new Bullet((int)x,(int)y, ID.Bullet, Direction.Left, handler, velX, velY));
            //handler.setShootleft(false);
            this.canShoot = false;
        }else if (handler.isShootright() && this.canShoot == true){
            handler.addObject(new Bullet((int)x,(int)y, ID.Bullet, Direction.Right, handler, velX, velY));
            //handler.setShootright(false);
            this.canShoot = false;
        }
        
        
    }
    
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x-xoff, (int)y-yoff, this.size, this.size); 
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,25,25);
    }
    
}
