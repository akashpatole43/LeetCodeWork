/*
 * issue: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Youtube:
	video1 = https://www.youtube.com/watch?v=UXDSeD9mN-k
	video2 = https://www.youtube.com/watch?v=D2jMcmxU4bs
	video3 = https://www.youtube.com/watch?v=ssL3sHwPeb4
	
	
Description:
	Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, 
			or false otherwise.

Explaination:
	1. for this you should know twosum issue using left and right pointers. see video1, then also you should know BST next and before iterator video2
	2. Approach two pointers using BST iterator(left, right)
	3. TC = O(n) and SC = O(2(height)) bcoz two stack with the BST height length
	
*/			


package Easy;

import java.util.Stack;

public class TwoSumInputIsABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//  create class from BST iteration
class BSTIteration {
    // create stack to store tree value in a order
    private Stack<TreeNode> s;
    // boolean to store accesending/left(true) or decending/right(false) order
    private boolean order = true; // default we are store accsending

    BSTIteration(TreeNode root, boolean order) {
        this.s = new Stack<>();
        this.order = order;
        // push values in stack
        pushAll(root);
    }

    private void pushAll(TreeNode root) {
        // store in stack till the node get to the order end
        while (root != null) {
            s.push(root); // add node in stack
            // based on order add left or right nodes
            if (order) {
                root = root.left; // get left
            } else {
                root = root.right; //get right
            }
        }
    }

    public int next() {
        //  get stack top
        TreeNode lastStackTop = s.pop();
        // add nodes in stack based on order
        if (order) {
            pushAll(lastStackTop.right); // add all right nodes since we already covered left
        } else {
            pushAll(lastStackTop.left); // add all left nodes since we already covered right
        }
        // return laststacktop value
        return lastStackTop.val;
    }

}
class SolutionBSTIteration {
    public boolean findTarget(TreeNode root, int k) {

        // Step1
        // create left nodes stack(accsending order)
        BSTIteration leftOrderStack = new BSTIteration(root, true); // BST next Iterator
        // create right nodes stack(desending order)
        BSTIteration rightOrderStack = new BSTIteration(root, false); // BST before Iterator

        // Step2 do first next
        int left = leftOrderStack.next();
        int right = rightOrderStack.next();         

        // Step3 loop till the left node value is smaller than right node value
        while (left < right) {
            // check the values with target value
            if (k == left+right) {
                return true; // sum exisits
            } else if (k > left+right) {
                left = leftOrderStack.next(); // increase left pointer
            } else {
                right = rightOrderStack.next(); // decrease right pointer
            }
        }
        // return false if no sum elements present in tree
        return false;
    }
}
