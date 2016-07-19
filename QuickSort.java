
public class QuickSort {
	public static void main(String args[]){
		int[] numbers = {10, 9, 8 , 7, 6, 5, 4, 3, 2, 1};
		sort(numbers, 0, numbers.length - 1);		
		for(int num : numbers){
			System.out.println(num);
		}
	}

	private static void sort(int[] numbers, int start, int end){
		if(start < end){
			int pIndex = partition(numbers, start, end);
			sort(numbers, start, pIndex - 1);
			sort(numbers, pIndex + 1, end);
		}
	}
	
	private static int partition(int[] numbers, int start, int end){
		int pivot = numbers[end];
		int pIndex = start;
		for(int i = start; i < end ; i++){
			if(numbers[i] <= pivot){
				int temp = numbers[i];
				numbers[i] = numbers[pIndex];
				numbers[pIndex] = temp;
				pIndex++;
			}
		}
		numbers[end] = numbers[pIndex];
		numbers[pIndex] = pivot;
		return pIndex;
	}
}
