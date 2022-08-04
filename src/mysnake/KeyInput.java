package mysnake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{

    @Override
    public void keyPressed(KeyEvent e) {
        
        int key =e.getKeyCode();
        
         if(key==KeyEvent.VK_W&&!Snake.goingDown){
            Snake.goingLeft = false;
            Snake.goingRight = false;
            Snake.goingUp = true;
            Snake.goingDown = false;
         }
         if(key==KeyEvent.VK_S&&!Snake.goingUp){
            Snake.goingLeft = false;
            Snake.goingRight = false;
            Snake.goingUp = false;
            Snake.goingDown = true;
         }
         if(key==KeyEvent.VK_D&&!Snake.goingLeft){
            Snake.goingLeft = false;
            Snake.goingRight = true;
            Snake.goingUp = false;
            Snake.goingDown = false;
         }
         if(key==KeyEvent.VK_A&&!Snake.goingRight){
            Snake.goingLeft = true;
            Snake.goingRight = false;
            Snake.goingUp = false;
            Snake.goingDown = false;
         }
        
    }
    
    
    
    
}
