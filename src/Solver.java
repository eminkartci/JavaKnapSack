

import java.util.ArrayList;
import java.util.HashMap;

import gurobi.*;

public class Solver {
	
	// Requires a data
	private Data data;
	private HashMap<String,GRBVar> itemID_grbVAr = new HashMap<String,GRBVar>();
	private ArrayList<Item> selectedItems = new ArrayList<Item>();
	private double solutionWeigth,solutionTime,solutionValue;
	
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
				timeExp.addTerm(data.item.get(i).getTime(), itemID_grbVAr.get(data.item.get(i).getId()));
			}
			model.addConstr(timeExp, GRB.LESS_EQUAL, data.timeCapacity, "Time Constaint Equation");
			
			
			
			// Constraint 2 - Weight 
			GRBLinExpr weightExp = new GRBLinExpr();
			for(int i = 0 ; i < itemCount ; i++) {
				weightExp.addTerm(data.item.get(i).getWeight(), itemID_grbVAr.get(data.item.get(i).getId()));
			}
			model.addConstr(weightExp, GRB.LESS_EQUAL, data.knapsackCapacity, "Weight Constaint Equation");
			
			
			
			// Objective - Maximize Value
			GRBLinExpr valueObj = new GRBLinExpr();
			for(int i = 0 ; i < itemCount ; i++) {
				valueObj.addTerm(data.item.get(i).getValue(), itemID_grbVAr.get(data.item.get(i).getId()));
			}
			
			
			model.setObjective(valueObj,GRB.MAXIMIZE);

			model.write("problem_equations.lp");
			model.optimize();
			
			
//			// Delete environment and model
//			env.dispose();
//			model.dispose();
			
			
		}catch(Exception e) {
			System.out.println("There is a problem in Solver !!");
		}
		
	}
	
	// show all items
	public void showSolution() {
		
		for(Item i : data.item) {
			
			try {
				System.out.println(i.toString()+ "\nOptimized Value: " + itemID_grbVAr.get(i.getId()).get(GRB.DoubleAttr.X));
			} catch (GRBException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	// gather selected items
	public void gatherSelectedItems() {
		
		// loop all items
		for(Item i : data.item) {
			
			try {
				// get the optimized value
				double optimizedValue = itemID_grbVAr.get(i.getId()).get(GRB.DoubleAttr.X);
				
				if (optimizedValue == 1.0) {
					
					selectedItems.add(i);
					
				}
				
			} catch (GRBException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	// calculate total values
	public void calculateTotalValues() {
		
		this.solutionTime = 0;
		this.solutionWeigth = 0;
		this.solutionValue = 0;
		
		for (Item i : selectedItems) {
			
			this.solutionTime += i.getTime();
			this.solutionWeigth += i.getWeight();
			this.solutionValue += i.getValue();
		}
		
	}
	
	// show sum of the solution and items that are selected 
	public void showSum() {
		
		// hold selected items
		gatherSelectedItems();
		// calculate total value time weight
		calculateTotalValues();
	
		// Print to the screen
		System.out.println("--- Solution ---");
		System.out.println("| Total Time: " + this.solutionTime);
		System.out.println("| Total Weight: " + this.solutionWeigth);
		System.out.println("| Total Value: " + this.solutionValue);
		
		// SHOW SELECTED ITEMS
		System.out.println("\n\n SELECTED ITEMS ");
		
		for (Item i : selectedItems) {
			
			System.out.println(i.toString());
			
		}
		
	}
	

}
