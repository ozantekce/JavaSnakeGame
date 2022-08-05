package mysnake;


public class Map {
    
    private static Spot map [][];
    
    public static boolean gameover=false;
    
    public Map() {
        
        map = new Spot[Constants.width][Constants.height];
        
        for (int i = 0; i < Constants.width; i++) {
            
            for (int j = 0; j < Constants.height; j++) {
                
                map [i][j] = new Spot(i, j);
            }

        }
        
        
    }
    
    
    public static void printMap(){
        
        for (int i = 0; i < Constants.width; i++) {
            
            for (int j = 0; j < Constants.height; j++) {
                if(map[j][i].getC()==0)
                    System.out.print("*");
                else if(map[j][i].getC()==1)
                    System.out.print("H");
                else if(map[j][i].getC()==2)
                    System.out.print("T");
                else if(map[j][i].getC()==3)
                    System.out.print("F");
                
            }
            System.out.println("");
            
        }
        System.out.println("--------------------------------------");
        
    }
    
    public static void changeMapValue(int x, int y, int value){
        
        map[x][y].changeSpotValue(value);
        
    }
    
    public static Spot getSpot(int x,int y){
        
        return map[x][y];
        
    }
    
    
}
