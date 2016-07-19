
public class Binary {

	public static void main(String args[]){
		int i = 16;		
		System.out.println(Integer.toBinaryString(i));
		int j = ~i;
		System.out.println(Integer.toBinaryString(j));
		System.out.println(Integer.toBinaryString(updateBits(1024, 21, 2, 6)));
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; /* All 1’s */
		// 1’s through position j, then 0’s
		int left = max - ((1 << j) - 1);
		// 1’s after position i
		int right = ((1 << i) - 1);
		// 1’s, with 0s between i and j
		int mask = left | right;	
		System.out.println("Mask is"+Integer.toBinaryString(mask));
		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}
}
