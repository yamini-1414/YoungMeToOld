package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MergeOverlapping_Intervals {
	public static class Interval{
		  int start;
		  int end;
		  Interval(int start,int end){
		    this.start = start;
			this.end = end;
		  }
	}
		  public static void main(String[] args){
		    Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for(int t=0;t<T;t++)
			{
			  int n = sc.nextInt();
			  Interval[] intervals = new Interval[n];
			  for(int i=0;i<n;i++)
			   intervals[i] = new Interval(sc.nextInt(),sc.nextInt());
		      int index=0;
		      Arrays.sort(intervals,new intervalComparator());
		      for(int i=1;i<n;i++){
			      if(intervals[i].start<=intervals[index].end) {
			    	intervals[index].start = Math.min(intervals[i].start, intervals[index].start);
				    intervals[index].end = Math.max(intervals[i].end,intervals[index].end);
				    //System.out.println(intervals[index].start+" "+intervals[index].end+" "+index);
			      }
				 else {
				     index++;
				     intervals[index] = intervals[i];
				 }
		      }
		       for(int j=0;j<=index;j++)
		       System.out.print(intervals[j].start+" "+intervals[j].end+" ");   
		    }
		}
	
	public static class  intervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start - o2.start;
		}
		
	}
	
}
