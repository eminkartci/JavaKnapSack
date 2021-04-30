import java.util.ArrayList;
import java.util.HashMap;

public class HeruisticSolver {

    private Data data;
    private HashMap<Item,Double> ratioItem = new HashMap<Item,Double>();
    private ArrayList<Item> selectedItems = new ArrayList<Item>();
    private int occupiedCapacity = 0;

    public HeruisticSolver(Data data){
        this.data = data;
    }

    public void sortItemsPutHashMap(){

        for(Item i : this.data.items){

            double ratio = i.getValue() / i.getWeight();
            ratioItem.put(i,ratio);

        }

        //System.out.println(ratioItem);

    }

    public void showSelected(){

        for (Item i : selectedItems){
            System.out.println(i);
        }

    }

    public void selectBestItems(){

        sortItemsPutHashMap();

        HashMap<Item,Double> tempItems = this.ratioItem;
        Item bestItem = null;

        for (int j = 0 ; j < tempItems.size(); j++){

            for (Item i : tempItems.keySet()){
                
                if(bestItem == null){
                    bestItem = i;
                }else{
    
                    if (tempItems.get(i) == null || tempItems.get(bestItem) == null){
                        break;
                    }


                    if( tempItems.get(i) > tempItems.get(bestItem) ){
    
                        bestItem = i;
    
                    }
    
                }
    
            }
    
            if( occupiedCapacity + bestItem.getWeight() <= this.data.knapsackCapacity){
    
                occupiedCapacity += bestItem.getWeight();
                selectedItems.add(bestItem);
                tempItems.replace(bestItem, -1.0);
    
            }else{
    
                tempItems.replace(bestItem, -1.0);
    
            }
    

        }
        
        showSelected();

    }

    
}
