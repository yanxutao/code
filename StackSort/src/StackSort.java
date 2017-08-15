import java.util.Stack;

/**
 * Created by yanxutao on 1/26/17.
 */
public class StackSort {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();

        while (!stack.empty()) {
            Integer cur = stack.pop();
            while (!help.empty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.empty()) {
            stack.push(help.pop());
        }
    }

}
