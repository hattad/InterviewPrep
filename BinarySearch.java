
public class BinarySearch {

	public static void main(String args[]){
		int[] numbers = {1, 2, 3, 4, 4, 7, 8, 10};
		int num = 9 ;
		int index  = search(numbers, numbers.length, num);		
		if(index == -1){
			System.out.println("Element " + num + " not found");
			return;
		}
		System.out.println("Found " + num + " at index : " + index);
	}

	private static int search(int[] numbers, int length, int num) {
		int low = 0;
		int high = length - 1;
		int mid = -1;
		while(low <= high){
			mid = (low + high)/2;
			if(num == numbers[mid]){
				return mid;
			} else if(num < numbers[mid]){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
