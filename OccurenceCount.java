
public class OccurenceCount {
	
	public static void main(String args[]){
		int[] numbers = {7, 7, 7, 7, 7, 7, 7, 7, 7};
		int num = 7 ;
		int lowIndex  = lowSearch(numbers, numbers.length, num);			
		if(lowIndex == -1){
			System.out.println("Element " + num + " not found");
			return;
		}
		int highIndex  = highSearch(numbers, numbers.length, num);
		System.out.println("Found " + ((highIndex-lowIndex)+1) + " occurence(s) of num : " + num);
	}

	private static int lowSearch(int[] numbers, int length, int num) {
		int low = 0;
		int high = length - 1;
		int mid = -1;
		int result = -1;
		while(low <= high){
			mid = (low + high)/2;
			if(num == numbers[mid]){
				result = mid;
				high = mid - 1;
			} else if(num < numbers[mid]){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	private static int highSearch(int[] numbers, int length, int num) {
		int low = 0;
		int high = length - 1;
		int mid = -1;
		int result = -1;
		while(low <= high){
			mid = (low + high)/2;
			if(num == numbers[mid]){
				result = mid;
				low = mid + 1;
			} else if(num < numbers[mid]){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}
}
