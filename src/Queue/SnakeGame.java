package Queue;
import java.util.LinkedList;

class SnakeGame {
    static class Cell{
        int x;int y; 
        Cell(int x,int y){this.x=x;this.y=y;}
        public boolean isEqual(Cell c){
            return this.x==c.x && this.y == c.y;
        }
    }
      
    int rows; int cols;    
    int[][] food;
    LinkedList<Cell> snake;
    int len=0;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.rows = height; this.cols = width; 
        this.food = food; 
        snake = new LinkedList<Cell>();
        snake.addFirst(new Cell(0,0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
       Cell curr = new Cell(snake.get(0).x,snake.get(0).y);
        switch(direction){
            case "U":
                     curr.x--;
                     break;
            case "L":
                    curr.y--;
                    break;
            case "R":
                    curr.y++;
                    break;
            case "D":
                    curr.x++;
                    break;
                        
        }
        
        if(curr.x<0 || curr.x>=rows || curr.y<0 || curr.y>=cols) return -1; 
        //System.out.println(curr.x+" "+curr.y);
        for(int i=1;i<snake.size()-1;i++){
            Cell next = snake.get(i);
            if(next.isEqual(curr))
                return -1;
        }
        snake.addFirst(curr);
        if(len<food.length){
            Cell f = new Cell(food[len][0],food[len][1]);
            if(f.isEqual(curr))
                len++;
        }
        while(snake.size()>len+1) snake.removeLast();
        return len;
            
    }


/*public static void main(String[] args){
 SnakeGame obj = new SnakeGame(width, height, food);
 int param_1 = obj.move(direction);
 System.out.println(param1);
    }*/
}