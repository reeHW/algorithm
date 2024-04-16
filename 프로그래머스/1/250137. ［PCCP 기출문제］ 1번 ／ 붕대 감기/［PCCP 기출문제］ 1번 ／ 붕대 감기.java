import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int successCount = 0;
        int currentHealth = health; // 현재 체력 변수 추가
        // 공격 기록을 맵으로 기록
        HashMap<Integer, Integer> attackLog = new HashMap<>();
        for (int[] attack : attacks) {
            attackLog.put(attack[0], attack[1]);
        }

        // 시간대별로 처리
        for (int time = 0; time <= attacks[attacks.length - 1][0]; time++) {
            // 공격 시간일 경우
            if (attackLog.containsKey(time)) {
                successCount = 0;
                currentHealth -= attackLog.get(time); // 현재 체력에서 공격 피해를 받음
                if (currentHealth <= 0) {
                    return -1;
                }
            } else { // 공격 시간이 아닐 경우
                successCount++;
                if (successCount < bandage[0]) {
                    currentHealth += bandage[1]; // 붕대 회복량 적용
                } else if (successCount == bandage[0]) {
                    currentHealth += bandage[1] + bandage[2]; // 추가 회복량 적용
                    successCount = 0;
                }
                if (currentHealth > health) {
                    currentHealth = health;
                }
            }
        }
        return currentHealth;
    }
}
