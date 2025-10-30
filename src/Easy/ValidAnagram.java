/*issue:
youtube: solution 2 - https://www.youtube.com/watch?v=wKF6L9Zo8PQ

	
Description:
	Given two strings s and t, return true if t is an anagram of s, and false otherwise.
	
	
Explaination: */

package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionValidAnagram1 obj = new SolutionValidAnagram1();
		System.out.println("For anagram and nagaram - " + obj.isAnagram("anagram", "nagaram"));
		System.out.println("For rat and car - " + obj.isAnagram("rat", "car"));

	}

}

// my solution using hashmap TC = O(2n) and SC = O(1)
class SolutionValidAnagram1 {
	    public boolean isAnagram(String s, String t) {

	        // check the length is equal or not
	        if (s.length() != t.length()) return false;

	        // get a map to store count 
	        Map<Character, Integer> sMap = new HashMap<>();

	        // iterate in first string and fill the map
	        for (int i = 0 ; i < s.length() ; i++) {
	            if (sMap.containsKey(s.charAt(i))) {
	                // update the count with 1
	                int count = sMap.get(s.charAt(i)) + 1;
	                sMap.replace(s.charAt(i), count);
	            } else {
	                // add the char and count 0
	                sMap.put(s.charAt(i), 1);
	            }
	        }

	        // iterate in second string and remove the char from map
	        for (int i = 0 ; i < t.length() ; i++) {
	            if (sMap.containsKey(t.charAt(i))) {
	                // check if the count in 1, if yes then remove the char
	                if (sMap.get(t.charAt(i)) == 1) {
	                    // remove the char from map
	                    sMap.remove(t.charAt(i));
	                } else {
	                    // minus count by 1
	                    int count = sMap.get(t.charAt(i)) - 1;
	                    sMap.replace(t.charAt(i), count);
	                }
	            } else {
	                // char dose not present in map i.e. not a anagram string
	                return false;
	            }
	        }

	        // if the map contain any char then it is not a anagram strings
	        return sMap.isEmpty();
	    }
	}

// better than my solution using ASCII values TC = O(n+26) and SC = O(1)
	class SolutionValidAnagram2 {
	    public boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()) {
	            return false;
	        }
	        
	        int[] freq = new int[26];
	        for (int i = 0; i < s.length(); i++) {
	            freq[s.charAt(i) - 'a']++;
	            freq[t.charAt(i) - 'a']--;
	        }
	        
	        for (int i = 0; i < freq.length; i++) {
	            if (freq[i] != 0) {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	}

//	best soluiton using Arrays and its functions (The dominant step is the sorting, so the total time complexity is O(n log n)
//	and SC = o(n)
	class SolutionValidAnagram3 {
	    public boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()) return false;
	        char[] s1 = s.toCharArray(); // tc o(n)
	        char[] s2 = t.toCharArray(); // tc o(n)

	        Arrays.sort(s1); // tc o(n log n)
	        Arrays.sort(s2); // tc o(n log n)

	        return Arrays.equals(s1, s2); // tc o(n)
	    }
	}
