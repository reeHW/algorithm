class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    numberOfArea++;
                    int areaSize = dfs(picture, visited, i, j, picture[i][j], m, n);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int dfs(int[][] picture, boolean[][] visited, int x, int y, int color, int m, int n) {
        visited[x][y] = true;
        int areaSize = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위를 벗어남
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

            // 방문한 셀
            if (visited[nx][ny]) continue;
            
            // 같은 색이 아님
            if(picture[nx][ny] != color) continue;
            
            areaSize += dfs(picture, visited, nx, ny, color, m, n);
        }

        return areaSize;
    }
}