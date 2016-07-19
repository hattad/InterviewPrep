
public class SelectionSort {
	
	public static void main(String args[]){
		int[] numbers = {10, 9, 8 , 7, 6, 5, 4, 3, 2, 1};
		sort(numbers);		
		for(int num : numbers){
			System.out.println(num);
		}
	}
	
	public static void sort(int[] numbers){
		for(int i = 0 ; i < numbers.length - 1 ; i++){
			int min = i;
			for(int j = i + 1; j < numbers.length ; j++){
				if(numbers[j] < numbers[min]){
					min = j;
				}
			}
			int temp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = temp;
		}		
	}
}
