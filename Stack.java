import java.util.Arrays;


public class Stack {
	
	int[] stackData;
	
	int headIndex;
	
	Stack(int size){
		stackData = new int[size];
		Arrays.fill(stackData, -1);
		headIndex = -1;
	}
	
	public void pop(){
		if(null != stackData && headIndex != -1){
			headIndex -- ;
		}
	}
	
	public void push(int data){
		headIndex ++;
		stackData[headIndex] = data;
	}

	public void printStack(){
		if(null != stackData && headIndex != -1){
			for(int i = headIndex ; i >=0 ; i--){
				System.out.println(stackData[i]);
			}
		}
	}
	
	public static void main(String args[]){
		Stack stack = new Stack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.pop();
		stack.printStack();
	}
	
	public static void main(){
		
	}
}
