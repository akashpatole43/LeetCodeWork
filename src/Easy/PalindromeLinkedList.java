/*
 * issue : https://leetcode.com/problems/palindrome-linked-list/submissions/1816109579/?envType=problem-list-v2&envId=eeudwo2i
youtube: https://www.youtube.com/watch?v=-DtNInqFUXs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=37
	
Description:
	Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
			
Explaination:
	1. approach 1 - use another array/list, iterate kar list me as vo array me add karna, fhir second time fhirse iterate karna list me aur compare karna array(length se 0 tak) ke sat
	2. approach 2 - (compare half linkedlist with second half reversed linkedlist)
		2.1 see the steps bellow
		2.2 TC = O(n/2 + n/2 + n/2)

*/

package Easy;

public class PalindromeLinkedList {

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
 
class SolutionPalindromeLinkedList {

    private ListNode reverseLinkedList(ListNode hNode) {
        // result node
        ListNode result = null;
        // iterate in hNode
        while (hNode != null) {
            // temp node to swap
            ListNode temp = hNode.next;
            // update head.next
            hNode.next = result;
            // update result
            result = hNode;
            // update head
            hNode = temp;
        }
        // retunr reversed linkedlist
        return result;
    }

    public boolean isPalindrome(ListNode head) {
        // check head or head .next is null or not
        if (head == null || head == null) return true;

        // Step1 identify the half of linkedlist
        // use two pointers
        ListNode slow = head; // this will move one node
        ListNode fast = head; // this will move two node
        // iterate in head till the fast.next or fast.next.next is null
        while (fast.next != null && fast.next.next != null) { // when we reach to this conditon thatmeans slow point is on middle of linkedlist // here TC = O(n/2) as we are iterating half list
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step2 reverse the next half of linkedlist
        // slow point is on middle of linkedlist, now reverse the next half of the linked list
        slow.next = reverseLinkedList(slow.next); // here TC = O(n/2) as we are iterating half list

        // step3 move slow pointer on second half start
        slow = slow.next;

        // Step4 iterate in head to compare the first half and the reversed next half on linked list
        // now slow pointer is on the start of next half, so condition will be on him
        while (slow != null) { // here TC = O(n/2) as we are iterating half list
            // compare first half with second half
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        // if first and second half are equal then return true
        return true;
    }
}
