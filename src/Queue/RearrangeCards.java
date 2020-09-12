package Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RearrangeCards {
public static  int[] deckOfCards(int[] deck) {
	if(deck.length==0)
		return null;
	Deque<Integer> q = new LinkedList<Integer>();
	for(int i=0;i<deck.length;i++)
		q.add(i);
	Arrays.sort(deck);
	int[] res = new int[deck.length];
	for(Integer k: deck) {
		res[q.pollFirst()] = k;
		if(!q.isEmpty())
			q.add(q.pollFirst());
	}
	return res;
}
}
