import java.util.HashMap;

/**
 * Created by yanxutao on 5/1/17.
 */
public class RomanToInt {

    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);

        map.put("X", 10);
        map.put("XX", 20);
        map.put("XXX", 30);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("LX", 60);
        map.put("LXX", 70);
        map.put("LXXX", 80);
        map.put("XC", 90);

        map.put("C", 100);
        map.put("CC", 200);
        map.put("CCC", 300);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("DC", 600);
        map.put("DCC", 700);
        map.put("DCCC", 800);
        map.put("CM", 900);

        map.put("M", 1000);
        map.put("MM", 2000);
        map.put("MMM", 3000);

        String str = "";
        int result = 0;
        int flag = 1000;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c == 'C' || c == 'D') && flag == 1000) {
                if (str != "") {
                    result += map.get(str);
                    str = "";
                }

                flag = 100;
            }

            if ((c == 'X' || c == 'L') && (flag == 1000 || flag == 100)) {
                if (str != "") {
                    result += map.get(str);
                    str = "";
                }
                flag = 10;
            }

            if ((c == 'I' || c == 'V') && (flag == 1000 || flag == 100 || flag == 10)) {
                if (str != "") {
                    result += map.get(str);
                    str = "";
                }
                flag = 1;
            }

            str += c;
        }

        if (str != "") {
            result += map.get(str);
        }

        return result;
    }

    private static HashMap<Character, Integer> map;

    static {
        map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt2(String s) {
        int result = map.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int pre = map.get(s.charAt(i - 1));
            int cur = map.get(s.charAt(i));

            if (pre >= cur) {
                result += cur;
            } else {
                result += (cur - 2 * pre);
            }
        }

        return result;
    }

    int charToInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public int romanToInt3(String s) {
        int result = charToInt(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int pre = charToInt(s.charAt(i - 1));
            int cur = charToInt(s.charAt(i));

            if (pre >= cur) {
                result += cur;
            } else {
                result += (cur - 2 * pre);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInt rti = new RomanToInt();
        rti.romanToInt("MMCCCVII");
    }
}
