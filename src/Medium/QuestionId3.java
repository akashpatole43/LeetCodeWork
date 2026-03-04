package Medium;

import java.util.HashMap;
import java.util.Map;

public class QuestionId3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQuestionId3 id = new SolutionQuestionId3();
		System.out.println(id.lengthOfLongestSubstring("dvdf"));
		System.out.println(id.lengthOfLongestSubstring("abcabcbb"));

	}

}

//sliding window with two pointer i.e l, r
//youtube = https://www.youtube.com/watch?v=-zSxTJkcdAo
class SolutionQuestionId3 {
 public int lengthOfLongestSubstring(String s) {

 int l = 0, r = 0, maxLength = 0;
 Map<Character, Integer> mapI = new HashMap<>();
 
 while (r < s.length()) {
     if (mapI.containsKey(s.charAt(r))) { // when r is repeated
         if (mapI.get(s.charAt(r)) >= l && mapI.get(s.charAt(r)) < r) { // if the r is present in our substring
             l = mapI.get(s.charAt(r)) + 1;  // move l to one char forwrd to the exsiting rth character 
             mapI.replace(s.charAt(r), r);   // update the rth char index value with new rth char index
             // here since the substring is getting reduce so we dont have to calculate the maxLength
         } else { // if the r is not present in out substring 
             mapI.replace(s.charAt(r), r);   // update the rth char with new rth char index
             int length = r - l + 1;
             maxLength = length > maxLength ? length : maxLength;
         }

     } else { // when r in not repeated
         mapI.put(s.charAt(r), r);   // add in map
         int length = r - l + 1;     // get substring length
         maxLength = length > maxLength ? length : maxLength;    // get the max substring length    
     }
     r++; // move r forward by 1
 }
 return maxLength;
 }
}
