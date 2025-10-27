package Easy;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionLongestCommonPrefix obj = new SolutionLongestCommonPrefix();
		
		String[] strs = {"flower","flow","flight"};
		String expectedAns = "fl";
		String result = obj.longestCommonPrefix(strs);
		System.out.println(result + " " + expectedAns);
		System.out.println(expectedAns.equals(result));

	}

}

class SolutionLongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        if (strs.length == 0) return "";
        String a = strs[0];
        int s = strs.length;
        String b = strs[s-1];
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < a.length() ; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                res.append(a.charAt(i));
            } else if (res.length() != 0) {
                return res.toString();
            } else {
                return "";
            }
        }
        return res.toString();
    }
}
