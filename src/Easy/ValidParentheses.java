package Easy;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionValidParentheses parentheses = new SolutionValidParentheses();
		System.out.println(parentheses.isValid("()[]{}"));
	}

}

class SolutionValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> sCheck = new Stack<>();
        
        for (char c : s.toCharArray()) {
           switch (c) {
                case '(':
                case '{':
                case '[':
                    sCheck.push(c);
                    break;
                case ')':
                    if (sCheck.empty() || sCheck.pop() != '(') {
                        return false;
                    } 
                    break;
                case '}':
                    if (sCheck.empty() || sCheck.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (sCheck.empty() || sCheck.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    return false;
           }
        }
        return sCheck.empty();
    }
}
