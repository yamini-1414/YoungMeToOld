package DataStructures;



public class HashTable<K,V> {
	public  final static int INITIAL_CAPACITY = 10;
	private int N;
	private  int M;
	private Node[] nodes;
	class Node{
		K key;
	    V value;
		Node next;
		Node(K key , V value,Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		this.N= 0;
		this.M = capacity;
		this.nodes =  new HashTable.Node[M];	
		
	}
	@SuppressWarnings("unchecked")
	public HashTable() {
		this.N = 0;
		this.M = INITIAL_CAPACITY;
		this.nodes =  new HashTable.Node[INITIAL_CAPACITY];	
	}
	public Object get(K key) {
		int hash = key.hashCode()%M;
		for(Node x = nodes[hash]; x!=null; x=x.next) {
			if(x.equals(key)) {
				return x.value;
			}
		}
		return null;
	}
	public void put(K key, V value) {
		//resizing should take place
		if(N >=8*M) {
			resize(2*M);
		}
			
		int hash = key.hashCode()%M;
		//search for duplicates
		for(Node x = nodes[hash]; x!=null; x= x.next) {
			if(x.equals(key)) {
				x.value = value;
				return;
			}
		}
		//Add it to the front of linked list
		nodes[hash] = new Node(key,value,nodes[hash]);
		N++;
	}
	public boolean containsKey(K key) {
	   return get(key)!=null;
	}
	public void resize(int capacity) {
	    HashTable<K,V> temp = new HashTable<K,V>(capacity);
	    for(int i=0;i<M;i++) {
	    	for(Node x = nodes[i]; x!=null ; x = x.next)
	    		temp.put(x.key, x.value);
	    }
	    this.M = temp.M;
	    this.N = temp.N;
	    this.nodes = temp.nodes;
	}
	public void remove(K key) {
		int hash = key.hashCode()%M;
		nodes[hash] = delete(nodes[hash],key);
		
		if(M>INITIAL_CAPACITY && N<2*M) {
			resize(M/2);
		}
	}
	public Node delete(Node node, K key) {
		if(node==null) {
			return null;
		}
		if(node.key.equals(key)) {
				N--;
				return node.next;
		}  
		 node.next = delete(node.next,key);
		 return node;
		}
	
	public static void main(String[] args) {
		HashTable<Integer,Integer> ht = new HashTable<Integer,Integer>();
		for(int i=0;i<100;i++) {
			ht.put(i,i+1);
		}
		ht.remove(6);
		//System.out.println(ht.containsKey(6));
		//System.out.println(ht);
		
		HashTable<Integer,String> ht1 = new HashTable<Integer,String>();
		ht1.put(1,"abc");
		ht1.put(2, "cde");
		ht1.put(3, "iop");
		System.out.println(ht1);
	}
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for(int i=0;i<M;i++) {
			if(nodes[i]==null) continue;
			str.append("{"+ nodes[i].key+"} : {");
			for(Node x = nodes[i]; x!=null;x=x.next) {
				str.append(x.value + ",");
			}
			str.append("}, ");
		}
		return str.toString();
	}
	
	
			
	}
	


