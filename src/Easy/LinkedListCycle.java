/*
 * Description:
	Given head, the head of a linked list, determine if the linked list has a cycle in it.

	There is a cycle in a linked list if there is some node in the list that 
	can be reached again by continuously following the next pointer. Internally, 
	pos is used to denote the index of the node that tail's next pointer is connected to. 
	Note that pos is not passed as a parameter.

	Return true if there is a cycle in the linked list. Otherwise, return false.

Explaination:
	1. to solve this we have two appraches
		1.1 with using Hashtable
			1.1.1 add node one by one into hashtable, then while adding if we see,
				this node already exists in the hashtable the we can say is a cycle(circular linked list)
			1.1.2 here the timeComplexcity = O(n) 
			1.1.3 SpaceComplexicity = O(n)
		1.2 with using two pointer
			1.2.1 slowpoint -> move by one node and fastpoint -> move by two nodes
			1.2.2 at start both pointers will be on head(first node).
			1.2.3 if its a cycle then in future at some point, 
					those two pointers will come again on the same node.
			1.2.4 if any of those pointer come to the end of node the its not a cycle.
			1.2.5 TC = O(n) and SC = O(1)
	2. best approach will be second wala.
*/

package Easy;

public class LinkedListCycle {

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
 
class SolutionLinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // if head is null or the next node head is null then its not a cycle
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        // iterate based on fastnode
        while (fastNode.next != null && fastNode.next.next != null) {
            // slownode move forward by one node
            slowNode = slowNode.next;
            // fastnode move forward by two nodes
            fastNode = fastNode.next.next;
            // if at any point slow and fast nodes are at the same node then its circular linked list
            if (slowNode == fastNode) return true;
        }
        return false;
    }
}
