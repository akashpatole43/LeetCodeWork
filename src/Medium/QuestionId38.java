package Medium;

/*
Title = 38. Count and Say

Question = The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) 
with the concatenation of the character and the number marking the count of the characters (length of the run). For example, 
to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". 
Thus the compressed string becomes "23321511".
Given a positive integer n, return the nth element of the count-and-say sequence.
		
youtube = https://youtu.be/mkIdsGQfKAI?si=JxZnqaVTN0113wmz
	
Explain =	
	n = 1  ➝  "1"                     1️⃣ it's just "1"  
	n = 2  ➝  "11"                    🧍 one 1 ➝ "11"  
	n = 3  ➝  "21"                    👫 two 1s ➝ "21"  
	n = 4  ➝  "1211"                  1️⃣ one 2, one 1 ➝ "1211"  
	n = 5  ➝  "111221"                🧙 one 1, one 2, two 1s ➝ "111221"  
	n = 6  ➝  "312211"                3️⃣ three 1s, two 2s, one 1 ➝ "312211"  
	n = 7  ➝  "13112221"              😤 one 3, one 1, two 2s, two 1s ➝ "13112221"  
	n = 8  ➝  "1113213211"            🤯 one 1, one 3, two 1s, three 2s, one 1 ➝ "1113213211"  
	...
	
*/	
public class QuestionId38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SolutionQuestionId38 s = new SolutionQuestionId38();
		System.out.println("1211".equals(s.countAndSay(4)));

	}

}

class SolutionQuestionId38 {
 public String countAndSay(int n) {
     // Step 1:
     // start with the base case, i.e first term is alsways 1
     String res = "1";
     // Step 2:
     // loop to build each term form 2 to n
     for (int i = 1; i < n; i++) {
         // a temp builder to construct the next term
         StringBuilder temp = new StringBuilder();
         // varible count for counting repeating digits
         int count = 1;
         // Step 3:
         // loop through the current result string starting from index 1
         for (int j = 1; j < res.length(); j++) {
             // Step 4:
             // if current char is same as previous char then increment count
             if (res.charAt(j) == res.charAt(j - 1)) {
                 count++;
             } else {
                 // if different then append count and previous char in temp
                 temp.append(count).append(res.charAt(j - 1));
                 // reset count to 1
                 count = 1;
             }
         }
         // Step 5:
         // Append to temp with last char after the loop
         temp.append(count).append(res.charAt(res.length() - 1));
         // Step 6:
         // update the res string with newly formed term
         res = temp.toString();
     }
     // return the nth term in sequence
     return res;
 }
}