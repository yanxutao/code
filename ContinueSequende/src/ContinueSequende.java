import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/8/17.
 */
public class ContinueSequende {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int begin = 1;
        int end = 1;
        int s = 1;

        while (begin <= end) {
            while (s < sum) {
                end++;
                s += end;
            }

            if (s == sum) {
                ArrayList<Integer> l = new ArrayList<>();
                for (int i = begin; i <= end; i++) {
                    l.add(i);
                }
                list.add(l);

                s -= begin;
                begin++;
            }

            while (s > sum) {
                s -= begin;
                begin++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        ContinueSequende cs = new ContinueSequende();
        ArrayList<ArrayList<Integer>> ans = cs.FindContinuousSequence(sum);
        for (int i = 0; i < ans.size(); i++) {
            ArrayList<Integer> l = ans.get(i);
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j) + ",");
            }
            System.out.println();
        }
    }

}
