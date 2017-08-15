import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanxutao on 7/23/17.
 */
public class WordsConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        int wordNum = words.length;

        if (s == null || s.length() == 0
                || words == null || words.length == 0
                || s.length() < wordNum * wordLength) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (int i = 0; i < wordLength; i++) {
            int count = 0;

            Map<String, Integer> curMap = new HashMap<>();

            for (int l = i, r = i; r + wordLength <= s.length(); r += wordLength) {
                String str = s.substring(r, r + wordLength);

                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)) {
                        curMap.put(str, curMap.get(str) + 1);
                    } else {
                        curMap.put(str, 1);
                    }

                    if (curMap.get(str) <= map.get(str)) {
                        count++;
                    }

                    while (curMap.get(str) > map.get(str)) {
                        String firstWord = s.substring(l, l + wordLength);
                        curMap.put(firstWord, curMap.get(firstWord) - 1);
                        l += wordLength;
                        if (curMap.get(firstWord) < map.get(firstWord)) {
                            count--;
                        }
                    }

                    if (count == wordNum) {
                        result.add(l);
                        String firstWord = s.substring(l, l + wordLength);
                        curMap.put(firstWord, curMap.get(firstWord) - 1);
                        l += wordLength;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    l = r + wordLength;
                }
            }

            curMap.clear();
        }

        return result;
    }

}
