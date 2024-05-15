class Solution {
    public int solution(int[][] board) {
        int maxSquareSize = 0; // 최대 정사각형의 한 변의 길이
        int row = board.length;
        int col = board[0].length;

        // 후보 셀을 순회하면서 최대 정사각형의 한 변의 길이 계산
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                    }
                    maxSquareSize = Math.max(maxSquareSize, board[i][j]);
                }
            }
        }

        // 최대 정사각형의 넓이 반환
        return maxSquareSize * maxSquareSize;
    }
}
