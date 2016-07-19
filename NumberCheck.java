import java.util.ArrayList;
import java.util.Arrays;



public class NumberCheck {
	
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
       ArrayList<String> operators = new ArrayList<String>();
       for (int x: partial) {
    	   switch((int) (Math.random()*4)) {
    	   		case 0: s += x;
    	   				operators.add("+");
    	   				break;
    	   		case 1: s -= x;
    	   				operators.add("-");
    	   				break;
    	   		case 2: s /= x;
    	   				operators.add("/");
    	   				break;
    	   		case 3: s*= x;
    	   				operators.add("*");
    	   				break;
    	   }
       }
       if (s == target){
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
            System.out.println("operators("+Arrays.toString(operators.toArray())+")="+target);
            //System.exit(0);
       }
       if (s >= target)
            return;
       
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
       
    }
    
    static void sum_up(ArrayList<Integer> numbers, int target) {
    	while(true){
    		sum_up_recursive(numbers,target,new ArrayList<Integer>());
    	}
    }
    
    public static void main(String args[]) {
        Integer[] numbers = {60,20,5,1,3};
        int target = 42;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
    }
}
