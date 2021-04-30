import java.util.HashMap;

public class HeruisticSolver {

    private Data data;
    private HashMap<Item,Double> ratioItem = new HashMap<Item,Double>();

    public HeruisticSolver(Data data){
        this.data = data;
    }

    public void sortItemsPutHashMap(){

        for(Item i : this.data.items){

            double ratio = i.getValue() / i.getWeight();
            ratioItem.put(i,ratio);

        }

        System.out.println(ratioItem);

    }

    public void selectBestItems(){

        HashMap<Item,Double> tempItems = this.ratioItem;
        Item bestItem = null;

        for (Item i : tempItems.keySet()){

            if(bestItem == null){
                bestItem = i;
            }else{

                if( tempItems.get(i) > tempItems.get(bestItem) ){

                    bestItem = i;
                    
                }

            }

        }


    }

    
}
