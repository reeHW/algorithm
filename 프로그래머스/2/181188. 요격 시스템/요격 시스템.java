import java.util.Arrays;

public class Solution {
    public int solution(int[][] targets) {
        //[[1,4],[3,7],[4,5],[4,8],[5,12],[10,14],[11,13]]
        Arrays.sort(targets, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 1; // 첫번째 요격
        int currentEnd = targets[0][1];
        
        // 각 폭격 미사일을 순회하면서 요격 수를 측정
        for (int[] target : targets) {
            if (target[0] >= currentEnd) {
                currentEnd = target[1];
                count++;
            }
        }
        
        return count;
    }
}
