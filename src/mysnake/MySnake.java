package mysnake;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class MySnake extends Canvas implements Runnable{
    
    
    /*
        Head = 1
        Tail = 2
        Food = 3
        
    */
    
    public static Map map = new Map();
    
    private static boolean running = false;

    public MySnake() {
        
        
        this.setPreferredSize(new Dimension(Constants.width*Constants.pixW,Constants.height*Constants.pixH));
        this.setMaximumSize(new Dimension(Constants.width*Constants.pixW,Constants.height*Constants.pixH));
        this.setMinimumSize(new Dimension(Constants.width*Constants.pixW,Constants.height*Constants.pixH));
        
        JFrame frame = new JFrame("Snake");
        frame.add(this);
        //frame.setSize(350, 350);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        frame.add(this);
        
        
        KeyInput ki=new KeyInput();
        this.addKeyListener(ki);
        
    }
    
    
    
    public static void main(String[] args) {
        
        MySnake canvas = new MySnake();
        
        
        Snake snake = new Snake();
        Food food = new Food();
        
        canvas.start();
        canvas.run();
        
        
    }
    
    
    
    public void render(){
        
         BufferStrategy bs = this.getBufferStrategy();
         
        if(bs==null){
        
            this.createBufferStrategy(2);
            return;

        }
        
        Graphics g = bs.getDrawGraphics();
        
        Graphics2D g2d=(Graphics2D)g;
        
        
        
        //Start
        
        for (int i = 0; i < Constants.width; i++) {
            
            for (int j = 0; j < Constants.height; j++) {
                
                
                if(map.getSpot(i, j).cChange){
                    map.getSpot(i, j).render(g);
                    map.getSpot(i, j).cChange = false;
                }
                
            }
            
        }
        
        
        //End
        g.dispose();
        bs.show();
        
        
    }

    
    public void start(){
        running = true;
    }
    
    public void stop(){
        running = false;
    }
    
    
    @Override
    public void run() {
        
        while (true) {      
            
            if(Map.gameover){
                break;
            }
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(MySnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(running){
                
                Snake.tick();
                render();
                
            }
            
            
            
        }
        
        
    }
    
}
