import java.util.HashMap;


public class MatrixPath {
	
	public static void main(String args[]){
		int[][] matrix = {
				{1,2},{3,4}				
				};
		//for(int i = 0 ; i < matrix.length; i++){
		//	for(int j = 0; j < matrix[0].length ;  j++){
				boolean flag = findPath(matrix, 1, 0);
			if(flag == true){
				System.out.println("There is a path from this item to Atlantic and Pacific");
			} else {
				System.out.println("No path from this item to Atlantic or Pacific");
			}
		//	}
		//}
	}

	private static boolean findPath(int[][] matrix, int i, int j) {
		HashMap<Integer, Integer> paths = new HashMap<Integer, Integer>();
		paths.put(i, j);		
		if(i-1 >= 0 && matrix[i-1][j] < matrix[i][j]){
			paths.put(i-1, j);
			findPath(matrix, i-1, j);
		}
		if(j+1 < matrix[0].length && matrix[i][j+1] < matrix[i][j]){
			paths.put(i, j+1);
			findPath(matrix, i, j+1);
		}
		if(i-1 >= 0 && j-1 >= 0 && matrix[i-1][j-1] < matrix[i][j]){
			paths.put(i-1, j-1);
			findPath(matrix, i-1, j-1);
		} 
		if(paths.containsKey(0) && paths.containsValue(matrix[0].length - 1)){
			return true;
		} 
		return false;
	}

}
