package Medium;

/*
 * Title = 61. Rotate List
 * 
 * Question = Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Yutube = https://www.youtube.com/watch?v=uT7YI7XbTY8
 */
public class QuestionId61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class SolutionQuestionId61 {
    private ListNode getNodeByIndex(ListNode temp, int index) {
        int count = 1;
        while (temp != null) { // travel till last node
            if (count == index) return temp;
            ++count;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {
        // Step 1: get the edge cases
        if (head == null || k == 0) return head;

        // Step 2: get the length and last node
        int len = 1;
        ListNode lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            ++len;
        } 

        // Step 3:
        // if length and k mode equals to 0 then no need to rotate 
        if (k % len == 0) return head; 
        // Step 4:
        // update the new k value k%len
        k = k % len;

        // Step 5:
        // point lastnode next to head
        lastNode.next = head;

        // Step 6:
        // get the lenght-k node as it will be out new lastNode
        ListNode newLastNode = getNodeByIndex(head, len-k);

        // Step 7:
        // set new head and newlastNode
        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }
}
