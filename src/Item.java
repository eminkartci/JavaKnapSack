
public class Item {
	
	// Attributes
	private String id;
	private int value;
	private int weight;
	
	// Main Constructor
	public Item(String id,int value,int weight){
		this.id		=id;
		this.value	=value;
		this.weight	=weight;
	}

	// Side Constructor
	public Item(String id){
		this(id,0,0);
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
		return this.id;
	}

}
