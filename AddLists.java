import java.util.ArrayList;
import java.util.List;


public class AddLists {

	 static List<Integer> list1 = new ArrayList<Integer>();
	 static List<Integer> list2 = new ArrayList<Integer>();
	 static List<Integer> list3 = new ArrayList<Integer>();
	 static List<Integer> list4 = new ArrayList<Integer>();
	 
	 public static void main(String[] args) {
		 list1.add(4);
		 list1.add(3);
		 list1.add(2);
		 list2.add(3);
		 list2.add(9);
		 list2.add(9);
		 list3.add(1);
		 int max = list1.size() > list2.size() ? list1.size() : list2.size();
		 max = max > list3.size() ? max : list3.size();
		 addLists(0, max-1);	
		 for(int i : list4){
			 System.out.println(i);
		 }
	 }

	private static void addLists(int remainder, int index) {
		 int count = remainder;
		 if(list1.size() > index){
			 count += list1.get(index);
		 }
		 if(list2.size() > index){
			 count += list2.get(index);
		 }
		 if(list3.size() > index){
			 count += list3.get(index);
		 }
		 remainder = count / 10;
		 count = count % 10;
		 if(index > 0){
			 addLists(remainder, index - 1);
		 }
		 list4.add(count);
	}
}
