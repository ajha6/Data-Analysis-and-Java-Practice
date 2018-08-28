package cs601.project0;

import java.util.HashMap;

public class DataStr {
	
	//constructor
	//https://www.geeksforgeeks.org/java-util-hashmap-in-java/
	private static HashMap<String, Integer> userRevCount = new HashMap<String, Integer>();
	private static HashMap<String, Integer> movieRevCount = new HashMap<String, Integer>();
	private static HashMap<String, Double> movieRevScore = new HashMap<String, Double>();
	private static int maxUserRevCount = 1;
	private static int maxMovieRevCount = 1;
	//private static double maxMovieRevScore;
	
	
	//getters
	
	public static HashMap<String, Integer> getUserRevCount() {
		return userRevCount;
	}

	public static HashMap<String, Integer> getMovieRevCount() {
		return movieRevCount;
	}

	public static HashMap<String, Double> getMovieRevScore() {
		return movieRevScore;
	}
	
	public static int getMaxUserRevCount() {
		return maxUserRevCount;
	}

	public static int getMaxMovieRevCount() {
		return maxMovieRevCount;
	}

	//public static double getMaxMovieRevScore() {
	//	return maxMovieRevScore;
	//}

	//for userRevCount - update or add in ds
	 static void editData(String userId)	{
		if(DataStr.userRevCount.containsKey(userId))	{
			int count = DataStr.userRevCount.get(userId);
			count = count + 1;
			//check if maxUserRevCount is max
			if(DataStr.maxUserRevCount < count)	{
				DataStr.maxUserRevCount = count;
			}
			//updating userRevCount ds
			DataStr.userRevCount.put(userId, count);
		}
		else	{
			DataStr.userRevCount.put(userId, 1);
		}
	}
	
	 

	//for movieRevCount and movieRevScore - update or add in ds
	 static void editData(String productId, double score)	{
		if(DataStr.movieRevCount.containsKey(productId))	{
			//so movieRevScore should also contain the key.
			//updating movieRevCount ds
			int count = DataStr.movieRevCount.get(productId);
			count = count + 1;
			//updating maxMovieRevCount
			if(DataStr.maxMovieRevCount < count)	{
				DataStr.maxMovieRevCount = count;
			}
			//updating movieRevCount ds
			DataStr.movieRevCount.put(productId, count);
			
			//updating movieRevScore ds
			double oldScore = DataStr.movieRevScore.get(productId);
			double newScore = ( (oldScore * (count-1)) + score ) / count; 
			
			//updating movieRevScore ds
			DataStr.movieRevScore.put(productId, newScore);
			
		}
		else	{
			DataStr.movieRevCount.put(productId, 1);
			DataStr.movieRevScore.put(productId, score);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
