import java.util.Arrays;
import java.util.Random;



public class Test {


	public static void main(String ... args) {
	    System.out.println(toBinary(2)+toBinary(1));
	}
	
	public static String toBinary(int num){
		char[] result = new char[16];
		Arrays.fill(result, '0');
		int index = 15;
		while(num>0){
			result[index] = Character.forDigit(num%2, 10);
			num = num/2;
			index -- ;
		}
		return String.valueOf(result);
	}

	
	public static void localMinimaTest(){
		System.out.println(findLocalMinima(new int[]{9,6,2,14,5,7,4}, 0, 7));
	}
	
	public static String randomString(int seed) {
	    Random rand = new Random(seed);
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; ; i++) {
	        int n = rand.nextInt(27);
	        if (n == 0) break;
	        sb.append((char) ('`' + n));
	    }
	    return sb.toString();
	}
    
	static int findLocalMinima(int[] arr, int start, int end)
	{
	  int mid = (start + end) / 2;
	  if (mid - 2 < 0 && mid + 1 >= arr.length)
	      return -1;
	  if (arr[mid - 2] > arr[mid - 1] && arr[mid - 1] < arr[mid])
	      return arr[mid - 1];
	  if (arr[mid - 1] > arr[mid - 2])
	      return findLocalMinima(arr, start, mid);
	  else
	      return findLocalMinima(arr, mid, end);
	}

    
}
