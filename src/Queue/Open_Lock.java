package Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Open_Lock {
	 public int openLock(String[] deadends, String target) {
	        Set<String> visited = new HashSet<String>();
	        for(String str: deadends)
	              visited.add(str);
	        if(visited.contains("0000") || visited.contains(target)) return -1;
	        Queue<String> q  = new LinkedList<String>();
	        q.offer("0000");
	        q.offer(null); int dist=0;
	        while(!q.isEmpty()){
	            String temp = q.poll();
	            if(temp!=null){
	                if(temp.equals(target)) return dist;
	                for(int i=0;i<4;i++){
	                    StringBuilder str = new StringBuilder(temp);
	                    str.setCharAt(i,(char)((temp.charAt(i)-'0'+1)%10+'0'));
	                    if(!visited.contains(str.toString())){
	                        q.offer(str.toString());
	                        visited.add(str.toString());
	                    }
	                    str.setCharAt(i,(char)((temp.charAt(i)-'0'+9)%10+'0'));
	                     if(!visited.contains(str.toString())){
	                        q.offer(str.toString());
	                        visited.add(str.toString());
	                    }
	                }
	            }else{
	                dist++;
	                if(!q.isEmpty()) q.offer(null);
	            }
	        }
	            return -1;
	        
	    }
}
