package Amazon_OA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Top_Keywords {
static class Toy{
	String name;
	int count;
	Set<Integer> ids;
	Toy(String word){
		this.name = word;
		this.count = 0;
		ids = new HashSet<Integer>();
	}
}
public static void main(String[] args) {
	List<String> toys = Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft");
	List<String> quotes = Arrays.asList("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
			"The new Elmo dolls are super high quality",
			"Expect the Elsa dolls to be very popular this year, Elsa!",
			"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
			"For parents of older kids, look into buying them a drone",
			"Warcraft is slowly rising in popularity ahead of the holiday season");
	System.out.println(countBuzzwords(6,2,toys,6,quotes).length);
	
}
public static String[] countBuzzwords(int numToys,int topToys,List<String> toys,int numQuotes, List<String> quotes) {
	Toy[] Toys = new Toy[numToys];
	for(int i=0;i<toys.size();i++)
		Toys[i] = new Toy(toys.get(i));
	for(int i=0;i<toys.size();i++) {
		for(int j=0;j<numQuotes;j++) {
			String[] words = quotes.get(j).split(" ");
			for(String word:words) {
				if(word.toLowerCase().equals(Toys[i].name)) {
					Toys[i].count++;
					Toys[i].ids.add(j);
				}
			}
		}
	}
	Arrays.sort(Toys,(a,b)->{
		if(a.count==b.count)
			return b.ids.size()-a.ids.size();
		else
			return b.count-a.count;
	});
	String[] res = new String[topToys];
	for(int i=0;i<topToys;i++)
		res[i] = Toys[i].name;
	return res;
}
}
