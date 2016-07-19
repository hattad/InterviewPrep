
public class PowerOfTwo {

	public static void main(String args[]){
		int number = 128;
		int pow = 2;
		if(ispower(number, pow)){
			System.out.println("Number : " + number + " is a power of : " + pow);
		} else {
			System.out.println("Number : " + number + " is not a power of : " + pow);
		}
	}

	private static boolean ispower(int number, int pow) {
		if(number == 0){
			return false;
		}
		while(number != 1){
			if(number % 2 != 0){
				return false;
			}
			number = number / 2;
		}
		return true;
	}
}
