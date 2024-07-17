import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        List<int[]> countList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            countList.add(new int[] {entry.getKey(), entry.getValue()});
        }

        // 빈도 수에 따라 내림차순으로 정렬
        Collections.sort(countList, (a, b) -> b[1] - a[1]);

     
        int remainingK = k;
        int answer = 0;

        for (int[] count : countList) {
            if (remainingK > 0) {
                remainingK -= count[1];
                answer++;
            }
            if (remainingK <= 0) {
                break;
            }
        }

        return answer;
    }
}