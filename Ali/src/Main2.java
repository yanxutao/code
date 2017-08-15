import java.util.Scanner;

public class Main2 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int findMeetingTime(String[] meetingTimeArray) {
        int num = meetingTimeArray.length;
        int[][] data = new int[num][2];
        for (int i = 0; i < num; i++) {
            String[] tmp = meetingTimeArray[i].split(" ");
            data[i][0] = Integer.parseInt(tmp[0]);
            data[i][1] = Integer.parseInt(tmp[1]);
        }
        boolean[] flag = new boolean[num];

        int i;
        int min = 0;

        for (i = 0; i < num; i++) {
            if (flag[i] == false) {
                min = data[i][0];
                break;
            }
        }

        for (; i < num; i++) {
            if (flag[i] == false && data[i][0] < min) {
                min = data[i][0];
                break;
            }
        }

        return 1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _meetingTimeArray_size = 0;
        _meetingTimeArray_size = Integer.parseInt(in.nextLine().trim());
        String[] _meetingTimeArray = new String[_meetingTimeArray_size];
        String _meetingTimeArray_item;
        for(int _meetingTimeArray_i = 0; _meetingTimeArray_i < _meetingTimeArray_size; _meetingTimeArray_i++) {
            try {
                _meetingTimeArray_item = in.nextLine();
            } catch (Exception e) {
                _meetingTimeArray_item = null;
            }
            _meetingTimeArray[_meetingTimeArray_i] = _meetingTimeArray_item;
        }

        res = findMeetingTime(_meetingTimeArray);
        System.out.println(String.valueOf(res));

    }
}
