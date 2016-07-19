
public class NextHighestNumber {

	public static void main(String args[]){
		char[] array = {'5','3','4','9','7','6'};
		for(int index = array.length - 1 ; index > 0 ; index--){
			if(array[index] > array[index-1]){
				int swapIndex = findIndextoSwap(index-1, array);
				if(swapIndex!=-1){
					swap(array, index-1, swapIndex);
					sort(array, index-1);
				}
				break;
			}
		}
		for(char c : array){
			System.out.println(c);
		}
	}

	private static void sort(char[] array, int index) {
		for(int i = index + 1; i < array.length ; i ++){
			for(int j = i + 1; j < array.length ; j ++){
				if(array[i] > array[j]){
					swap(array, i, j);
				}
			}
		}		
	}

	private static void swap(char[] array, int index, int swapIndex) {
		char temp = array[index];
		array[index] = array[swapIndex];
		array[swapIndex] = temp;
	}

	private static int findIndextoSwap(int index, char[] array) {
		int swapIndex = -1;
		int min = Integer.MAX_VALUE;
		for(int i = index ; i < array.length ; i ++){
			if(array[i] > array[index] && array[i] < min){
				min = array[i];
				swapIndex = i;
			}
		}
		return swapIndex;
	}
}
