import java.util.ArrayList;

public class SmallestWeightSolver {

    private Data data;
    private ArrayList<Item> selectedItems = new ArrayList<Item>();
    private int occupiedCapacity = 0;

    public SmallestWeightSolver(Data data){
        this.data = data;
    }

    public void solve(){


        ArrayList<Item> tempItems = data.items;

        for( int i = 0 ; i < data.items.size() ; i++){

            Item lessWItem = null;

            for (Item item : tempItems){

                if(lessWItem == null){
                    lessWItem = item;
                }else{

                    if (lessWItem.getWeight() > item.getWeight()){
                        lessWItem = item;
                    }

                }

            }

            if(occupiedCapacity + lessWItem.getWeight() <= data.knapsackCapacity){

                selectedItems.add(lessWItem);
                tempItems.remove(lessWItem);
                occupiedCapacity += lessWItem.getWeight();

            }else{

                tempItems.remove(lessWItem);

            }

        }

        showSelected();
        
    }

    public void showSelected(){

        for (Item i : selectedItems){
            System.out.println(i);
        }

    }

    
}
