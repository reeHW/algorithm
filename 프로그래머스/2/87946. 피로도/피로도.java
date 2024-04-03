public class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return exploreDungeons(k, dungeons, visited, 0);
    }

    private int exploreDungeons(int k, int[][] dungeons, boolean[] visited, int count) {
        int maxCount = count; // 현재까지의 최대 탐험 가능한 던전 수
        
        for (int i = 0; i < dungeons.length; i++) {
            // 이미 방문한 던전은 건너뜀.
            if (visited[i]) continue;
            
            // 현재 피로도로 해당 던전을 탐험할 수 있는지 check
            if (k >= dungeons[i][0]) {
                visited[i] = true; 
                int remainingK = k - dungeons[i][1]; // 탐험 후 남은 피로도를 계산
                maxCount = Math.max(maxCount, exploreDungeons(remainingK, dungeons, visited, count + 1));
                visited[i] = false; // 해당 던전을 다시 방문하지 않은 상태로 되돌림
            }
        }
        
        return maxCount;
    }
}
