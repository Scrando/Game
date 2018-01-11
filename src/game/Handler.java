package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    private boolean up = false, down = false, right = false, left = false;
    private boolean Shootup = false, Shootdown = false, Shootright = false, Shootleft = false;

    public LinkedList<GameObject> getObject() {
        return object;
    }

    public void setObject(LinkedList<GameObject> object) {
        this.object = object;
    }

    /* Getters */
    public boolean isUp() {
        return up;
    }
    public boolean isDown() {
        return down;
    }
    public boolean isRight() {
        return right;
    }
    public boolean isLeft() {
        return left;
    }
    public boolean isShootup() {
        return Shootup;
    }
    public boolean isShootdown() {
        return Shootdown;
    }
    public boolean isShootright() {
        return Shootright;
    }
    public boolean isShootleft() {
        return Shootleft;
    }
    
    /* Setters */
    public void setUp(boolean up) {
        this.up = up;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setShootup(boolean Shootup) {
        this.Shootup = Shootup;
    }
    public void setShootdown(boolean Shootdown) {
        this.Shootdown = Shootdown;
    }
    public void setShootright(boolean Shootright) {
        this.Shootright = Shootright;
    }
    public void setShootleft(boolean Shootleft) {
        this.Shootleft = Shootleft;
    }
    
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            if (tempObject.removed){
                object.remove(i);
            }
            tempObject.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
            object.get(0).render(g);
        }
    }
    
    public void addObject(GameObject tempObject){
        object.add(tempObject);
    }
    
    public void removeObject(GameObject tempObject){
        object.remove(tempObject);
    }
}
