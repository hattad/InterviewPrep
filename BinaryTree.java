import java.util.Stack;


public class BinaryTree {

	TreeNode root;
	
	public void add(int value){
		TreeNode node = new TreeNode();
		node.leftChild = null;
		node.rightChild = null;
		node.value = value;
		if(root == null){
			root = node;
			return;
		} else {
			TreeNode current = root;
			TreeNode parent;
			while(true){
				parent = current;
				if(value < current.value){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = node;
						return;
					}					
				} else {
					current = current.rightChild;
					if(current == null){
						parent.rightChild = node;
						return;
					}
				}
			}
		}
	}
	
	
	public TreeNode getInorderSuccessor(TreeNode root, int value){
		TreeNode current = find(value);
		if(current == null){
			return null;
		}
		if(current.rightChild != null) {  //Case 1: Node has right subtree
			return findMin(current.rightChild); // O(h)
		} else {
			TreeNode successor = null;
			TreeNode ancestor = root;
			while(ancestor!=current){
				if(current.value < ancestor.value) {
					successor = ancestor; // so far this is the deepest node for which current node is in left
					ancestor = ancestor.leftChild;
				}
				else
					ancestor = ancestor.rightChild;
			}
			return successor;
		}
	}
	
	private TreeNode findMin(TreeNode node) {
		if(node == null) return null;
		while(node.leftChild != null)
			node = node.leftChild;
		return node;
	}

	public int findHeight(TreeNode root){
		if(root == null){
			return -1;
		}
		int leftHeight = -1;
		int rightHeight = -1;
		leftHeight = findHeight(root.leftChild);
		rightHeight = findHeight(root.rightChild);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	//Also called Level Order Traversal
	public void inOrderTraversal(TreeNode current){
		if(current != null){
			inOrderTraversal(current.leftChild);
			System.out.println(current.value);
			inOrderTraversal(current.rightChild);
		}		
	}
	
	public void preOrderTraversal(TreeNode current){
		if(current != null){			
			System.out.println(current.value);
			preOrderTraversal(current.leftChild);
			preOrderTraversal(current.rightChild);
		}		
	}
	
	public void postOrderTraversal(TreeNode current){
		if(current != null){
			postOrderTraversal(current.leftChild);
			postOrderTraversal(current.rightChild);
			System.out.println(current.value);
		}		
	}
	
	public static int getBalancedHeight(TreeNode root)  {  
      if (root == null)  
      {  
         return 0;  
      }  
  
      int leftBalancedHeight = getBalancedHeight(root.leftChild);  
      int rightBalancedHeight = getBalancedHeight(root.rightChild);  
  
      if ((Math.abs(leftBalancedHeight - rightBalancedHeight) > 1) ||   
            (leftBalancedHeight == -1) || (rightBalancedHeight == -1))  
      {  
         return -1;  
      }  
        
      return Math.max(leftBalancedHeight, rightBalancedHeight) + 1;  
   }  
	
	public TreeNode find(int value){
		TreeNode current = root;
		while(value!=current.value){
			if(value < current.value){
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if(current == null){
				return null;
			}
		}
		return current;
	}
	
	public void delete(TreeNode node, int value){
		if(node == null){
			return;
		} else if(value < node.value){
			delete(node.leftChild, value);
		} else if(value > node.value){
			delete(node.rightChild, value);
		} else {
			if(node.leftChild == null && node.rightChild == null){
				node = null;				
			} else if(node.leftChild == null){
				node = node.rightChild;
			} else if(node.rightChild == null){
				node = node.leftChild;
			} else {
				TreeNode temp = findMin(node.rightChild);
				node.value = temp.value;
				delete(node.rightChild, temp.value);
			}
		}
	}
		
	void inorderTraversal_itr(TreeNode root) {
	  java.util.Stack<TreeNode> s = new Stack<TreeNode>();
	  TreeNode current = root;
	  while (!s.empty() || current!=null) {
	    if (current!=null) {
	      s.push(current);
	      current = current.leftChild;
	    } else {
	      current = s.pop();
	      System.out.println(current.value);
	      current = current.rightChild;
	    }
	  }
	}
	
	void postorderTraversal_itr(TreeNode root) {
	  java.util.Stack<TreeNode> s = new Stack<TreeNode>();
	  TreeNode current = root;
	  s.push(current);
	  TreeNode previous = null;
	  while (!s.empty()) {
	      current = s.peek();
	      if (current == null) {
	    	  s.pop();
	      } else if(current.leftChild == null && current.rightChild == null){
	    	  System.out.println(s.pop().value);
	      } else if(current.leftChild == previous){
	    	  s.push(current.rightChild);
	      } else if(current.rightChild == previous){
	    	  System.out.println(s.pop().value);
	      } else {
	    	  s.push(current.leftChild);
	      } 	
	      previous = current;
	    }
	}

	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		tree.add(100);
		tree.add(150);
		tree.add(50);
		tree.add(200);
		tree.add(250);
		tree.postOrderTraversal(tree.root);
		tree.postorderTraversal_itr(tree.root);
		//tree.delete(tree.root, 100);
		//tree.preOrderTraversal(tree.root);
	}
}
