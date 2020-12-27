package LinkedList;


public class DetectLoop {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static boolean loopExists(Node head) {
		Node firstptr=head ; Node secondptr = head;
		while(firstptr!=null && firstptr.next!=null) {
			firstptr = firstptr.next.next;
			secondptr =  secondptr.next;
			if(firstptr==secondptr)
				  return true;
		}
		return false;
	}
	 public Node detectCycle(Node head) {
	        Node fastptr = head;
	        Node slowptr = head;
	        boolean isLoop = false;
	        while(fastptr!=null && fastptr.next!=null){
	            fastptr = fastptr.next.next;
	            slowptr = slowptr.next;
	            if(fastptr==slowptr){
	                isLoop = true;
	                break;
	            }
	        }
	        if(isLoop){
	            slowptr = head;
	            if(fastptr==slowptr) return slowptr;
	            while(fastptr!=null && slowptr!=null){
	                fastptr= fastptr.next;
	                slowptr = slowptr.next;
	                if(fastptr==slowptr) return slowptr;
	            }
	        }
	        return null;
	        
	    }
}
