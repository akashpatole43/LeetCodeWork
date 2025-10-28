/*
 * Description:
	Given a binary tree, determine if it is height-balanced.

Explination:
	1. to solve this we need to know how to identify the height of binary tree.
	2. Balanced binary tree = 
		1.1 For every node, the difference of its height of left node 
			and the height of right node should be less than equal to 1.
		1.2 balance BT node = Absolute((height(left)-height(right))) <= 1
			1.2.1 absolute = we don't care which height is bigger or smaller, 
					we just need to check the difference should be less than equal to -1.
*/

package Easy;

public class BalancedBinaryTree {

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
 


//  To solve this we need to know to identify the height of the Binary tree
class SolutionBalancedBinaryTree {
    private int getHeight(TreeNode root) {
        // if no noode return 0
        if (root == null) return 0;

        // get left node height
        int leftHeight = getHeight(root.left);
        // if any of the left node height is -1 then return -1
        if (leftHeight == -1) return -1;
        // get right node height
        int rightHeight = getHeight(root.right);
        // if any of the right node height is -1 then return -1
        if (rightHeight == -1) return -1;
        // formula to identify the node is balanced binary tree(height-balanced tree) or not
        // Math.abs(leftHeight-rightHeight) <= 1
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            // balanced binary tree then retun height
            // formula for identifying height
            return (1 + Math.max(leftHeight, rightHeight));
        } else {
            // else return -1
            return -1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // if its balanced binary tree then it will return height of the tree else it will return -1
        return getHeight(root) != -1;
    }
}
