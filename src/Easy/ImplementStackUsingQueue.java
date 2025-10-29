/*
 * issue : https://leetcode.com/problems/implement-stack-using-queues/description/?envType=problem-list-v2&envId=eeudwo2i
	
Description:
	Implement a last-in-first-out (LIFO) stack using only two queues. 
	The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

	Implement the MyStack class:

	void push(int x) Pushes element x to the top of the stack.
	int pop() Removes the element on the top of the stack and returns it.
	int top() Returns the element on the top of the stack.
	boolean empty() Returns true if the stack is empty, false otherwise.
	Notes:

	You must use only standard operations of a queue, which means that only push to back, peek/pop from front, 
	size and is empty operations are valid.
	Depending on your language, the queue may not be supported natively. 
	You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
	
	
Explaination:
	1. Stack = LIFO and Qeueu = FIFO
	2. In both we remove the top value, but in stack the top = the last added value and in qeueu the top = the first added value.
	3. So while adding in queue we have to add new value and move its earlier value one by one and add in the queue again one by one.
	4. eg,
		4.1 queue = {1, 2, 3} here the top = 1, so as per queue 1 will get removed but as per stack the top should be 3 and 3 should get removed
		4.2 So while adding 3 in queue we will move its earlie value to back of 3 ie.
		{1, 2} -> push 3 -> {1,2,3} -> {2,3,1} -> {3,1,2} now the top is 3 as per queue and logically top = 3 as per stack
		
*/




package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyStack {
    // class obj
    private Queue<Integer> q;
    
    public MyStack() {
        // on MyStack obj creation we will initailize memory to queue obj
        this.q = new LinkedList<>();
    }
    
    // this operation will take TC = O(n)
    public void push(int x) {
        // get current size of queue
        int size = q.size();
        // add new value in queue
        q.offer(x); // offer(E e): Inserts the specified element into the queue if possible. Returns true on success, false if the element cannot be added (e.g., if the queue is capacity-restricted). 

        // iterate in queue and move all exisiting value back of the new value
        for (int i = 0 ; i < size ; i++) {
            // remove top value from queue and add that in the queue
            q.add(q.poll()); // Retrieves and removes the head of the queue. Returns null if the queue is empty.
        }
    }
    
    // this operation will take TC = O(1)
    public int pop() {
        // remove the top
        return q.poll();
    }
    
    // this operation will take TC = O(1)
    public int top() {
        // return the top
        return q.peek(); //peek(): Retrieves, but does not remove, the head of the queue. Returns null if the queue is empty.
    }
    
    // this operation will take TC = O(1)
    public boolean empty() {
        // check queue is empty or not
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */