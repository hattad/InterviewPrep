
public final class Immutable {

	private final String name ;
	public Immutable(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public static void main(String args[]){
		Immutable im = new Immutable("hello");
	}
}
