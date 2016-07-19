
public class InsertionSort {
	public static void main(String args[]){
		int[] numbers = {10, 9, 8 , 7, 6, 5, 4, 3, 2, 1};
		sort(numbers);		
		for(int num : numbers){
			System.out.println(num);
		}
	}
	
	public static void sort(int[] numbers){
		for(int k = 1; k < numbers.length ; k++){
			int value = numbers[k];
			int hole = k;
			while(hole > 0 && numbers[hole - 1] > value){
				numbers[hole] = numbers[hole - 1];
				hole --;
			}
			numbers[hole] = value;
		}
	}
}
