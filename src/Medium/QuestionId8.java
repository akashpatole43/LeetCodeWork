package Medium;

// 8. String to Integer (atoi)
public class QuestionId8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQuestionId8 id = new SolutionQuestionId8();
		System.out.println(id.myAtoi("   -042"));
		System.out.println(id.myAtoi("1337c0d3"));
		System.out.println(id.myAtoi("words and 987"));
		System.out.println(id.myAtoi("0-1"));
	}

}

//youtube = https://www.youtube.com/watch?v=An1BTSYpOIY
class SolutionQuestionId8 {
    public int myAtoi(String s) {

        // Step 1
        s = s.trim();
        if (s.isEmpty()) return 0;

        // Step 2
        int i = 0;
        int signInt = 1;
        if(s.charAt(i) == '-') {
            signInt = -1;
            i++;
        } else if (s.charAt(i) =='+') {
            i++;
        }

        long num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            // Step 3
            // for conversion we will use ASCII values 
            // formula is (s.charAt(i) - '0') meaning 
            // ascii value anyword - 0 will give that word numeric value
            num = (num * 10) + (s.charAt(i) - '0');

            // Step 4
            // it is said that the value could be greater than INterger,max value or lesser than Integer.min value, 
            // So the datatype of num should be long
            if (signInt * num > Integer.MAX_VALUE) { // rounding up to 32 bit
                return Integer.MAX_VALUE;
            } else if (signInt * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }
        return (int) (signInt * num); // convert long to int and then return
    }
}