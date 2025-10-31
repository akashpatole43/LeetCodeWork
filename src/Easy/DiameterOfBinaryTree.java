/*
 * Issue: https://leetcode.com/problems/diameter-of-binary-tree/description/
youtube: https://www.youtube.com/watch?v=Rezetez59Nk
	
Description:
	Given the root of a binary tree, return the length of the diameter of the tree.

			The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
			This path may or may not pass through the root.

			The length of a path between two nodes is represented by the number of edges between them.
			
Explaination:
	1. To solve this we should know how to finad the height of tree (MaximunDepthOfBinaryTree)
	2. formaula = Diameter = leftHeight + RightHeight
	3. max diameter = max(diameter, leftHeight+rightHeight)
	4. TC = O(n) and SC = O(n)

*/
package Easy;

public class DiameterOfBinaryTree {

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
 
class SolutionDiameterOfBinaryTree {
    private int getHeightOfTree(TreeNode root, int[] maxDiameter) {
        // check the root is null or not
        if (root == null) return 0;

        // iterate to left and get left tree height
        int leftHeight = getHeightOfTree(root.left, maxDiameter);
        // iterate to right and get right tree height
        int rightHeight = getHeightOfTree(root.right, maxDiameter);
        // store max diameter value
        // formula diameter = leftH + rightH
        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight+rightHeight);
        // retunr the height of tree
        // formula height = 1 + max(left, right);
        return 1+Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // variable to get get max diameter value
        //  In java we can not use varible are reference, so instead of varibale we will use array
        int[] diameter = new int[1];
        // get the height of tree
        getHeightOfTree(root, diameter);
        // return max diameter
        return diameter[0];
    }
}
