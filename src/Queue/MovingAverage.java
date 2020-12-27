package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int cap;
   Queue<Integer> q ;
   int sum;
   /** Inialize your data structure here. */
   public MovingAverage(int size) {
     q = new LinkedList<Integer>();
     this.cap = size;
     this.sum = 0;
   }
   
   public double next(int val) {
         if(q.size()==cap){
             sum -= q.peek();
             q.poll();
         }
         sum += val;
         q.offer(val);
         return (double) sum/q.size();
   }
}

