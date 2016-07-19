public class FindDeepestNode {

	class DeepestNode {
		  int value;
		  int level;
		}

	DeepestNode deepestNode(TreeNode node, DeepestNode currentDeepest, int currentLevel) {
	  if(node == null) return currentDeepest;
	
	  if(currentLevel >= currentDeepest.level) {
	    currentDeepest.level = currentLevel;
	    currentDeepest.value = node.value;
	  }
	
	  currentDeepest = deepestNode(node.leftChild, currentDeepest, currentLevel + 1);
	  currentDeepest = deepestNode(node.rightChild, currentDeepest, currentLevel + 1);
	
	  return currentDeepest;
	}
}