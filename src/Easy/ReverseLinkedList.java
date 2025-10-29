/*
 * issue : https://leetcode.com/problems/reverse-linked-list/description/
	
Description:
	Given the head of a singly linked list, reverse the list, and return the reversed list.
			
			
Explaination:
	1. we will create a resultNode and will iterating in the given node we will add those node into resultnode.
	2. TC = O(n) and SC = O(1)
	3. eg,
		given node = 1 -> 2 -> 3 -> null
		result node = null <- 1 <- 2 <- 3 so this is sam as 3->2->1->null
*/

package Easy;

public class ReverseLinkedList {

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
 
class SolutionReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // check for null head
        if (head == null) return null;
        // create resultnode
        ListNode resultNode = null;

        // iterate till the head node come to end
        while (head != null) {
            // temp node
            ListNode temp = head.next;
            // sepearated head node
            head.next = resultNode;
            // update the result node
            resultNode = head;
            // update the head
            head = temp;
        }
        return resultNode;
    }
}
