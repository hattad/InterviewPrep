

public class Queue {
	
	Node head;
	
	Node tail;
	
	int size;
	
	int currentSize;
	
	Queue(int size){
		this.size = size;
	}
	
	public void insert(int data){
		if(currentSize == size){
			System.out.println("Queue is full");
			return;
		}
		Node node = new Node();
		node.data = data;
		node.next = null;
		if(head==null){
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		currentSize++;
	}
	
	public void delete(){
		if(currentSize > 0){
			Node current = head;
			head = current.next;
			currentSize--;
		}			
		if(currentSize == 0){
			head = null;
			tail = null;
			System.out.println("Queue is empty");
		}
	}
	
	public void print(){
		Node current = head;
		for(int i = 0; i < currentSize; i++){
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public static void main(String args[]){
		Queue queue = new Queue(10);
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);
		queue.insert(50);
		queue.delete();
		queue.delete();
		queue.print();		
	}
}
