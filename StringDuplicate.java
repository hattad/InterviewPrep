
public class StringDuplicate {
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
		int val = str.charAt(i);
		if (char_set[val]) return false;
		char_set[val] = true;
		}
		return true;
	}
	
	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
		int val = str.charAt(i) - 'a';
		if ((checker & (1 << val)) > 0) return false;
		checker |= (1 << val);
		}
		return true;
	}
	
	public static void removeDuplicates(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		System.out.println(str); 
	}
	
	public static void reverse(char[] input){
		for(int i = 0; i < input.length/2; i++){
			char c = input[i];
			input[i] = input[input.length - 1 - i];
			input[input.length - 1 - i] = c;
		}
		System.out.println(input);
	}
	
	public static void main(String args[]){
		//System.out.println(isUniqueChars2("Deepa"));
		//System.out.println(isUniqueChars("Deepa"));
		removeDuplicates(new char[]{'a', 'b', 'a', 'b', 'a'});
		//reverse("Deepa".toCharArray());
	}
}
