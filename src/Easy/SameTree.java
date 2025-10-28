/*
 * Description:
	Given the roots of two binary trees p and q, 
	write a function to check if they are the same or not.

	Two binary trees are considered the same if they are structurally identical, 
	and the nodes have the same value.
	
Explaination:
	1. We will use any DFt way to traverse tree then compare the value 
	2. below we will use InOrder traversal
	*/

package Easy;

public class SameTree {

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
 
class SolutionSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        // We will check with InOrder Tree Traversal DFT (left, root, right)
        return isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right);
    }
}
