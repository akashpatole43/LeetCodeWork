/*
 * issue: https://leetcode.com/problems/search-in-a-binary-search-tree/description/?envType=problem-list-v2&envId=eeudwo2i
Youtube: https://www.youtube.com/watch?v=KcNt6v_56cc
	
Description:
	You are given the root of a binary search tree (BST) and an integer val.

	Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
	

Explaination:
	1. TC = O(log2 n) i.e max of the height of tree
	
*/	


package Easy;

public class SearchInABinaryTree {

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
 
class SolutionSearchInABinaryTree {
    public TreeNode searchBST(TreeNode root, int value) {
        // check root in null
        if (root == null) return root;

        // iterate in root till the root is null or till we found the val
        while (root != null && value != root.val) {
            // Binary search tree = (small ele < root < large ele)
            // if ele > val then move to left
            // if ele < val then move to right
            //  else return root i.e val == root
            root = root.val > value ? root.left : root.right;
        }
        // root will be null if there is no matching val else the matching node
        return root;
    }
}


