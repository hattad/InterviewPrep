
public class FibonacciSeries {

	public static void main(String args[]){
		int[] fibo = getFiboSeries(10);
		for(int i : fibo){
			System.out.println(i);
		}
	}

	private static int[] getFiboSeries(int num) {
		if(num<0){
			return null;
		}
		int[] fibo = new int[num];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<num; i++){
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		return fibo;
	}
}
