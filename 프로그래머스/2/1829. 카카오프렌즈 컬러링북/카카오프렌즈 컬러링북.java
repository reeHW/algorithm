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
                    int areaSize = findAreaSize(picture, visited, i, j, picture[i][j], m, n);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int findAreaSize(int[][] picture, boolean[][] visited, int x, int y, int color, int m, int n) {
        // 영역을 벗어남
        if (x < 0 || x >= m || y < 0 || y >= n) return 0;
        // 방문했거나 색이 다름
        if (visited[x][y] || picture[x][y] != color) return 0;

        visited[x][y] = true;
        int areaSize = 1;

        for (int i = 0; i < 4; i++) {
            areaSize += findAreaSize(picture, visited, x + dx[i], y + dy[i], color, m, n);
        }

        return areaSize;
    }
}