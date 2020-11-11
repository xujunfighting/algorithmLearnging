package study.learning.array;

public class IsValidSuDu {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result=isValidSudoku(chars);
        System.out.println(result);
    }
        public static boolean isValidSudoku(char[][] board) {
            int res11=0;
            int res12=0;
            int res13=0;
            int res21=0;
            int res22=0;
            int res23=0;
            int res31=0;
            int res32=0;
            int res33=0;
            for(int i=0;i<board.length;i++){
                int res1=0;
                int res2=0;
                for(int j=0;j<board.length;j++) {
                    if (board[i][j] != '.') {
                        res1 ^= Integer.valueOf(board[i][j]);
                    }
                    if (board[j][i] != '.') {
                        res2 ^= Integer.valueOf(board[j][i] + "");
                    }
                    if (board[i][j] != '.') {
                        if (i <= 2 & j <= 2) {
                            res11 ^= Integer.valueOf(board[i][j] + "");
                        } else if (i <= 2 && 2 < j && j <= 5) {
                            res12 ^= Integer.valueOf(board[i][j] + "");
                        } else if (i <= 2 && 5 < j) {
                            res13 ^= Integer.valueOf(board[i][j] + "");
                        }
                        if (2 < i && i <= 5 & j <= 2) {
                            res21 ^= Integer.valueOf(board[i][j] + "");
                        } else if (2 < i && i <= 5 && 2 < j && j <= 5) {
                            res22 ^= Integer.valueOf(board[i][j] + "");
                        } else if (2 < i && i <= 5 && 5 < j) {
                            res23 ^= Integer.valueOf(board[i][j] + "");
                        }
                        if (5 < i & j <= 2) {
                            res31 ^= Integer.valueOf(board[i][j] + "");
                        } else if (5 < i && 2 < j && j <= 5) {
                            res32 ^= Integer.valueOf(board[i][j] + "");
                        } else if (5 < i && 5 < j) {
                            res33 ^= Integer.valueOf(board[i][j] + "");
                        }
                    }
                }
                if(res1==0||res2==0) return false;
            }
            if((res11^res12^res13^res21^res22^res23^res31^res32^res33)==0){
                return false;
            }
            return true;
        }
    }
