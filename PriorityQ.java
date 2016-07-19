import java.util.PriorityQueue;


public class PriorityQ {

	public static void main(String args[]){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(10);
		pq.add(1);
		pq.add(2);
		pq.add(5);
		Object[] array = pq.toArray();
		//Arrays.sort(array);
		for(int i=0; i < array.length ; i++){
			System.out.println(array[i]);
		}
	}
}
