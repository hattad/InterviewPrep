

public class LinkedList {
	
	Node head;
	
	public void add(int value){
		if(head == null){
			Node node = new Node();
			node.data = value;
			node.next = null;
			head = node;
		} else {
			Node node = head;
			while(node.next != null){
				node = node.next;
			}
			Node obj = new Node();
			obj.data = value;
			obj.next = null;
			node.next = obj;
		}
	}
	
	public void delete(int value){
		Node current = head;
		Node previous = null;
		while(current != null){
			if(current.data == value){
				previous.next = current.next;
				break;
			} else {
				previous = current;
				current = current.next;
			}
		}
	}
	
	public void print(){
		Node current = head;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void reverse(Node node){
		if(node.next == null){
			head = node;
			return;
		}
		reverse(node.next);
		Node next = node.next;
		next.next = node;
		node.next = null;
	}
	
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.print();
		list.delete(20);
		list.print();
	}
}
