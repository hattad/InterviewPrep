
public class DeQue {
	
	Node head;
	
	Node tail;
	
	int size;
	
	int currentSize;
	
	DeQue(int size){
		this.size = size;
	}
	
	public void insertAtEnd(int data){
		if(currentSize == size){
			System.out.println("DeQue is full");
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
	
	public void insertAtStart(int data){
		if(currentSize == size){
			System.out.println("DeQue is full");
			return;
		}
		Node node = new Node();
		node.data = data;
		node.next = null;
		if(head==null){
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
		currentSize++;
	}
	
	public void deleteFromStart(){
		if(currentSize > 0){
			Node current = head;
			head = current.next;
			currentSize--;
		}			
		if(currentSize == 0){
			head = null;
			tail = null;
			System.out.println("DeQue is empty");
		}
	}
	
	public void deleteFromEnd(){
		if(currentSize > 0){
			Node current = head;
			Node previous = null;
			while(current.next != null) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			currentSize--;
		}			
		if(currentSize == 0){
			head = null;
			tail = null;
			System.out.println("DeQue is empty");
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
		DeQue deque = new DeQue(10);
		deque.insertAtEnd(10);
		deque.insertAtEnd(20);
		deque.insertAtEnd(30);
		deque.insertAtEnd(40);
		deque.insertAtEnd(50);
		deque.insertAtStart(5);
		deque.insertAtStart(1);
		deque.print();	
		deque.deleteFromStart();
		deque.deleteFromStart();
		deque.print();		
		deque.deleteFromEnd();
		deque.deleteFromEnd();
		deque.print();
	}
}

