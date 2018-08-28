package cs601.project0;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRead {
	
	private String productId;
	private String userId;
	private double score;
	
	//constructor
	public FileRead(String inputFile)	{
		
		Path path = Paths.get(inputFile);
		
		try(	
				BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"))
				)	
		{
			String line;
			while( (line = reader.readLine()) != null )	{
				//send line to patternMatcher method
				this.patternMatcher(line);
			}
			
		}
		catch(IOException ioe)	{
			System.out.println(ioe.getMessage());
		}	
	
	}//closing constructor
	
	private void patternMatcher(String thisLine)	{
		//matching the line to check if it is a - productId or userId or score
		if(thisLine.matches("^product/productId:(.*)"))	{
			this.productId = getValue(thisLine, "(.*)productId: ");
		}
		
		if(thisLine.matches("^review/userId:(.*)"))	{
			this.userId = getValue(thisLine, "(.*)userId: ");
		}
		
		if(thisLine.matches("^review/score:(.*)")) {
			this.score = Double.parseDouble(getValue(thisLine, "(.*)score: "));
			this.eachReviewSet();
		}
		
	}//closing patternMatcher
	
	//method to get values for productId, userId and score
	private String getValue(String thisLine, String splitWise)	{
		String[] values = thisLine.split(splitWise);
		return values[1];	
	}
	
	//send values to DataStr class
	private void eachReviewSet()	{
		//(this.productId, this.userId, this.score)
		DataStr.editData(this.userId);
		DataStr.editData(this.productId, this.score);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testing this class
		//FileRead fr = new FileRead("movies1.txt");
		

	}

}
