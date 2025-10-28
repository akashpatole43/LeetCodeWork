/*
 * Description:
	Given the root of a binary tree, check whether it is a mirror of itself 
	(i.e., symmetric around its center).
	
	
Explaination:
	1. before solving this issue solve the SameTree issue.
	2. We will use any DFt way to traverse tree then compare the value 
	3. below we will use InOrder traversal way.
*/	


package Easy;

public class SymmetricTree {

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
 
class SolutionSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return isSymmetric(p.left, q.right) && (p.val == q.val) && isSymmetric(p.right, q.left);
    }
}
