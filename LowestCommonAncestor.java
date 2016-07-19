
public class LowestCommonAncestor {

	public static TreeNode lca(TreeNode root, int n1, int n2)
	{
	    if (root == null) return null;
	 
	    // If both n1 and n2 are smaller than root, then LCA lies in left
	    if (root.value > n1 && root.value > n2)
	        return lca(root.leftChild, n1, n2);
	 
	    // If both n1 and n2 are greater than root, then LCA lies in right
	    if (root.value < n1 && root.value < n2)
	        return lca(root.rightChild, n1, n2);
	 
	    return root;
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode();
		root.value = 20;
		TreeNode left1 = new TreeNode();
		left1.value = 8;
		root.leftChild = left1;
		TreeNode right1 = new TreeNode();
		right1.value = 22;
		root.rightChild = right1;
		TreeNode left2 = new TreeNode();
		left2.value = 4;
		left1.leftChild = left2;
		TreeNode right2 = new TreeNode();
		right2.value = 12;
		left1.rightChild = right2;
		TreeNode left3 = new TreeNode();
		left3.value = 10;
		right2.leftChild = left3;
		TreeNode right3 = new TreeNode();
		right3.value = 14;
		right2.rightChild = right3;
		TreeNode node = lca(root, 10, 14);
		System.out.println("LCA for nodes for 10 and 14 is : " + node.value);
		node = lca(root, 14, 8);
		System.out.println("LCA for nodes for 14 and 8 is : " + node.value);
		node = lca(root, 10, 22);
		System.out.println("LCA for nodes for 10 and 22 is : " + node.value);
	}
}
