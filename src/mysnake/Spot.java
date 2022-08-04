package mysnake;
import java.awt.Color;
import java.awt.Graphics;

public class Spot {
    
    private int x;
    private int y;
    private int c;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //Flags
    public boolean cChange = true;
    
    public void changeC(int c){
        System.out.println(c);
        if(this.c!=c){
            this.c = c;
            cChange = true;
        }
        
    }

    public int getC() {
        return c;
    }
    
    
    
    public void render(Graphics g) {
        
        if(c==0){
            g.setColor(Color.WHITE);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }else if(c==1){
            g.setColor(Color.BLUE);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }else if(c==2){
            g.setColor(Color.BLUE);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }else if(c==3){
            g.setColor(Color.GREEN);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }
        
        
    }
    
    
    
    
}
