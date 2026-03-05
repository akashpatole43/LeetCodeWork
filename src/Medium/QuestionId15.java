package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 3Sum
// youtube = https://www.youtube.com/watch?v=DhFh8Kw7ymk
public class QuestionId15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQuestionId15 id = new SolutionQuestionId15();
		System.out.println(id.threeSum(new int[] {-1,0,1,2,-1,-4}));
		
		SolutionQuestionId15Brut idB = new SolutionQuestionId15Brut();
		System.out.println(idB.threeSum(new int[] {-1,0,1,2,-1,-4}));

	}

}


//brith solution mera wala 3 loop laga ke
class SolutionQuestionId15Brut {
 public List<List<Integer>> threeSum(int[] nums) {
     if (nums.length < 3) return Collections.emptyList();

     // List<List<Integer>> tripletsList = new ArrayList<>();
     Set<List<Integer>> ans = new HashSet<>();  //  use set tu store only unique triplets

     // Step 1: sort array
     Arrays.sort(nums);

     // Step 2: iterate for i
     for (int i = 0 ; i < nums.length ; i++) {
         // Step 3: iterate for j
         for (int j = i+1 ; j < nums.length ; j++) { // j always be i+1 at start
             // Step 4: iterate for k
             for (int k = j+1 ; k < nums.length ; k++) { // k always be j+1 at start
                 if (0 == nums[i] + nums[j] + nums[k]) {
                     // ans.add(List.of(nums[i], nums[j], nums[k])); // java 9+
                     ans.add(Arrays.asList(nums[i], nums[j], nums[k])); // java 8
                 }
             }
         }
     }
     return new ArrayList<>(ans);
 }
}


//better solution using pointers
class SolutionQuestionId15 {
 public List<List<Integer>> threeSum(int[] nums) {
     if (nums.length < 3) return Collections.emptyList();

     List<List<Integer>> tripletsList = new ArrayList<>();

     // Step 1: sort array
     Arrays.sort(nums);

     // Step 2: itrate in loop for i
     for (int i = 0 ; i < nums.length ; i++) {
         if (i > 0 && nums[i] == nums[i-1]) continue;    // to itrate i on next new value
         
         // Step 3: set j and k
         int j = i+1;
         int k = nums.length-1;

         // Step 4: iterate j and k till j is greater than equal to k
         while (j < k) {
             // get the sum og triplets and check for 0
             int sum = nums[i] + nums[j] + nums[k];
             if (sum < 0) {  // sum less than 0 then move j forward to increase sum value
                 j++;
             } else if(sum > 0) {    // sum greater than 0 then move k backward to decrease sum value
                 k--;
             } else {    // else sum = 0 then note the triplets
                 List<Integer> triplet = new ArrayList<>();
                 triplet.add(nums[i]);
                 triplet.add(nums[j]);
                 triplet.add(nums[k]);   // get triplet
                 tripletsList.add(triplet);      // add in final ans list

                 // move j and k index
                 j++;
                 k--;
                 // move forward until j does not cross k and j get new value
                 while (j < k && nums[j] == nums[j-1]) j++;
                 // move backward untill j does not cross k and k get new value
                 while (j < k && nums[k] == nums[k+1]) k--;
             }
         }
     }
     return tripletsList;
 }
}