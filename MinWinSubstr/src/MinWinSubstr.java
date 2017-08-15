import java.util.HashMap;

/**
 * Created by yanxutao on 7/23/17.
 */
public class MinWinSubstr {

    public String minWindow(String s, String t) {

        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0;
        int count = 0;

        int minLeft = 0;
        int minLength = s.length() + 1;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);

                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }

                while (count == t.length()) {
                    if (right - left + 1 < minLength) {
                        minLeft = left;
                        minLength = right - left + 1;
                    }

                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);

                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }

                    left++;
                }
            }
        }

        if (minLength > s.length()) {
            return "";
        } else {
            return s.substring(minLeft, minLeft + minLength);
        }
    }

}
