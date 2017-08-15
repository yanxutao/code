import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yanxutao on 7/12/17.
 */
public class ValidParentheses {

    private boolean isMatch(char pre, char post) {
        if ((pre == '(' && post == ')')
                || (pre == '[' && post == ']')
                || (pre == '{' && post == '}')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    if (isMatch(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid(s));
    }

}
