package db2024.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

// in honor of wayland way of calling windows
// which is ironic, since java swing uses xwayland 
public class TopLevel {
    private static final Dimension SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    protected JFrame frame = new JFrame();
    
    public TopLevel(String title, int width, int height){
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
    }
    
    public TopLevel(String title){
        this(title, (int) Math.round(SIZE.getWidth() / 2), (int) Math.round(SIZE.getHeight() / 2));
    }
    
    public TopLevel show(){
        this.frame.setVisible(true);
        return this;
    }
    
    public void close(){
        this.frame.dispose();
    }
}
