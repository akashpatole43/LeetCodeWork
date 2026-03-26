package Medium;

/*
Title = 19. Remove Nth Node From End of List

Question =
Given the head of a linked list, remove the nth node from the end of the list and return its head.
	
Youtube = https://www.youtube.com/watch?v=3kMKYQ2wNIU
	
*/
		
public class QuestionId19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for singly-linked list. 
 */
 class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


/*
Solution 1: Brutforce -> mene ye sochta tha
Step1 -> create index varible i to note the node side and travel from the head to end of listnode.
Step2 -> calcualte the index of node which next node we want to remove i.e i-n = res
Step3 -> if res is 0 meaning nodesize is equal to n, so return head.next as output.
Step4 -> travel to res index in node
Step5 -> now we point res index node to res.next.next node i.e. temp1.next = temp1.next.next;
Step6 -> return the headnode
*/

/* Solution 2
using two pointer,
create a gap of n between the pointer and then travel them 1 by 1 tille one pointer reaches end of list
theerfore the second pointer will reaches to node whihc wee want to remove
*/

class SolutionQuestionId19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Step 1: 
        // get two pointers
        ListNode fast = head, slow = head;

        // Step 2:
        // fast pointer will first travel n times, to create gap of n between slow pointer
        for (int i = 0 ; i < n ; i++) fast = fast.next;

        // Step 3:
        // check if the fast pointer is at null position, meaning we have to return head.next
        if (fast == null) return head.next; // here the n is equal to size of node

        // Step 4:
        // now we have the gap between slow & fast so now travel then one by one till fast.next = null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 5:
        // Now fast.next=null therefore slow is on the position of n from the end of list
        // Now pointer the slow.next to slow.next.next to remove the n node
        slow.next = slow.next.next;

        // Step 6:
        return head; // return the head
    }
}
