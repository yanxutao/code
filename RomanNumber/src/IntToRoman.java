/**
 * Created by yanxutao on 5/1/17.
 */
public class IntToRoman {

    public String intToRoman(int num) {

        // 1 2 3 4 5 6 7 8 9 10
        String[] strGe = {"", "I", "II", "III", "IV",
                          "V", "VI", "VII", "VIII", "IX"};

        String[] strShi = {"", "X", "XX", "XXX", "XL",
                           "L", "LX", "LXX", "LXXX", "XC"};

        String[] strBai = {"", "C", "CC", "CCC", "CD",
                          "D", "DC", "DCC", "DCCC", "CM"};

        String[] strQian = {"", "M", "MM", "MMM"};

        // 1 5 10 50 100 500 1000
        String[] str2 = {"I", "V", "X", "L", "C", "D", "M"};

        int qian = num / 1000;
        int bai = (num % 1000) / 100;
        int shi = (num % 100) / 10;
        int ge = num % 10;

        String result = strQian[qian];
        result += strBai[bai];
        result += strShi[shi];
        result += strGe[ge];

        return result;
    }

}
