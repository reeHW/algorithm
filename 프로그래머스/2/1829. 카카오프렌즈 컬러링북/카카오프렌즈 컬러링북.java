class Solution {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        int[] dx = {-1, 1, 0, 0};  // 상하 이동
        int[] dy = {0, 0, -1, 1};  // 좌우 이동

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    numberOfArea++;
                    int areaSize = dfs(picture, visited, i, j, picture[i][j], m, n, dx, dy);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int dfs(int[][] picture, boolean[][] visited, int x, int y, int color, int m, int n, int[] dx, int[] dy) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || picture[x][y] != color) {
            return 0;
        }

        visited[x][y] = true;
        int areaSize = 1;

        for (int i = 0; i < 4; i++) {
            areaSize += dfs(picture, visited, x + dx[i], y + dy[i], color, m, n, dx, dy);
        }

        return areaSize;
    }
}