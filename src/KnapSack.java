
// IMPORTS
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// KnapSack
	// Reading & Generating the items

public class KnapSack {
	
	
	// Program starts here
	public static void main(String[] args) {
		
		Data data = ReadData();

		Solver solver = new Solver(data);
		
		solver.Solve();
	}

	// Read data and create item array and return them
	private static Data ReadData() {
		
		// initialize
		Data data = new Data();
		
		data.item = new ArrayList<Item>();
		
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
			
			for (int i = 1 ; i  < item_id_array.length ; i++ ) {
				
				Item currentItem = new Item(item_id_array[i],Integer.parseInt( item_value_array[i]),Integer.parseInt(item_value_weight[i]),Integer.parseInt(item_value_time[i]));
				
				data.item.add(currentItem);
				
			}
		
			line = bufferedReader.readLine();
			
			String[] capacity_array = line.split(",");
			
			data.knapsackCapacity = Integer.parseInt(capacity_array[1]);
			
		// Inform the user
		} catch (Exception e ) {
			e.printStackTrace();
		}

		return data;
		
	}
	
}
