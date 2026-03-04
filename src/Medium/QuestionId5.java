package Medium;

// 5. Longest Palindromic Substring
public class QuestionId5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQuestionId5 id = new SolutionQuestionId5();
		System.out.println(id.longestPalindrome("babad"));
		System.out.println(id.longestPalindrome("cbbd"));

	}

}

//calculate with odd and even index
//youtube = https://www.youtube.com/watch?v=uX0-xyPkR2w
class SolutionQuestionId5 {
 public String longestPalindrome(String s) {
     if(s.length() <= 1) return s;
     String ansString = "";

     for (int i = 1; i < s.length(); i++) {
         // 1st consider for odd index as middle
         int left = i;
         int right = i;
         while(s.charAt(left) == s.charAt(right)) {
             left = --left;
             right = ++right;
             if (left == -1 || right == s.length()) {
                 break;
             }
         }
         String palindromicSubString = s.substring(++left, right);
         if (palindromicSubString.length() > ansString.length()) {
             ansString = palindromicSubString;
         }

         // 2nd consider for even index as middle
         left = i - 1;
         right = i;
         while(s.charAt(left) == s.charAt(right)) {
             left = --left;
             right = ++right;
             if(left == -1 || right == s.length()) {
                 break;
             }
         }
         palindromicSubString = s.substring(++left, right);
         if(palindromicSubString.length() > ansString.length()) {
             ansString = palindromicSubString;
         }
     }
     return ansString;

 }
}