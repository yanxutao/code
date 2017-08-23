import java.util.ArrayList;

/**
 * Created by yanxutao on 8/20/17.
 */
public class PalindromePartition {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        if (s.length() == 0) {
            return res;
        }

        ArrayList<String> path = new ArrayList<>();
        dfs(s, path, res);

        return res;
    }

    private void dfs(String s, ArrayList<String> path,
                     ArrayList<ArrayList<String>> res) {
        int n = s.length();

        if (n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            String s1 = s.substring(0, i + 1);
            if (isPalindrome(s1)) {
                path.add(s1);
                String s2 = s.substring(i + 1);
                dfs(s2, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        for (; begin < end; begin++, end--) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<String>> partition1(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        int n = s.length();

        for (int i = 1; i <= n; i++) {
            String s1 = s.substring(0, i);
            if (isPalindrome(s1)) {
                String s2 = s.substring(i);
                ArrayList<ArrayList<String>> tmp = partition1(s2);
                if (tmp.size() == 0) {
                    ArrayList<String> newStrs = new ArrayList<>();
                    newStrs.add(s1);
                    res.add(newStrs);
                }
                for (ArrayList<String> strs : tmp) {
                    strs.add(0, s1);
                    res.add(strs);
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = (isPalindrome(s.substring(0, i + 1))) ? 0 : i;
            if (dp[i] == 0) {
                continue;
            }

            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + i - j + 1);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        PalindromePartition pp = new PalindromePartition();
        String s = "abacaba";
        ArrayList<ArrayList<String>> res = pp.partition(s);
        for (ArrayList<String> strs : res) {
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

}
