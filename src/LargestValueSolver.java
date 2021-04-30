import java.util.ArrayList;

public class LargestValueSolver {

    private Data data;
    private ArrayList<Item> selectedItems = new ArrayList<Item>();
    private int occupiedCapacity = 0;

    public LargestValueSolver(Data data){
        this.data = data;
    }

    public void solve(){


        ArrayList<Item> tempItems = data.items;

        for( int i = 0 ; i < data.items.size() ; i++){

            Item mostValItem = null;

            for (Item item : tempItems){

                if(mostValItem == null){
                    mostValItem = item;
                }else{

                    if (mostValItem.getValue() < item.getValue()){
                        mostValItem = item;
                    }

                }

            }

            if(occupiedCapacity + mostValItem.getWeight() <= data.knapsackCapacity){

                selectedItems.add(mostValItem);
                tempItems.remove(mostValItem);
                occupiedCapacity += mostValItem.getWeight();

            }else{

                tempItems.remove(mostValItem);

            }

        }

        showSelected();
        
    }

    public void showSelected(){

        int totalValue = 0;
        for (Item i : selectedItems){
            System.out.println(i);
            totalValue += i.getValue();
        }

        System.out.println("TOTAL VALUE: " + totalValue);

    }

    
}
