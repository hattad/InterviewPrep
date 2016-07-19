
public class MergeSort {

	public static void main(String args[]){
		int[] numbers = {10, 9, 8 , 7, 6, 5, 4, 3, 2, 1};
		sort(numbers);		
		for(int num : numbers){
			System.out.println(num);
		}
	}
	
	private static void sort(int[] numbers) {
		int length = numbers.length;
		if(length < 2){
			return;
		}
		int mid = length / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[length-mid];
		for(int i = 0 ; i < mid ; i++){
			leftArray[i] = numbers[i];
		}
		for(int i = mid ; i < length ; i++){
			rightArray[i - mid] = numbers[i];
		}
		sort(leftArray);
		sort(rightArray);
		merge(leftArray, rightArray, numbers);
	}

	public static void merge(int[] leftArray, int[] rightArray, int[] numbers){
		int i = 0;
		int j = 0;
		int k = 0;
		int nL = leftArray.length;
		int nR = rightArray.length;
		while(i < nL && j < nR){
			if(leftArray[i] <= rightArray[j]){
				numbers[k] = leftArray[i];
				i++;
			} else {
				numbers[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while(i < nL){
			numbers[k] = leftArray[i];
			i++;
			k++;
		}
		while(j < nR){
			numbers[k] = rightArray[j];
			j++;
			k++;
		}
	}
}
