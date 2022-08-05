package mysnake;


public class Food {
    
    
    private static int x=2;
    private static int y=0;
    private static int c=3;
    
    public Food() {
        
        addFood();
        
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static void setX(int x) {
        Food.x = x;
    }

    public static void setY(int y) {
        Food.y = y;
    }
    
    
    public static void addFood(){
        
        int rx;
        int ry;
        
        
        
        do {            
            rx = (int) (Math.random()*Constants.width);
            ry = (int) (Math.random()*Constants.height);
            
            if(MySnakeGame.map.getSpot(rx, ry).getC()==0){
                MySnakeGame.map.getSpot(rx, ry);
                break;
            }
            
        } while (true);
        
        
        
        x=rx;
        y=ry;
        
        MySnakeGame.map.changeMapValue(rx, ry, 3);
        
    }
    
    
    
}
