package cs601.project0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateOutput {
	
	
	public static boolean now(String outFile, String mycontent)	{
		
		BufferedWriter bw = null;
		//FileWriter fw;
	      
		try {
			
			File file = new File(outFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			

			FileWriter fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
			bw.write(mycontent); 
			//bw.append("\n" + mycontent);    
			//System.out.println("File written Successfully");
			return true;
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage() );
			return false;
		}
		finally	{
			try{
				if(bw != null)	{
					bw.close();
				}
				//if(fw != null)	{
				//	fw.close();
				//}
			}catch(Exception e){
					System.out.println("Error in closing BufferedWriter");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CreateOutput.now("result.txt","Yes yes yes");
		
	}

}
