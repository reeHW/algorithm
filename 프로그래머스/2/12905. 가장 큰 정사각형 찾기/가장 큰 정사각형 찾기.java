class Solution {
    public int solution(int[][] board) {
        int maxVal = 0; // 최대 정사각형의 한 변의 길이
        int row = board.length;
        int col = board[0].length;
        
        if (row == 1 && col == 1) {
            if (board[0][0] == 1) return 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    maxVal = Math.max(maxVal, board[i][j]);
                }
            }
        }

        return maxVal * maxVal;
    }
}
