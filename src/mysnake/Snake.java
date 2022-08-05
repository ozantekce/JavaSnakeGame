package mysnake;


public class Snake {
    
    static private int x=0;
    static private int y=0;
    static private int tailSize=0;
    static private boolean alive = true;
    
    static private Tail tail = new Tail();
    
    public static boolean goingLeft = false;
    public static boolean goingRight = false;
    public static boolean goingUp = false;
    public static boolean goingDown = false;
    
    public Snake() {
        MySnakeGame.map.changeMapValue(x, y, 1);
    }
    
    
    
    public static void tick(){
        
        if(goingLeft){
            goLeft();
        }else if(goingRight){
            goRight();
        }else if(goingUp){
            goUp();
        }else if(goingDown){
            goDown();
        }
        
    }
    
    
    public static void goLeft(){
        
        if(control(x-1, y)){
            Map.gameover = true;
            return;
        }
        
        if(MySnakeGame.map.getSpot(x-1, y).getC()==2){
            Map.gameover = true;
            return;
        }
        
        if(x-1==Food.getX()&&y==Food.getY()){
            eatFood();
        }else
            tail.move(x, y);
        MySnakeGame.map.changeMapValue(x, y, 0);
        x--;
        MySnakeGame.map.changeMapValue(x, y, 1);
        tail.sendMap();
    }
    public static void goRight(){
        
        if(control(x+1, y)){
            Map.gameover = true;
            return;
        }
        
        if(MySnakeGame.map.getSpot(x+1, y).getC()==2){
            Map.gameover = true;
            return;
        }
        
        if(x+1==Food.getX()&&y==Food.getY()){
            eatFood();
        }else
            tail.move(x, y);
        MySnakeGame.map.changeMapValue(x, y, 0);
        x++;
        MySnakeGame.map.changeMapValue(x, y, 1);
        tail.sendMap();
    }
    public static void goDown(){
        
        if(control(x, y+1)){
            Map.gameover = true;
            return;
        }
        
        if(MySnakeGame.map.getSpot(x, y+1).getC()==2){
            Map.gameover = true;
            return;
        }
        
        if(x==Food.getX()&&y+1==Food.getY()){
            eatFood();
        }else
            tail.move(x, y);
        MySnakeGame.map.changeMapValue(x, y, 0);
        y++;
        MySnakeGame.map.changeMapValue(x, y, 1);
        tail.sendMap();
    }
    public static void goUp(){
        
        if(control(x, y-1)){
            Map.gameover = true;
            return;
        }
        
        if(MySnakeGame.map.getSpot(x, y-1).getC()==2){
            Map.gameover = true;
            return;
        }
        
        if(x==Food.getX()&&y-1==Food.getY()){
            eatFood();
        }else
            tail.move(x, y);
        
        MySnakeGame.map.changeMapValue(x, y, 0);
        y--;
        MySnakeGame.map.changeMapValue(x, y, 1);
        
        tail.sendMap();
        
    }
    
    private static boolean control(int x,int y){

        return (x>=Constants.width||x<0||y<0||y>=Constants.height);
    }
    

    private static boolean foodFlag = false;
    public static void eatFood(){
        
        tailSize++;
        tail.add(x, y);
        foodFlag = true;
        Food.addFood();
        
    }
    
    
    
    
    private static class Tail{
    
        private static Node head;
        private static Node tail;
        
        
        private static  class Node{
            
            private Node next;
            private int x;
            private int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public void setNext(Node next) {
                this.next = next;
            }
            
        }
        
        
        public void add(int x,int y){
            
            if(head == null){
                head = new Node(x,y);
                tail = head;
                
            }else{
                head.next = new Node(x, y);
                head = head.next;
            }
            
            
        }
        
        private static int removeX;
        private static int removeY;
        
        public static void move(int x,int y){
            
            if(tailSize==0)
                return;
            
            Node nHead = tail;      //A
            Node nTail = tail.next; // B
            
            removeX = tail.x;
            removeY = tail.y;
            
            
            nHead.next = null;
            
            head.next = nHead;
            
            head = nHead;
            
            tail = nTail;
            
            head.x = x;
            head.y = y;
            
            if(tail == null)
                tail = head;
            
            
        }
        
        public static void sendMap(){
            if(tailSize==0)
                return;
            if(!foodFlag){
                MySnakeGame.map.changeMapValue(removeX, removeY, 0);
                MySnakeGame.map.changeMapValue(head.x, head.y, 2);
            }else{
                MySnakeGame.map.changeMapValue(head.x, head.y, 2);
            }
            foodFlag = false;
        }
        
    }
    
    
}
