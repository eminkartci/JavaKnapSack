

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
			
			// Constraint 1 - Time 
			GRBLinExpr timeExp = new GRBLinExpr();
			for(int i = 0 ; i < itemCount ; i++) {
				timeExp.addTerm(data.item.get(i).getTime(), itemID_grbVAr.get(Integer.toString(i)));
			}
			model.addConstr(timeExp, GRB.LESS_EQUAL, data.timeCapacity, "Time Constaint Equation");
			
			
			// Constraint 2 - Weight 
			GRBLinExpr weightExp = new GRBLinExpr();
			for(int i = 0 ; i < itemCount ; i++) {
				weightExp.addTerm(data.item.get(i).getWeight(), itemID_grbVAr.get(Integer.toString(i)));
			}
			model.addConstr(weightExp, GRB.LESS_EQUAL, data.knapsackCapacity, "Weight Constaint Equation");
			
			
			// Objective - Maximize Value
			GRBLinExpr valueObj = new GRBLinExpr();
			for(int i = 0 ; i < itemCount ; i++) {
				valueObj.addTerm(data.item.get(i).getValue(), itemID_grbVAr.get(Integer.toString(i)));
			}
			model.setObjective(valueObj,GRB.MAXIMIZE);
			
			
			
			// Delete environment and model
			env.dispose();
			model.dispose();
			
			
		}catch(Exception e) {
			System.out.println("There is a problem in Solver !!");
		}
		
	}

}
