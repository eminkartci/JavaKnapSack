

import java.util.HashMap;

import gurobi.*;

public class Solver {
	
	// Requires a data
	private Data data;
	private HashMap<String,GRBVar> itemID_grbVAr = new HashMap<String,GRBVar>();
	
	// Constructor
	public Solver (Data data) {
		this.data = data;
	}
	
	public void Solve() {
		
		try {
			
			// Generate an environment and model
			GRBEnv env = new GRBEnv("emin.dev");
			GRBModel model = new GRBModel(env);
			
			// Get item count
			int itemCount = data.item.size();
			
			for(int i = 0 ; i < itemCount ; i++) {
				
				itemID_grbVAr.put(data.item.get(i).getId(), model.addVar(0, 1, 0, GRB.BINARY, "Item_"+ i)) ;
				
			}
			
			System.out.println(itemID_grbVAr);
			
			
			
			// Delete environment and model
			env.dispose();
			model.dispose();
			
			
		}catch(Exception e) {
			System.out.println("There is a problem in Solver !!");
		}
		
	}

}
