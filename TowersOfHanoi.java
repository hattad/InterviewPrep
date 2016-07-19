
public class TowersOfHanoi {
	 public static void main(String[] args) {
	    int nDisks = 3;
	    doTowers(nDisks, 'A', 'B', 'C');
	 }
	
	 public static void doTowers(int topN, char from, char using, char to) {
	    if (topN == 1){
	      System.out.println("Disk 1 from " + from + " to " + to);
	    }else {
	      doTowers(topN - 1, from, to, using);
	      System.out.println("Disk " + topN + " from " + from + " to " + to);
	      doTowers(topN - 1, using, from, to);
	    }
	 }
}
