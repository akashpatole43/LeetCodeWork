/*
 * issue : https://leetcode.com/problems/implement-queue-using-stacks/?envType=problem-list-v2&envId=eeudwo2i
youtube: https://www.youtube.com/watch?v=tqQ5fTamIN4
	
Description:
	Implement a first in first out (FIFO) queue using only two stacks. 
	The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

	Implement the MyQueue class:

	void push(int x) Pushes element x to the back of the queue.
	int pop() Removes the element from the front of the queue and returns it.
	int peek() Returns the element at the front of the queue.
	boolean empty() Returns true if the queue is empty, false otherwise.
	Notes:

	You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
	Depending on your language, the stack may not be supported natively. 
	You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
	
Explaination:
	1. this is little same as implement stack using queue
	2. we have two approaches.(in both we will need 2 stacks)
		2.1. the as stack using queue (focus on push operation)
				2.1.1. s1 stack me add karte time exsiting value s2 me move karna aur s1 me new value add karna aur fhir s2 ke sare values s1 me move karna
				2.1.2. eg, -> s1-{1}, s2-{} move to s2, ie. s1-{}, s2-{1} then add new in s1 s1-{2}, s2-{1}, then move s2 to s1, s1-{2,1}, s2-{}
				2.1.3. peek ya pop wle operation s1 per karna aur empty ke liye donon check karna
				2.1.4. TC = O(2n) for push op and SC= O(2) bcoz two stack
				2.1.5. this is expensive if there are many push operations.
		2.2. Optimize push operation (focus on peek and pop operation)
			2.2.1. hamesha directly s1 me add karna.
			2.2.2. top/peek ya pop operation ke time, 
				1. pehele check karna s2 me kuch h ky, ager honga toh s2 se return karna (pop/peek)
				2. but ager s2 me kuch nhi h toh saare values s1 se s2 me move karna
				3. aur fhir pop/peek operation s2 se return karna.
			2.2.3. TC = O(n) for pop/peek operation aur O(1) for push/empty operation and SC= O(n)
			
*/



package Easy;

import java.util.Stack;

public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//for queue we will focus on top an pop operations
class MyQueue {
 // will need two stack to manage
 private Stack<Integer> s1; // this will be our main stack
 private Stack<Integer> s2;

 public MyQueue() {
     this.s1 = new Stack<>();
     this.s2 = new Stack<>();
 }
 
 public void push(int x) {
     // add in main stack
     s1.push(x);
 }
 
 public int pop() { 
     // first check in s2, if there are values then pop from it
     if (!s2.isEmpty()) {
         return s2.pop();
     } else {
         // add all values from s1 to s2 and then remove the top from s2
         while (!s1.isEmpty()) {
             s2.push(s1.pop());
         }
         return s2.pop();
         
     }
 }
 
 public int peek() { // same as top
     // first check in s2, if there are values then return the top
     if (!s2.isEmpty()) {
         return s2.peek();
     } else {
         // add all values from s1 to s2 and then return the top from s2
         while (!s1.isEmpty()) {
             s2.push(s1.pop());
         }
         return s2.peek();
     }
 }
 
 public boolean empty() {
     // check in both the stacks
     return (s1.isEmpty() && s2.isEmpty());
 }
}

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/