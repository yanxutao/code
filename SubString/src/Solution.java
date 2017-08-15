import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanxutao on 2/14/17.
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int left = 0;

        Map<Character, Integer> cur = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (cur.containsKey(c)) {
                if (left < cur.get(c) + 1) {
                    left = cur.get(c) + 1;
                }
            }

            cur.put(c, i);

            if (maxLength < i - left + 1) {
                maxLength = i - left + 1;
            }
        }

        return maxLength;
    }

}
