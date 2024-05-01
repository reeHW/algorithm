import java.util.Arrays;

public class Solution {
    public int solution(int[][] targets) {
        // 시작점을 기준으로 오름차순 정렬
        //[[1,4],[3,7],[4,5],[4,8],[5,12],[10,14],[11,13]]
        Arrays.sort(targets, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int currentEnd = -1;
        
        // 각 폭격 미사일을 순회
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            // 현재 폭격 미사일의 시작점이 이전에 요격한 가장 오른쪽 끝점과 같거나 더 앞서 있는 경우
            if (start >= currentEnd) {
                currentEnd = end;
                count++;
            } else {
                // 현재 폭격 미사일의 시작점이 이전에 요격한 가장 높은 끝점보다 좌표상 왼쪽에 있는 경우
                // 해당 미사일이 이전에 요격한 미사일에 포함되므로 끝점을 갱신
                currentEnd = Math.min(currentEnd, end);
            }
        }
        
        return count;
    }
}