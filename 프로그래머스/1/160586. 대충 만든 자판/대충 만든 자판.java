import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        /* 1. 타겟값이 자판에 있는지 확인
           2. 어떤 자판을 누르든 최소로 누르는 방법만 알면 됨 */

        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char currentChar = key.charAt(i);
                if (!map.containsKey(currentChar) || i < map.get(currentChar)) {
                    map.put(currentChar, i + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char target = targets[i].charAt(j);
                if (!map.containsKey(target)) {
                    cnt = 0;
                    break;
                } else {
                    cnt += map.get(target);
                }
            }
            answer[i] = cnt == 0 ? -1 : cnt;
        }
        return answer;
    }
}