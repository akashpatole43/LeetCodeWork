package Easy;

// Merge two sorted linked list
public class MergeTwoSortedList {
	// Method to create a linked list from an array
	public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionMergeTwoSortedList obj = new SolutionMergeTwoSortedList();
		int[] arr1 = {1, 2, 4};
		ListNode l1 = createLinkedList(arr1);
		int[] arr2 = {1, 3, 4};
		ListNode l2 = createLinkedList(arr2);
		int[] ansArr = {1, 1, 2, 3, 4, 4};
		ListNode ansNode = createLinkedList(ansArr);
		ListNode resultNode = obj.mergeTwoLists(l1, l2);
		System.out.println(resultNode.hasSameValue(ansNode));
	}

}

class ListNode {
	int val;
	ListNode next;
	
	ListNode () {};
	ListNode (int val) {	this.val = val; }
	ListNode (int val, ListNode next) {	this.val = val; this.next = next; }
	
	// Method to compare the values of two ListNodes
    public boolean hasSameValue(ListNode otherNode) {
        if (otherNode == null) {
            return false; // A null node cannot have the same value
        }
        return this.val == otherNode.val;
    }
}

class SolutionMergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
//      to make list1 has the smallest value
        if (list1.val > list2.val) {
            ListNode temp1 = list1;
            list1 = list2;
            list2 = temp1;
        }
        // point res to list1 for the final answer
        ListNode res = list1;

        while (list1 != null && list2 != null) {
            ListNode temp2 = null;
            // iterate in list1 until the list1 have the smallest values
            while (list1 != null && list1.val <= list2.val) {
                temp2 = list1;
                list1 = list1.next;
            }
            // point temp2 to first node of list2
            temp2.next = list2;
            // swap list1 with list2
            ListNode temp3 = list1;
            list1 = list2;
            list2 = temp3;
        }
        return res;       
    }
}
