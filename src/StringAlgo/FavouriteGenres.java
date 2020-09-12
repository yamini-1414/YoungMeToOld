package StringAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavouriteGenres {

	public static Map<String,List<String>> favGenres(Map<String,List<String>> songList, Map<String, List<String>> songGenres){
	    
	     HashMap<String,String> songMapGenre = new HashMap<String,String>();
	     for(String genre:songGenres.keySet()) {
	    	 List<String> songs = songGenres.get(genre);
	    	 for(String song:songs)
	    		 songMapGenre.put(song,genre);
	     }
	     HashMap<String,List<String>> res = new HashMap<String,List<String>>();
	     for(String user:songList.keySet()) {
	    	 res.put(user,new ArrayList<String>());
	    	 HashMap<String,Integer> count = new HashMap<String,Integer>();
	    	 int maxCount = Integer.MIN_VALUE;
	    	 List<String> songs = songList.get(user);
	    	 for(String song:songs) {
	    		 String gen = songMapGenre.get(song);
	    		 if(count.get(gen)==null)
	    			count.put(gen,1);
	    		 else
	    			 count.put(gen,count.get(gen)+1);
	    		 if(maxCount<count.get(gen))
	    			 maxCount = count.get(gen);
	    	 }
	    	 System.out.println(count);
	    	 for(String gen:count.keySet()) {
	    		 if(count.get(gen)==maxCount && gen!=null)
	    			 res.get(user).add(gen);
	    	 } 
	     }
	     return res;
	          
	}
	public static void main(String[] args) {
		Map<String,List<String>> songlist = new HashMap<String,List<String>>();
		songlist.put("David", Arrays.asList("song1","song2"));
		songlist.put("Emma", Arrays.asList("song5","song6"));
		Map<String,List<String>> songGenres = new HashMap<String,List<String>>();
		/*songGenres.put("Rock", Arrays.asList("song1","song3"));
		songGenres.put("Dubstep", Arrays.asList("song7"));
		songGenres.put("Techno", Arrays.asList("song2","song4"));
		songGenres.put("Pop", Arrays.asList("song5","song6"));
		songGenres.put("Jazz", Arrays.asList("song8","song9"));*/
		System.out.println(favGenres(songlist,songGenres));
		
	}
}
