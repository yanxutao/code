/**
 * Created by yanxutao on 8/8/17.
 */
public class RegExpr {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int si, char[] pattern, int pi) {
        if (si == str.length && pi == pattern.length) {
            return true;
        }

        if (si != str.length && pi == pattern.length) {
            return false;
        }

        if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
            if (si != str.length && (pattern[pi] == str[si] || pattern[pi] == '.')) {
                return matchCore(str, si, pattern, pi + 2)
                        || matchCore(str, si + 1, pattern, pi + 2)
                        || matchCore(str, si + 1, pattern, pi);
            } else {
                return matchCore(str, si, pattern, pi + 2);
            }
        }

        if (si != str.length && (pattern[pi] == str[si] || pattern[pi] == '.')) {
            return matchCore(str, si + 1, pattern, pi + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'a'};
        char[] pattern = {'a', '*', 'b', 'a'};
        RegExpr re = new RegExpr();
        System.out.println(re.match(str, pattern));
    }
}
