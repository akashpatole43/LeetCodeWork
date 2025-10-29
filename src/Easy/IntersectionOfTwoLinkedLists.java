/*
 * issue: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
	
Description:
	Given the heads of two singly linked-lists headA and headB, 
	return the node at which the two lists intersect. If the two linked lists have 
			no intersection at all, return null.

	For example, the following two linked lists begin to intersect at node c1:


	The test cases are generated such that there are no cycles anywhere in the entire linked structure.

	Note that the linked lists must retain their original structure after the function returns.

	Custom Judge:

	The inputs to the judge are given as follows (your program is not given these inputs):

	intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
	listA - The first linked list.
	listB - The second linked list.
	skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
	skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
	The judge will then create the linked structure based on these inputs and 
	pass the two heads, headA and headB to your program. 
	If you correctly return the intersected node, then your solution will be accepted.
			
			
Explaination:
	1. we should know how to identify Linked List cycle issue.
	2. Bruth approach
		2.1 iterate in one listnode and compare its node with other listnodes one by one.
			2.1.1 TC = O(m*n)
	3. Optimize approach (hashtable)
		3.1 iterate in first listnode and add its node in hashtable, then iterate in second listnode and compare nd store in hashtable.
		3.2 if hashtable dont have the node then store, if it has the node then return it as it will be the intersecting node.
		3.3 TC = O(m+n) and SC = O(m)
	4. best approach (pointer node)
		4.1 use two dummy node (a for firstListnode,b for secondListnode), then move those dummy node by one node in their respective listnode.
		4.2 if any of the listnode get ended then move that dummy node to other listnode's head to iterate in that.
			(a move to secondListnode, b move to firstListnode).
		4.3 both a and b will be the same at some point,
			4.3.1 both will be null if there is not intersecting node.
			4.3.2 both will be the same node if there is a intersecting node.
		4.4 TC = O(m) and SC = O(1)
		
	*/	


package Easy;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 

//  here the logic is little similar to Linked List cycle issue
class SolutionIntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // check if any of the given nodes is null 
        if (headA == null || headB == null) return null;

        // create two pointers to iterate in nodes
        ListNode a = headA; // to iterate in headA
        ListNode b = headB; // to iterate in headB
        // a and b will be same when it will intersect
        while (a != b) {
            // if a covered iteration in headA then point it at other nodes heads
            // So that it will iterate in ohter node
            a = a == null ? headB : a.next;
            // same as above 
            b = b == null ? headA : b.next;
        }
        // return any of these a or b as both are the same
        // either it will be the intersecting node 
        // or it will be null if their is no intersection
        return a;
    }
}
