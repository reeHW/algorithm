import java.util.*;

class Solution {
    private int n, m;
    private boolean[][] visited;
    private Map<Integer, Integer> oilSizeMap;
    private int currentOilSize;
    private int[][] land;
   
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        this.n = land.length;
        this.m = land[0].length;
        this.land = land;
        this.visited = new boolean[n][m];
        this.oilSizeMap = new HashMap<>();
        
        int oilId = 2; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    currentOilSize = 0;
                    findOil(i, j, oilId);
                    oilSizeMap.put(oilId, currentOilSize);
                    oilId++;
                }
            }
        }
        
        int maxOil = 0;
        for (int col = 0; col < m; col++) {
            Set<Integer> encounteredOilIds = new HashSet<>();
            int oilAmount = 0;
            for (int row = 0; row < n; row++) {
                if (land[row][col] > 1) {
                    int id = land[row][col];
                    if (!encounteredOilIds.contains(id)) {
                        oilAmount += oilSizeMap.get(id);
                        encounteredOilIds.add(id);
                    }
                }
            }
            maxOil = Math.max(maxOil, oilAmount);
        }
        
        return maxOil;
    }
    
    private void findOil(int x, int y, int oilId) {
        // 영역을 벗어남
        if (x < 0 || y < 0 || x >= n || y >= m) return;
        // 방문했거나 빈땅
        if(visited[x][y] || land[x][y] != 1) return;
        
        visited[x][y] = true;
        land[x][y] = oilId;
        currentOilSize++;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            findOil(nx, ny, oilId);
        }
    }
}
