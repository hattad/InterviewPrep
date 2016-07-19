
public class SpiralPrint {

	public static void main(String args[]){
		int[][] array = {{1,2,3,4} , {5,6,7,8} , {9,10,11,12} , {13,14,15,16}};
		int rowStart = 0;
		int columnStart = 0;
		int rowEnd = array.length;
		int columnEnd = array[0].length;
		while(columnStart < columnEnd && rowStart < rowEnd){
			for(int i = columnStart; i < columnEnd ; i ++){
				System.out.println(array[rowStart][i]);
			}
			for(int i = rowStart + 1; i < rowEnd ; i ++){
				System.out.println(array[i][columnEnd - 1]);
			}
			for(int i = columnEnd - 2; i >= columnStart ; i --){
				System.out.println(array[rowEnd - 1][i]);
			}
			for(int i = rowEnd - 2; i > rowStart ; i --){
				System.out.println(array[i][columnStart]);
			}
			rowStart++;
			rowEnd--;
			columnStart++;
			columnEnd--;
		}
	}
}
