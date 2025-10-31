/*
 * Issue: https://leetcode.com/problems/middle-of-the-linked-list/description/?envType=problem-list-v2&envId=eeudwo2i
youtube:https://www.youtube.com/watch?v=sGdwSH8RK-o&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=29
	
Description:
	Given the head of a singly linked list, return the middle node of the linked list.

			If there are two middle nodes, return the second middle node.
					
					
Explaination:
	1. Use two pointers (slow and fast)
	2. TC = O(n/2) and SC = O(1)
	
	*/



package Easy;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class SolutionMiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // use two pointer to get middle 
        ListNode slow = head;
        ListNode fast = head;

        // with this loop slow point will end up on the middle of the linkedlist
        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // next to move the slow point on its next node to return next nodes list
        if (fast.next == null) { // for old length return from the middle nodes
            return slow;
        } else { // for even length return second half on linked list
             return slow.next; 
        }
    }
}