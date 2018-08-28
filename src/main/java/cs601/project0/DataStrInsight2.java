package cs601.project0;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Your program will calculate the following three items:
//Product IDs of the products with the largest number of reviews (field product/productId)
//-------productId -> no of reviews
//Product IDs of the products with the highest average score (field product/productId)
//-------productId -> avg score
//User IDs of the users with the largest number of reviews (field review/userId) 
//-------userid -> no of reviews

public class DataStrInsight2 {
		
		private StringBuilder createContent;
		//constructor - initializing StringBuilder
		public DataStrInsight2()	{
			createContent = new StringBuilder();
		}
		
		//getter
		public String getCreateContent() {
			return createContent.toString();
		}

		/**
		 * Method to find
		 *User IDs of the users with the largest number of reviews (field review/userId) 
		 *-------userid -> no of reviews
		 */
		void usersWithMaxReviews()	{
			
			HashMap<String, Integer> userRevCount = DataStr.getUserRevCount();
			int maxUserRevCount = DataStr.getMaxUserRevCount();
			LinkedList<String> users = new LinkedList<String>();
			
			this.createContent.append("Users with largest number of reviews:\n");
			//https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
			//Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			//for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			//    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			//}
			for(Map.Entry<String, Integer> entry : userRevCount.entrySet())	{
				if(entry.getValue() == maxUserRevCount)	{
					users.add(entry.getKey());
				}
			}
			
			if(users.size() > 1	) {
				Collections.sort(users);
			}
			for(String s : users)	{
				this.createContent.append("\t"+ s +"\n");
			}
		}
		
		/** 
		 * Method to find
		 * Product IDs of the products with the largest number of reviews (field product/productId)
		 *-------productId -> no of reviews
		 */
		
		void moviesWithMaxReviews()	{
			
			HashMap<String, Integer> movieRevCount = DataStr.getMovieRevCount();
			int maxMovieRevCount = DataStr.getMaxMovieRevCount();
			LinkedList<String> movies = new LinkedList<String>();
			
			this.createContent.append("Products with largest number of reviews:\n");
			for(Map.Entry<String, Integer> entry : movieRevCount.entrySet())	{
				if(entry.getValue() == maxMovieRevCount)	{
					movies.add(entry.getKey());
				}
			}
			
			if(movies.size() > 1)	{
				Collections.sort(movies);
			}
			for(String s : movies)	{
				this.createContent.append("\t"+ s +"\n");
			}
		}
		
		/**
		 * Method to find
		 * Product IDs of the products with the highest average score (field product/productId)
		 * -------productId -> avg score
		 */
		
		void moviesWithMaxRevScore()	{
			
			HashMap<String, Double> movieRevScore = DataStr.getMovieRevScore();
			double maxMovieRevScore = 0;
			LinkedList<String> movies = new LinkedList<String>();
			
			for(Map.Entry<String, Double> entry : movieRevScore.entrySet())	{
				if(entry.getValue() > maxMovieRevScore )	{
					maxMovieRevScore = entry.getValue();
				}
			}
			
			this.createContent.append("Products with the highest average score:\n");
			for(Map.Entry<String, Double> entry : movieRevScore.entrySet())	{
				if(entry.getValue() == maxMovieRevScore)	{
					movies.add(entry.getKey());
				}
			}
			
			if(movies.size() > 1)	{
				Collections.sort(movies);
			}
			for(String s : movies)	{
				this.createContent.append("\t"+ s +"\n");
			}
			
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	}



