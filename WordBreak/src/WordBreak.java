import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanxutao on 8/19/17.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] == true && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("leetcode");

        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(s, dict));
    }

}
