package mysnake;
import java.awt.Color;
import java.awt.Graphics;

public class Spot {
    
    private int x;
    private int y;
    private int value;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //Flags
    public boolean spotValueChanged = true;
    
    public void changeSpotValue(int c){
        //System.out.println(c);
        if(this.value !=c){
            this.value = c;
            spotValueChanged = true;
        }
        
    }

    public int getC() {
        return value;
    }
    
    
    
    public void render(Graphics g) {
        
        if(value ==0){
            g.setColor(Color.WHITE);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }else if(value ==1){
            g.setColor(Color.BLUE);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }else if(value ==2){
            g.setColor(Color.BLUE);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }else if(value ==3){
            g.setColor(Color.GREEN);
            g.fillRect(x*Constants.pixW, y*Constants.pixH, Constants.pixW, Constants.pixH);
        }
        
        
    }
    
    
    
    
}
