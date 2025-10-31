/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.*/
package Easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 9;
		int[] arr = new int[] {2,7,11,15};
		int[] expected = new int[] {0,1};
		int actual[] = twoSum(arr, target);
		boolean flag = true;
		for(int j=0 ; j<actual.length ; j++) {
			if(!(actual[j] == expected[j])) {
				flag = false;
				break;
			}
		}
		if (flag)
			System.err.println("Passed");
		else
			System.out.println("Failed");

	}
}

	
	
	// my approach bruth sol TC = o(n2) and sc= O(1)
	// class Solution {
//	     public int[] twoSum(int[] nums, int target) {
//	         int[] result = new int[2];
//	         for(int j = 0; j < nums.length; j++) {
//	             for(int i = j+1; i < nums.length; i++) {
//	                 if(nums[j] + nums[i] == target) {
//	                     result[0] = j;
//	                     result[1] = i;
//	                     return result;
//	                 }

//	             }
//	         }
//	         return null;
//	     }
	// }

	// not using this bcoz we need index value and not the element value, to get index value we will need to a map to store ele, index relation
	// best approach use two pointers (left , right) TC = o(n) and sc = o(1)
	// class Solution {
//	     public int[] twoSum(int[] nums, int target) {
//	         // Step 1 create two pointers
//	         int left = 0; // iterate from left to right
//	         int right = nums.length-1; // iterate from right to left

//	         //  Step 2 sort array
//	         Arrays.sort(nums);

//	         // Step 3 iterate pointers in loop
//	         while (left < right) {
//	             if (nums[left] + nums[right] == target) return new int[] {nums[left], nums[right]};
//	             else if (nums[left] + nums[right] > target) right--;
//	             else left++;
//	         }
//	         // no elements whos sum is target
//	         return null;
//	     }
	// }

	// best approach using map  TC = O(n) and SC = O(n)
	class SolutionTwoSums {
	    public int[] twoSum(int[] nums, int target) {
	        // create map to store ele and index relationship
	        Map<Integer, Integer> m = new HashMap<>();
	        // iterate in loop to check the target store value in map
	        for (int i = 0 ; i < nums.length ; i++) {
	            // check in map for target ele
	            if (m.containsKey(target-nums[i])) {
	                // if contain return indexs of ele's
	                return new int[] {m.get(target-nums[i]), i};
	            } else {
	                //  add in map with it's index
	                m.put(nums[i], i);
	            }
	        }
	        // if no sum ele's then return null;
	        return null;
	    }
	}
	

}
