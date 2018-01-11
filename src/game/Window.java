package game;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
    private int width;
    private int height;
    
    /**
     * Window Constructor
     * @param width
     * @param height
     * @param title
     * @param game 
     */
    public Window(int width, int height, String title, Game game){
        
        this.width = width;
        this.height = height;
        
        
        /* Creates JFrame */
        JFrame frame = new JFrame(title);
        
        /* Sets size of JFrame */
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.add(game); //Add game class to JFrame
        frame.setResizable(false); //Window is non-resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ensures window closes properly
        frame.setLocationRelativeTo(null); //Window should open in center of screen
        frame.setVisible(true); //Window is visible
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
