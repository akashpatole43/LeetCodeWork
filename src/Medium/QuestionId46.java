package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



/*
 * Title = 46. Permutations
 * 
 * Question = Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * 
 * //youtube = https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=53
 */
public class QuestionId46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SolutionQuestionId46 {

	 private void swap(int i, int j, int[] nums) {
	     int t = nums[i];
	     nums[i] = nums[j];
	     nums[j] = t;
	 }
	
	 private void permuteHelper(int index, int[] nums, List<List<Integer>> res) {
	     // Step 3: get the base case of recurssion func
	     if (index == nums.length) {
	         // create the temp and add all the elements in sequence
	             // List<Integer> temp = new ArrayList<>();
	             // for (int i = 0 ; i < nums.length ; i ++) {
	             //     temp.add(nums.[i]);
	             // }
	         List<Integer> temp = Arrays.stream(nums).boxed()
	             .collect(Collectors.toList());
	         // add temp into final res
	         res.add(new ArrayList<>(temp));
	     }
	
	     // Step 4:
	     // travel from index to num length to make combinations
	     for (int i = index; i < nums.length; i++) {
	         // Step 5:
	         // swap i with index
	         swap(i, index, nums);
	         // Step 6:
	         // call recursive method with index + 1
	         permuteHelper(index + 1, nums, res);
	         // Step 7:
	         // reswap when we come back from the recurssion
	         swap(i, index, nums);
	     }
	 }
	
	 public List<List<Integer>> permute(int[] nums) {
	
	     // Step 1: 
	     // get the result list
	     List<List<Integer>> res = new ArrayList()<>();
	     // Step 2:
	     // call the recurvise fun and start with index 0
	     permuteHelper(0, nums, res);
	     // return the final ans
	     return res;
	     
	 }
}