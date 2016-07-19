
public class CountOnes {

	public static void main(String args[]){
		int number = 11111111;
		int count = 0;
		while(number!=0){
			int temp = number % 10;
			if(temp==1){
				count++;
			}
			number = number / 10;
		}
		System.out.println("Number of 1s are : " + count);
	}
}
