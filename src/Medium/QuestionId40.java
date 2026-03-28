package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* This question answer is almost similar to question39
 * We just need to 
 * 1. Sort the input and use Set to collect unique combinations
 * 2. when we pick the index the move to index+1 
 * 3. convert the Set to list as before returning the ans 
 */

/* 
 * Title = 40. Combination Sum II
 * 
 * Question = Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * 
 * youtube = for more optimized answer
 * https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51
 */
public class QuestionId40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SolutionQuestionId40 {
    private void  combinationSum2Helper(
        int index, 
        int[] candidates, 
        int target, 
        Set<List<Integer>> res, 
        List<Integer> temp) {
        // Step 4:
        // check the index and the candidate length
        if (index == candidates.length) {
            // check the target is achieved, if yes then add the temp into res
            if (target == 0) res.add(new ArrayList<>(temp));
            return;
        }

        // Step 5:
        // check the target is greater than equal to the index candidate
        if (candidates[index] <= target) {
            // pick the index and move further 
            temp.add(candidates[index]);
            // Step 6:
            // recurcive call with index + 1 and target - candidates[index]
            combinationSum2Helper(index + 1, candidates, target - candidates[index], res, temp);
            // Step 7:
            // remove the last element from temp as it does not match
            temp.remove(temp.size() - 1);
        } 
        // Step 8:
        // case when the we dont pick the index so do index + 1
        combinationSum2Helper(index + 1, candidates, target, res, temp);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Step 1:
        // sort the candidates
        Arrays.sort(candidates);
        // Step 2: 
        // get Set to have unique combinations
        Set<List<Integer>> res = new HashSet<>();
        // Step 3: 
        // call the helper method to set the res
        combinationSum2Helper(0, candidates, target, res, new ArrayList<>());
        // return the res in List and not in Set
            // java 10+ conversation suppoerted
            // return List.copyOf(res);
        // java 8 conversation
        return res.stream().collect(Collectors.toList());
    }
}
