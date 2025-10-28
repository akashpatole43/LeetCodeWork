/*
 * DEscription:
	Given an integer array nums where the elements are sorted in ascending order, 
	convert it to a height-balanced binary search tree.
	

Exaplaination:
	1. Binary tree = 
		1.1 one parent and two child.
		1.2 left child < parent <= right child
		1.3 left child <= parent < right child
		1.4 we can use anyone way from 1.2 and 1.3
	2. To solve this we need to identify the root node i.e mid of array.
	3. So formula = mid = (end-start)/2
	4. we will resolve this based on this formula.
*/	


package Easy;

public class ConvertSortedArrayToBinarySearchTree {

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
 
class SolutionConvertSortedArrayToBinarySearchTree {
    // this way will work only on sorted array, so we will not check the values of node here.
    private TreeNode helper(int[] nums, int start, int end) {
        // invalid range
        if (start > end) return null;
        // main formula to get mid/root node
        int mid = start + (end - start)/2;
        // create root node
        TreeNode root = new TreeNode(nums[mid]);
        // create left child of root node
        root.left = helper(nums, start, mid-1);
        // create right child of root node
        root.right = helper(nums, mid+1, end);
        
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}
