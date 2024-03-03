import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int currX = 0;
        int currY = 0;
        
        // 시작 위치 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    currY = i;
                    currX = j;
                    break;
                }
            }
        }
        
        
        for (String route : routes) {
            char direction = route.charAt(0);
            int distance = route.charAt(2) - '0';
            
            // 명령에 따라 이동하기 전의 위치 저장
            int initialX = currX; 
            int initialY = currY;
            
            // 이동할 방향으로 한 칸씩 확인하여 이동할 수 있는지 확인
            for (int i = 0; i < distance; i++) {
                int newX = currX;
                int newY = currY;
                
                if (direction == 'N') newY--; 
                else if (direction == 'S') newY++;
                else if (direction == 'W') newX--;
                else if (direction == 'E') newX++;

                // 새로운 위치가 공원 범위를 벗어나는지 OR 장애물을 만나는지 확인
                if (newY < 0 || newY >= park.length || newX < 0 || newX >= park[0].length() || park[newY].charAt(newX) == 'X') {
                    // 범위를 벗어나거나 장애물을 만났을 때 이동 전 위치로 되돌림
                    currX = initialX;
                    currY = initialY;
                    break;
                }
                
                // 이동 가능하면 위치 업데이트
                currX = newX;
                currY = newY;
            }
        }

        return new int[]{currY, currX};
    }
}
