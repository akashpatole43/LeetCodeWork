package Easy;
import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {
	public static void main(String[] args) {
		Solution_Roman_to_Integer sol = new Solution_Roman_to_Integer();
        String s = "MCMXCIV"; 
        int result = sol.romanToInt(s);
        System.out.println("Integer value: " + result);
    }
}
class Solution_Roman_to_Integer {
    public int romanToInt(String s) {
        int num = 0;
        // create a Map of roman numbers and its values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        // iterate in loop from 0 to last second char of string
        for (int i = 0; i < s.length()-1 ; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))) {
                // future roman no is greater than current so minue its value
                num = num - romanMap.get(s.charAt(i));
            } else {
                // future no is smaller or equal to current value so add its value
                num = num + romanMap.get(s.charAt(i));
            }
        }
        // need to directly add the last char value of string
        num = num + romanMap.get(s.charAt(s.length()-1));
        return num;
    }
}
