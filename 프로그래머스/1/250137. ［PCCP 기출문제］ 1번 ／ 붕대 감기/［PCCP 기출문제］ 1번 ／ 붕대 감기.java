import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int successCount = 0;
        int maxHealth = health;
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
                health -= attackLog.get(time);
                if (health <= 0) {
                    return -1;
                }
            } else { // 공격 시간이 아닐 경우
                successCount++;
                if (successCount < bandage[0]) {
                    health += bandage[1];
                } else if (successCount == bandage[0]) {
                    health += bandage[1];
                    health += bandage[2];
                    successCount = 0;
                }
                if (health > maxHealth) {
                    health = maxHealth;
                }
            }
        }
        return health;
    }
}
