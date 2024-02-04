/*
        String [] wallpaper =  {"..........", ".....#....", "......##..", "...##.....", "....#....."}
        (1,3), (4+1, 7+1)
        - 파일이 존재하는 index를 기준으로 가장 왼쪽의 좌표점과 가장 오른쪽의 좌표점을 구해준다.
        - 가장 오른쪽의 좌표점은 가장 오른쪽에 있는 파일 index에서 +1 
*/
class Solution {
    static int[] solution(String[] wallpaper) {
        // x -> 행, y -> 열
        int[] answer = new int[4];
        
        // 가장 왼쪽의 좌표점 S(lux, luy)
        answer[0] = wallpaper.length + 1; // 행의 최대값보다 큰 값으로 초기화
        answer[1] = wallpaper[0].length() + 1; // 열의 최대값보다 큰 값으로 초기화

        // 가장 오른쪽의 좌표점 E(rdx, rdy)
        answer[2] = -1; // 행의 최소값(0) 보다 작은 값으로 초기화
        answer[3] =  -1; // 열의 최소값(0) 보다 작은 값으로 초기화
        
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                // lux, rdx -> #이 존재하는 배열 index중 최소값과 최대값
                answer[0] = Math.min(answer[0], i);
                answer[2] = Math.max(answer[2], i+1);

                // luy -> 배열내 문자열의 각 첫번째 # index 중 최소값
                int minColumnIndex = wallpaper[i].indexOf("#");
                answer[1] = Math.min(answer[1], minColumnIndex);
                // rdy -> 배열내 문자열의 각 마지막 # index 중 최대값
                int maxColumnIndex = wallpaper[i].lastIndexOf("#");
                answer[3] = Math.max(answer[3], maxColumnIndex+1);
            }
        }
        return answer;
    }
}