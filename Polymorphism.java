
public class Polymorphism {
	public static void main(String args[]){
		Employee e = new Manager();
		e.getName();
		Manager m = new Manager();
		m.getName();
		Employee me = new Employee();
		me.getName();
	}

}
