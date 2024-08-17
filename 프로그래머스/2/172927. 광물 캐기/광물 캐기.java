import java.util.*;

public class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] fatigue = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
        };
        
        int totalPicks = 0;
        for(int pick : picks){
            totalPicks += pick*5;
        }
        
        // 곡괭이로 캘 수 있는 횟수보다 광물이 많을 경우
        if (minerals.length > totalPicks) {
            minerals = Arrays.copyOfRange(minerals, 0, totalPicks);
        }
        
        List<List<String>> mineralGroups = new ArrayList<>();
        List<String> mineralList = Arrays.asList(minerals);
        
        int numberOfGroups = (minerals.length + 4) / 5;
        
        for (int i = 0; i < numberOfGroups; i++) {
            int start = i * 5;
            int end = Math.min(start + 5, minerals.length);
            mineralGroups.add(new ArrayList<>(mineralList.subList(start, end)));
        }
        
          // 각 그룹을 캘 때의 피로도 계산
        List<int[]> groupFatigue = new ArrayList<>();
        for (List<String> group : mineralGroups) {
            int[] fatigueValues = {0, 0, 0}; 
            for (String mineral : group) {
                int index = 0;
                if (mineral.equals("diamond")) {
                    index = 0;
                } else if (mineral.equals("iron")) {
                    index = 1;
                } else if (mineral.equals("stone")) {
                    index = 2;
                }
                fatigueValues[0] += fatigue[0][index];
                fatigueValues[1] += fatigue[1][index];
                fatigueValues[2] += fatigue[2][index];
            }
            groupFatigue.add(fatigueValues);
        }
        
        // 피로도가 높은 순서대로 그룹 정렬
        Collections.sort(groupFatigue, (a, b) -> {
            if (b[2] != a[2]) {
                return b[2] - a[2];
            } else if (b[1] != a[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        int totalFatigue = 0;
        for (int[] fatigueValues : groupFatigue) {
            if (picks[0] > 0) {
                totalFatigue += fatigueValues[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                totalFatigue += fatigueValues[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                totalFatigue += fatigueValues[2];
                picks[2]--;
            } else {
                break; // 사용할 곡괭이가 더 이상 없으면 종료
            }
        }

        return totalFatigue;
    }
    
}