import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {

    // print all subsets of the characters in s
    public static void comb1(String s) { comb1("", s); }

    // print all subsets of the remaining elements, with given prefix 
    private static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix,               s.substring(1));
        }
    }  

    // alternate implementation
    public static void comb2(String s) { comb2("", s); }
    private static void comb2(String prefix, String s) {
    	//System.out.println("Invoked with prefix : " + prefix + " String : " + s);
        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++)
            comb2(prefix + s.charAt(i), s.substring(i + 1));
    }  

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	if (S == null)
    		return null;
     
    	Arrays.sort(S);
     
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     
    	for (int i = 0; i < S.length; i++) {
    		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
     
    		//get sets that are already in result
    		for (ArrayList<Integer> a : result) {
    			temp.add(new ArrayList<Integer>(a));
    		}
     
    		//add S[i] to existing sets
    		for (ArrayList<Integer> a : temp) {
    			a.add(S[i]);
    		}
     
    		//add S[i] only as a set
    		ArrayList<Integer> single = new ArrayList<Integer>();
    		single.add(S[i]);
    		temp.add(single);
     
    		result.addAll(temp);
    	}
     
    	//add empty set
    	result.add(new ArrayList<Integer>());
     
    	return result;
    }
    
    // read in N from command line, and print all subsets among N elements
    public static void main(String[] args) {
       //String alphabet = "abc";
      //String elements = alphabet.substring(0, 3);

       // using first implementation
       //permutation(alphabet);
       //System.out.println();

       
       /*ArrayList<ArrayList<Integer>> integers = subsets(new int[]{5,4,1,2,3});
       for (ArrayList<Integer> a : integers) {
			System.out.println(a);
       }*/
       ArrayList<ArrayList<Character>> strings = subsetsString(new String("abcd").toCharArray());
       for (ArrayList<Character> a : strings) {
			System.out.println(a);
       }
       // using second implementation
      /* comb2(elements);
       System.out.println();*/
    }
    
    public static void permutation(String str) { 
        permutation("", str); 
    }

    private static void permutation(String prefix, String str) {
    	System.out.println("Prefix : "+prefix+" String : "+str);
        int n = str.length();
        if (n == 0) 
        	System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
    
	private static ArrayList<ArrayList<Character>> subsetsString(char[] S) {
		if (S == null)
    		return null;
     
    	Arrays.sort(S);
     
    	ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
     
    	for (int i = 0; i < S.length; i++) {
    		ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>>();
     
    		//get sets that are already in result
    		for (ArrayList<Character> a : result) {
    			temp.add(new ArrayList<Character>(a));
    		}
     
    		//add S[i] to existing sets
    		for (ArrayList<Character> a : temp) {
    			a.add(S[i]);
    		}
     
    		//add S[i] only as a set
    		ArrayList<Character> single = new ArrayList<Character>();
    		single.add(S[i]);
    		temp.add(single);
     
    		result.addAll(temp);
    	}
     
    	//add empty set
    	result.add(new ArrayList<Character>());
     
    	return result;
	}
    
}