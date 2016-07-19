import java.util.List;


public class Bin {

	int capacity;
	List<Integer> items ;
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}

	public Bin(int capacity, List<Integer> items) {
		super();
		this.capacity = capacity;
		this.items = items;
	}
}
