class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 전체 격자의 수
        int total = brown + yellow;
        
        /* 카펫의 세로 길이 후보를 탐색 
           1. 갈색 타일은 노란색 타일을 감싸야 함. -> brown = yellow + 2
           2. 가로 길이 >= 세로 길이 -> 가로 길이는 전체 격자의 절반보다 커질 수 없음
        */
        for (int height = 3; height <= total / 2; height++) {
            // 세로 길이로 나누어 떨어지는 경우에만 확인
            if (total % height == 0) {
                int width = total / height;
                
                // yellow 격자수 check
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        
        return answer;
    }
}
