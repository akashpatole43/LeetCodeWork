/*
 * Issue: https://leetcode.com/problems/next-greater-element-i/
solution: https://leetcode.com/problems/next-greater-element-i/solutions/7275334/monotonic-stack-magic-on-m-solution-by-u-k0sz/?envType=problem-list-v2&envId=eeudwo2i
youtube: https://www.youtube.com/watch?v=e7XQLtOQM3I

Description:
	The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

	You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

	For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. 
	If there is no next greater element, then the answer for this query is -1.

	Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
	
Explaination:
	1. see youtube for NGE understanding
	2. used solution link
	3. bruth Approach - use nested loops(tow loops) to compare and get answer TC = o(n2)
	4. best approach using (Stack and hashmap)
		4.1. follow the steps
		4.2. TC = O(n+m) and SC=O(n)
		
*/		
	
package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionNextGreaterElement obj = new SolutionNextGreaterElement();
		int[] arr1 = {4, 1, 2};
		int[] arr2 = {1, 3, 4, 2};
		System.out.println(Arrays.toString(obj.nextGreaterElement(arr1, arr2)));
		
		int[] arr3 = {2, 4};
		int[] arr4 = {1, 2, 3, 4};
		System.out.println(Arrays.toString(obj.nextGreaterElement(arr3, arr4)));
	}

}

class SolutionNextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // create a stack to get greater element
        Stack<Integer> s = new Stack<>();
        // create hashmap to store map of element and its NGE
        Map<Integer, Integer> m = new HashMap<>();

        // Step1 iterate in nums2 and fill the map
        for (int num : nums2) {
            // if stack in not empty and current ele is greater than the top of stack
            while (!s.isEmpty() && num > s.peek()) {
                // 1. pop from stack 2. push in map with (top,currentEle) i.e. map(ele, its NGE)
                m.put(s.pop(), num);
            }
            // now to push the current ele in stack
            s.push(num);
        }

        // Step2 check nums1 ele's in map and get its NGE
        for (int i = 0 ; i < nums1.length ; i++) {
            // replace the nums1 elements with their NGE and if their is no NGE then set -1
            nums1[i] = m.getOrDefault(nums1[i], -1);
        }

        // return the nums1 as now it has its NGE array
        return nums1;
    }
}
