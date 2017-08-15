/**
 * Created by yanxutao on 5/11/17.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String commonStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (commonStr == null || commonStr.length() == 0) {
                return "";
            }
            int j = 0;
            for (j = 0; j < strs[i].length() && j < commonStr.length()
                    && strs[i].charAt(j) == commonStr.charAt(j); j++);
            commonStr = commonStr.substring(0, j);
        }

        return commonStr;
    }

    public static void main(String[] args) {
        String[] strs = {};
        String str = null;
        System.out.println(strs.length);
    }
}
