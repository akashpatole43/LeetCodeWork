package Medium;

import java.util.ArrayList;
import java.util.List;

/*
Title = 39. Combination Sum

Question = Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique 
if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Youtube = https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50
*/	
	
public class QuestionId39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class SolutionQuestionId39 {
 private void combinationSumHelper(
     int index, 
     int[] candidates, 
     int target, 
     List<List<Integer>> res, 
     List<Integer> temp) {
         // Step 3:
         // check the index with the array size and the target reach to 0 then return
         if (index == candidates.length) {
             if (target == 0) { // if target reaches to 0 then save temp in result list
                 res.add(new ArrayList<>(temp)); // initailize memory for temp
             }
             return;
         }

         // Step 4:
         // check if the candidate index value is less than equals to target value 
         if (candidates[index] <= target) {
             // pick the index value and add in temp
             temp.add(candidates[index]);
             // Step 5:
             // call recursive fun and travel to left side i.e. target-candidates[index]
             combinationSumHelper(index, candidates, target - candidates[index], res, temp);

             // Step 6:
             // on completing all left travelsing remove the last index value
             temp.remove(temp.size() - 1);
         }

         // Step 7:
         // call recursive fun and travel to right side i.e increase index by 1
         // this is for not pick case
         combinationSumHelper(index + 1, candidates, target, res, temp);

 }
 
 public List<List<Integer>> combinationSum(int[] candidates, int target) {
     // Step 1:
     // create result list
     List<List<Integer>> res = new ArrayList<>();
     // Step 2:
     // call recursive function
     combinationSumHelper(0, candidates, target, res, new ArrayList<>());
     // retunr the final result
     return res;
 }
}
