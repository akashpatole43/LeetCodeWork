/*
 * issue: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
youtube : http://youtube.com/watch?v=0tFmP1Eiilg

Description:
	You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. 
	This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.

	You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and 
	continuously returns the kth highest test score after a new score has been submitted. More specifically, 
	we are looking for the kth highest score in the sorted list of all scores.

	Implement the KthLargest class:

	KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
	int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element 
	in the pool of test scores so far.

	
Explaination:
	1. We will use minHeap concept here, in java minHeap and maxHeap is managed by PriorityQueue 
	2. By default PriorityQueue works as minHeap.
	3, priorityqueue(minHeap) = elements are automatically arrenged in accesnding order and top = minimum value of the priorityqueue
	4. priorityqueue(maxHeap) = elements are automatically arrenged in desccending order and top = maximum value of the priorityqueue
	5. TC = O(n) and SC = O(k)

*/
package Easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class KthLargest {
    // use min heap to store k size values
    private PriorityQueue<Integer> minHeap;
    // use kth variable
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        // initailize k size to PriorityQueue
        this.minHeap = new PriorityQueue<>(kth);
        // now add array values in priorityqueue
        for (int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // check priorityqueue top
        // since it is minheap so top will be the min value in priorityqueue
        if (minHeap.size() < kth) { // add into priorityqueue
            minHeap.offer(val);
        } else if (minHeap.peek() < val) { // priorityqueue top is smaller than val
            minHeap.poll(); // remove the top(smallest value from priorityqueue)
            minHeap.offer(val); // add new val
        }
        //  now return the top i.e kth largest element
        return minHeap.peek();
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
