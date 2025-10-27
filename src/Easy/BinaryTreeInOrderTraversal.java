package Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInOrderTraversal obj = new BinaryTreeInOrderTraversal();
//		need to right code for it

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
 
class SolutionBinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        inOrder(root, outputList);
        return outputList;
    }

    private void inOrder(TreeNode root, List<Integer> outputList) {
        if (root == null) return;
        inOrder(root.left, outputList);
        outputList.add(root.val);
        inOrder(root.right, outputList);
    }
}