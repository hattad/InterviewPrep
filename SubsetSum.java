import java.util.ArrayList;

/**
 * Find a subset of elements that are selected from a given set whose sum adds
 * up to a given number K. Assume that the set contains non-negative, unique
 * values.
 */
public class SubsetSum {
	public static void findSubsetSum(int[] numbers, int sum) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (findSubsetSum(numbers, i, subset, sum)) {
				System.out.println(subset);
				subset = new ArrayList<Integer>();
			}
		}
	}

	private static boolean findSubsetSum(int[] numbers, int index,
			ArrayList<Integer> subset, int sum) {
		System.out.println("Invoked with : " + index + " Sum : " + sum);
		if (index >= numbers.length) {
			return false;
		}

		if (sum - numbers[index] == 0) {
			subset.add(numbers[index]);
			return true;
		}

		if (sum - numbers[index] < 0) {
			return false;
		}

		sum -= numbers[index];
		for (int i = index + 1; i < numbers.length; i++) {
			if (findSubsetSum(numbers, i, subset, sum)) {
				subset.add(numbers[index]);
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int values[] = { 1, 2, 3, 4};
		//System.out.println(Arrays.toString(values));
		findSubsetSum(values, 6);
	}
}