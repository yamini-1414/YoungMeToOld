package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(int i=0;i<tasks.length;i++)
            map[tasks[i]-'A']++;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(26,Collections.reverseOrder());
        for(int f:map){
            if(f>0)
                q.add(f);
        }
        int t = 0;
        while(!q.isEmpty()){
            int i=0;
            List<Integer> temp = new ArrayList<Integer>();
            while(i<=n){
                if(!q.isEmpty()){
                        if(q.peek()>1)
                            temp.add(q.poll()-1);
                       else
                           q.poll();
                }
                t++;
                if(temp.size()==0 && q.isEmpty())
                    break;
                i++;
            }
            for(int l: temp)
                q.add(l);
        }
        return t;
    }
}
