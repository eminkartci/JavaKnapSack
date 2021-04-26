
// IMPORTS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// KnapSack
	// Reading & Generating the items

public class KnapSack {
	
	
	// Program starts here
	public static void main(String[] args) {
		
		Data problemData = ReadData();

		
	}

	// Read data and create item array and return them
	private static Data ReadData() {
		
		// initialize
		Data problemData = new Data();
		
		// Read data from csv file 
		try {
			BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("/Users/eminkartci/eclipse-workspace/JavaKnapSack/src/data.csv")));
			
			// Read first line
			String line = bufferedReader.readLine();
			
			// split the line wrt comma
			String[] item_id_array = line.split(",");
			
			line = bufferedReader.readLine();
			
			String[] item_value_array = line.split(",");
			
			line = bufferedReader.readLine();
			
			String[] item_value_weight = line.split(",");
			
			line = bufferedReader.readLine();
			
			String[] item_value_time = line.split(",");
			
			System.out.println(line);
		
		// Inform the user
		} catch (Exception e ) {
			e.printStackTrace();
		}

		return problemData;
		
	}
	
}
