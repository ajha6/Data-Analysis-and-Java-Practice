package cs601.project0;

public class AmazonReviews {

	//movies.txt: https://snap.stanford.edu/data/web-Movies.html
	/**
	 * The program reads movies.txt file, stores and processes data to generate 
	 * answers in written into another text file.
	 * 
	 * @param -input movies.txt -output actual.txt
	 */
	public static void main(String[] args) {
		//TODO: Your code here!
		//creating check for the arguments 
		if(args.length !=  4)	{
			System.out.println("Please input 4 cmd line params");
			System.exit(1);
		}
		if( (args[0].equals("-input")) && (args[2].equals("-output"))
				&& (args[1].contains("txt")) && (args[3].contains("txt")) )	{
			//sending input file to FileRead class
			new FileRead(args[1]);
			//FileRead class will send each review set to the DataStr class
			//Invoking DataStrInsight object to process data and get the answers
			DataStrInsight2 dsi = new DataStrInsight2();
			dsi.usersWithMaxReviews();
			dsi.moviesWithMaxReviews();
			dsi.moviesWithMaxRevScore();
			//sending formatted answers to CreateOutput class
			CreateOutput.now(args[3],dsi.getCreateContent());
			
		}
		else	{
			System.out.println("Please input line params in specified format");
			System.out.println("-input movies.txt -output actual.txt");
			System.exit(1);
		}
		
	}	
}
