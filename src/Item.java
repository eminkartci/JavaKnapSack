
public class Item {
	
	// Attributes
	private String id;
	private int value;
	private int weight;
	private int time;
	
	// Main Constructor
	public Item(String id,int value,int weight, int time){
		this.id		=id;
		this.value	=value;
		this.weight	=weight;
		this.time	=time;
	}

	// Side Constructor
	public Item(String id){
		this(id,0,0,0);
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
