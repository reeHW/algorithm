import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        // 각 회전에 대해 처리
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }

        return answer;
    }

    // 주어진 범위의 테두리를 시계방향으로 회전시키고 회전한 숫자 중 최솟값 반환
    private int rotate(int[][] matrix, int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int temp = matrix[x1][y1];
        int minVal = temp;

        // 왼쪽 회전
        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            minVal = Math.min(minVal, matrix[i][y1]);
        }

        // 아래쪽 회전
        for (int j = y1; j < y2; j++) {
            matrix[x2][j] = matrix[x2][j + 1];
            minVal = Math.min(minVal, matrix[x2][j]);
        }

        // 오른쪽 회전
        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];
            minVal = Math.min(minVal, matrix[i][y2]);
        }

        // 위쪽 회전
        for (int j = y2; j > y1; j--) {
            matrix[x1][j] = matrix[x1][j - 1];
            minVal = Math.min(minVal, matrix[x1][j]);
        }

        matrix[x1][y1 + 1] = temp;

        return minVal;
    }
}
