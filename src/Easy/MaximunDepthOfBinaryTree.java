/*
 * Descripiton:
	Given the root of a binary tree, return its maximum depth.

	A binary tree's maximum depth is the number of nodes along the longest path 
	from the root node down to the farthest leaf node.
	
Explaination:
	1. two appraches a. DFT(depth-first travesal) and b.BFT(Breath-first traversal i.e. Level order traversal)
	2. we will use DFT 
		2.1 because if we go with BFT then time complexcity = O(n) 
		2.2 i.e. we have to travel unnessary for all the node.
	3. with DFT time complexicity = O(height)
	4. And to solve this we will use a formule
	5. ! + max(leftHeight, rightHeight)
			
*/


package Easy;

public class MaximunDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class SolutionMaximunDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
//      formula will be (1 + Max(leftH, rightH)) 
        return (1 + Math.max(leftHight, rightHight));
    }   
}
