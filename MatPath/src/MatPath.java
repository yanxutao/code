/**
 * Created by yanxutao on 8/5/17.
 */
public class MatPath {

    private char[] matrix;
    private int rows;
    private int cols;
    private char[] str;
    private boolean[][] flag;

    private int index;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.matrix = matrix;
        this.rows = rows;
        this.cols = cols;
        this.str = str;
        flag = new boolean[rows][cols];

        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] == true) {
            return false;
        }

        if (matrix[i * cols + j] == str[index]) {
            flag[i][j] = true;
            index++;

            if (index == str.length) {
                return true;
            }

            if (search(i - 1, j) || search(i, j - 1)
                    || search(i + 1, j) || search(i, j + 1)) {
                return true;
            }

            flag[i][j] = false;
            index--;
        }

        return false;
    }

    public static void main(String[] args) {
        String mat = "AAAAAAAAAAAA";
        char[] matrix = mat.toCharArray();
        int rows = 3;
        int cols = 4;
        String s = "AAAAAAAAAAAA";
        char[] str =s.toCharArray();

        MatPath mp = new MatPath();
        System.out.println(mp.hasPath(matrix, rows, cols, str));
    }

}
