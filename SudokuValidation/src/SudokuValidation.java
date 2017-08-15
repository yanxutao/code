/**
 * Created by yanxutao on 7/25/17.
 */
public class SudokuValidation {

    private boolean validate(char[] cs) {
        int[] bucket = new int[10];
        for (int i = 0; i < 9; i++) {
            char c = cs[i];
            if (c != '.') {
                bucket[c - '0']++;
                if (bucket[c - '0'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateRow(char[][] board, int row) {
        char[] cs = new char[9];
        for (int j = 0; j < 9; j++) {
            cs[j] = board[row][j];
        }
        return validate(cs);
    }

    private boolean validateColumn(char[][] board, int column) {
        char[] cs = new char[9];
        for (int i = 0; i < 9; i++) {
            cs[i] = board[i][column];
        }
        return validate(cs);
    }

    private boolean validateSquare(char[][] board, int square) {
        char[] cs = new char[9];
        int beginRow = square / 3;
        int endRow = beginRow + 2;
        int beginColumn = (square % 3) * 3;
        int endColumn = beginColumn + 2;
        int k = 0;
         for (int i = beginRow; i <= endRow; i++) {
            for (int j = beginColumn; j <= endColumn; j++) {
                cs[k] = board[i][j];
                k++;
            }
        }
        return validate(cs);
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (validateRow(board, i) == false) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (validateColumn(board, i) == false) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (validateSquare(board, i) == false) {
                return false;
            }
        }

        return true;
    }

}
