/*
 * issue: https://leetcode.com/problems/set-mismatch/description/?envType=problem-list-v2&envId=eeudwo2i
youtube = ye mera solution h

Description:
	You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, 
	due to some error, one of the numbers in s got duplicated to another number in the set, 
	which results in repetition of one number and loss of another number.

	You are given an integer array nums representing the data status of this set after the error.

	Find the number that occurs twice and the number that is missing and return them in the form of an array.
			
Explaination:
	1. bruth Approach 1 (nexted loop to identify the duplicate ele then one loop to identify missing ele), TC = o(n2 + n) and SC = o(1)
	2. best approach2 using boolean array to get duplicate and missing ele
	3. in boolean array the default values are false;

*/


package Easy;

import java.util.Arrays;

public class SetMismatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionSetMismatch obj = new SolutionSetMismatch();
		int[] arr1 = {1, 2, 2, 4};
		System.out.println(Arrays.toString(obj.findErrorNums(arr1)));
		int[] arr2 = {1,1};
		System.out.println(Arrays.toString(obj.findErrorNums(arr2)));
	}

}

class SolutionSetMismatch {
    public int[] findErrorNums(int[] nums) {
        // result aarray of size 2 (doubled ele, replaced ele)
        int[] res = new int[2];
        // boolean array with the size of nums to set the present ele
        boolean[] bol = new boolean[nums.length];
        // iterate in nums to nums and set boolean are to true if ele present
        for (int num : nums) {
            if (bol[num-1] == false) { // counting for first time
                bol[num-1] = true;
            } else { // ele was present i.e doplicate ele
                res[0] = num; // set duplicate in index 0
            }
        }
        // now in bol there will one index for which we have false i.e missing ele
        for (int i = 0 ; i < bol.length ; i++) {
            if (bol[i] == false) {
                res[1] = i+1; // set missing on index 1
                break;
            }
        } 
        // retunrn the result array
        return res;
    }
}
