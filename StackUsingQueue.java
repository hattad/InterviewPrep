public class StackUsingQueue {
	java.util.Queue<Integer> q1 = new java.util.LinkedList<Integer>();
	java.util.Queue<Integer> q2 = new java.util.LinkedList<Integer>();

	public void pop() {

		while (q1.size() > 1)
			q2.add(q1.poll());

		System.out.println("POPped:" + q1.poll());

		while (!q2.isEmpty())
			q1.add(q2.poll());

	}

	public void push(int val) {
		System.out.println("PUSHed:" + val);
		q1.add(val);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackUsingQueue suq = new StackUsingQueue();
		suq.push(5);
		suq.push(4);
		suq.push(3);
		suq.push(2);
		suq.push(1);

		suq.pop();
		suq.push(6);
		suq.pop();
		suq.pop();
		suq.pop();

	}

}