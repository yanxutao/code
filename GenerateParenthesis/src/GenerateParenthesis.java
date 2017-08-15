import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanxutao on 7/16/17.
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        helper(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    private void helper(List<String> list, StringBuilder sb,
                        int open, int close, int n) {
        if (open == n && close == n) {
            list.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            helper(list, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            helper(list, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }

}
