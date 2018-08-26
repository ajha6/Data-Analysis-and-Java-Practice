package cs601.project0;

public class AmazonReviews {

	//movies.txt: https://snap.stanford.edu/data/web-Movies.html
	
	public static void main(String[] args) {
		//TODO: Your code here!
		//create check for the arguments 
		if(args.length !=  4)	{
			System.out.println("Please input 4 cmd line params");
			System.exit(1);
		}
		if( (args[0].equals("-input")) && (args[2].equals("-output"))
				&& (args[1].contains("txt")) && (args[3].contains("txt")) )	{
			//System.out.println("everything looks right");
			//put code here - and send input file to FileRead class
			//new DataStr();
			new FileRead(args[1]);
			//rest of the code goes here
			DataStrInsight dsi = new DataStrInsight();
			dsi.usersWithMaxReviews();
			dsi.moviesWithMaxReviews();
			dsi.moviesWithMaxRevScore();
			/////
			new CreateOutput(args[3]);
			
		}
		else	{
			System.exit(1);
		}
		
	}	
}
