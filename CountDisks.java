import java.util.ArrayList;
import java.util.List;


public class CountDisks {
	 public static void main(String args[]){
		 int[] sizes = {80,70,30,20};
		 List<Bin> bins = new ArrayList<Bin>();
		 for(int i = 0; i < sizes.length ; i++){
			 if(i==0){
				 Bin bin = new Bin(100, new ArrayList<Integer>());
				 bin.getItems().add(sizes[i]);
				 bin.setCapacity(bin.getCapacity() - sizes[i]);
				 bins.add(bin);
			 } else {
				 int index = findBestFit(sizes[i], bins);
				 if(index == -1){
					 Bin bin = new Bin(100, new ArrayList<Integer>());
					 bin.getItems().add(sizes[i]);
					 bin.setCapacity(bin.getCapacity() - sizes[i]);
					 bins.add(bin);
				 } else {
					 Bin bin = bins.get(index);
					 bin.getItems().add(sizes[i]);
					 bin.setCapacity(bin.getCapacity() - sizes[i]);
				 }
			 }
		 }
		 System.out.println("Number of Disks is : " + bins.size());
		 for(int j = 0; j < bins.size() ; j++){
				Bin bin = bins.get(j);
				System.out.println("Bin number : " + j);
				System.out.println("Elements are : ");
				for(int i : bin.getItems()){
					System.out.println(i);
				}
		 }
	 }

	private static int findBestFit(int i, List<Bin> bins) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int j = 0; j < bins.size() ; j++){
			Bin bin = bins.get(j);
			if(bin.getCapacity() >= i){
				if((bin.getCapacity() - i) < min){
					min = bin.getCapacity() - i;
					index = j;
				}
			}
		}
		return index;
	}
}
