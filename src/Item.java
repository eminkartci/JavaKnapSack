
public class Item {
	
	// Attributes
	private String itemId;
	private int value;
	private int weight;
	
	// Constructor
	Item(String itemId){
		this.itemId=itemId;
	}
	
	// GETTER - SETTER
	public void setValue(int value) {
		this.value=value;
	}
	public void setWeight(int weight) {
		this.weight=weight;
	}
	public int getValue() {
		return this.value;
	}
	public int getWeight() {
		return this.weight;
	}
	public String getId() {
		return this.itemId;
	}

}
