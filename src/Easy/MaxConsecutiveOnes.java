/*
 * issue : https://leetcode.com/problems/max-consecutive-ones/description/?envType=problem-list-v2&envId=eeudwo2i
youtube : https://www.youtube.com/watch?v=bYWLJb3vCWY&t=1124s

Description:
	Given a binary array nums, return the maximum number of consecutive 1's in the array.
			
Explaination:
	1. use two variables to get answer
	2. TC = O(n)

	*/
package Easy;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionMaxConsecutiveOnes obj = new SolutionMaxConsecutiveOnes();
		int[] arr = {1,1,0,1,1,1};
		System.out.println(obj.findMaxConsecutiveOnes(arr));
		
		int[] aa = {1,0,1,1,0,1};
		System.out.println(obj.findMaxConsecutiveOnes(aa));
	}

}

class SolutionMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0; // for counting value
        int maxCount = 0; // for get maxc count

        // iterate in array
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 1) { // if 1 is present 
                count++;   // add c1 in count
                maxCount = Math.max(maxCount, count); // get the max count value
            } else {
                count = 0; // if no 1 then set count to 0
            }
        }
        return maxCount; // returm amx count value
    }
}
