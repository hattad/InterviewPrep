import java.util.HashMap;
import java.util.Map.Entry;


public class Anagram {

	public static void main(String args[]){
		String str1 = "hello";
		String str2 = "olleh";
		HashMap<Character, Integer> strCountMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> strCountMap1 = new HashMap<Character, Integer>();
		for(char c : str1.toCharArray()){
			if(strCountMap.containsKey(c)){
				strCountMap.put(c, strCountMap.get(c)+1);
			} else {
				strCountMap.put(c, 1);
			}
		}
		for(char c : str2.toCharArray()){
			if(strCountMap1.containsKey(c)){
				strCountMap1.put(c, strCountMap1.get(c)+1);
			} else {
				strCountMap1.put(c, 1);
			}
		}
		for(Entry<Character, Integer> entry : strCountMap.entrySet()){
			if(!strCountMap1.containsKey(entry.getKey()) || !(strCountMap1.get(entry.getKey()) == entry.getValue())){
				System.out.println("Not Anagrams");
				return;
			}
		}
		System.out.println("Anagrams");
	}
}
