
public class BubbleSort {
	public static void main(String args[]){
		int[] numbers = {10, 9, 8 , 7, 6, 5, 4, 3, 2, 1};
		sort(numbers);		
		for(int num : numbers){
			System.out.println(num);
		}
	}
	
	public static void sort(int[] numbers){
		for(int k = 1; k < numbers.length ; k++){
			boolean flag = true;
			for(int i = 0 ; i < numbers.length - k ; i++){
					if(numbers[i] > numbers[i+1]){
						int temp = numbers[i];
						numbers[i] = numbers[i+1];
						numbers[i+1] = temp;
						flag = false;
					}
			}	
			if(flag){
				break;
			}
		}
	}
}
