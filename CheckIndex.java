
public class CheckIndex {

	static char[] charArray = {'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O'};
	
	public static void main(String args[]){
		int length = charArray.length;
		int[] index = new int[length];
		int count = 0;
		for(int i=0; i < length ; i++){
			if(charArray[i]=='X'){
				if(i>0){
					for(int j=i-1; j>0; j--){
						if(charArray[j]=='O'){
							count++;
						} else {
							break;
						}
					}
				}
				for(int j=i+1; j < length; j++){
					if(charArray[j]=='O'){
						count++;
					} else {
						break;
					}
				}
				index[i] = count;
			}
		}
		int maxIndex = 0;
		for(int i=0; i < length ; i++){
			if(index[i] > index[maxIndex]){
				maxIndex = i;
			}
		}
		System.out.println("Index with largest value is : " + maxIndex);
	}
}
