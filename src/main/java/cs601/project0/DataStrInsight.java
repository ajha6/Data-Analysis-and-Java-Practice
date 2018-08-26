package cs601.project0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataStrInsight {

	//https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
	//Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	//for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	//    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	//}
	
	//public DataStrInsight()	{
	//	System.out.println("max rev by user :" + DataStr.getMaxUserRevCount());
	//	System.out.println("max rev for movie :" + DataStr.getMaxMovieRevCount());
	//}
	
	//User IDs of the users with the largest number of reviews (field review/userId) 
	//-------userid -> no of reviews
	public ArrayList<String> usersWithMaxReviews()	{
		HashMap<String, Integer> userRevCount = DataStr.getUserRevCount();
		int maxUserRevCount = DataStr.getMaxUserRevCount();
		ArrayList<String> users = new ArrayList<String>();
		
		System.out.println("Users with largest number of reviews:");
		for(Map.Entry<String, Integer> entry : userRevCount.entrySet())	{
			if(entry.getValue() == maxUserRevCount)	{
				users.add(entry.getKey());
				//System.out.println("\t"+entry.getKey());
			}
		}
		return users;
		
	}
	
	//Product IDs of the products with the largest number of reviews (field product/productId)
	//-------productId -> no of reviews
	public ArrayList<String> moviesWithMaxReviews()	{
		HashMap<String, Integer> movieRevCount = DataStr.getMovieRevCount();
		int maxMovieRevCount = DataStr.getMaxMovieRevCount();
		ArrayList<String> movies = new ArrayList<String>();
		
		System.out.println("Products with largest number of reviews:");
		for(Map.Entry<String, Integer> entry : movieRevCount.entrySet())	{
			if(entry.getValue() == maxMovieRevCount)	{
				movies.add(entry.getKey());
				//System.out.println("\t"+entry.getKey());
			}
			//System.out.println(movies.toString());
		}
		//System.out.println("Products with largest number of reviews:");
		return movies;
	}
	
	
	//Product IDs of the products with the highest average score (field product/productId)
	//-------productId -> avg score
	public ArrayList<String> moviesWithMaxRevScore()	{
		HashMap<String, Double> movieRevScore = DataStr.getMovieRevScore();
		double maxMovieRevScore = 0;
		ArrayList<String> movies = new ArrayList<String>();
		
		for(Map.Entry<String, Double> entry : movieRevScore.entrySet())	{
			if(entry.getValue() > maxMovieRevScore )	{
				maxMovieRevScore = entry.getValue();
			}
		}
		
		System.out.println("Products with the highest average score:");
		for(Map.Entry<String, Double> entry : movieRevScore.entrySet())	{
			if(entry.getValue() == maxMovieRevScore)	{
				movies.add(entry.getKey());
				System.out.println("\t"+entry.getKey());
			}
			//System.out.println(movies.toString());
		}
		return movies;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//Your program will calculate the following three items:
//Product IDs of the products with the largest number of reviews (field product/productId)
//-------productId -> no of reviews
//Product IDs of the products with the highest average score (field product/productId)
//-------productId -> avg score
//User IDs of the users with the largest number of reviews (field review/userId) 
//-------userid -> no of reviews
