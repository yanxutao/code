import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanxutao on 7/3/17.
 */
public class LetterCombinations {

    private String[] mapping = {"", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<>();

        if (digits.length() == 0) {
            return l;
        }

        int digit = Character.getNumericValue(digits.charAt(0));

        List<String> subl = letterCombinations(digits.substring(1));

        if (subl.size() == 0) {
            subl.add("");
        }

        for (char c : mapping[digit].toCharArray()) {
            for (String s : subl) {
                l.add(c + s);
            }
        }

        return l;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        LetterCombinations lc = new LetterCombinations();
        List<String> l = lc.letterCombinations(digits);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

}
