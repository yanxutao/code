import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by yanxutao on 8/20/17.
 */
public class WordBreakII {

    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, ArrayList<String>>());
    }

    private ArrayList<String> DFS(String s, Set<String> wordDict,
                                  HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                for (String str : DFS(s.substring(word.length()), wordDict, map)) {
                    res.add(word + (str == "" ? "" : " ") + str);
                }
            }
        }

        map.put(s, res);
        return res;
    }
}
