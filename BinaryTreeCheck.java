


public class BinaryTreeCheck {
	public static boolean isBinary(TreeNode node) {
		if(null == node){
			return true;
		}
		if(null != node.leftChild && node.value < node.leftChild.value){
			return false;
		}				
		if(null != node.rightChild && node.value > node.rightChild.value){
			return false;
		} 
		return isBinary(node.leftChild) && isBinary(node.rightChild);
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return sortedArrayToBST(num, 0, num.length - 1);
	}
 
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.leftChild = sortedArrayToBST(num, start, mid - 1);
		root.rightChild = sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}
}
