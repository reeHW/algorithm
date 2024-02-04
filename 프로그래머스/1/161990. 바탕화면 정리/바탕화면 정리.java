/*
        String [] wallpaper =  {"..........", ".....#....", "......##..", "...##.....", "....#....."}
        (1,3), (4+1, 7+1)
        - 파일이 존재하는 index를 기준으로 가장 왼쪽의 좌표점과 가장 오른쪽의 좌표점을 구해준다.
        - 가장 오른쪽의 좌표점은 가장 오른쪽에 있는 파일 index에서 +1 
*/
class Solution {
    static int[] solution(String[] wallpaper) {
        // top, left, bottom, right 초기화
        int[] answer =  {wallpaper.length, wallpaper[0].length(), -1, -1};
        
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                // lux -> #이 존재하는 배열 index중 가장 작은 index
                answer[0] = Math.min(answer[0], i);
                // rdx -> #이 존재하는 배열 index중 가장 큰 index
                answer[2] = Math.max(answer[2], i+1);

                // luy -> 배열내 각 문자열에서 #의 첫번째 index 
                int minColumnIndex = wallpaper[i].indexOf("#");
                answer[1] = Math.min(answer[1], minColumnIndex);
                // rdy -> 배열내 각 문자열에서 #의 마지막 index 
                int maxColumnIndex = wallpaper[i].lastIndexOf("#");
                answer[3] = Math.max(answer[3], maxColumnIndex+1);
            }
        }
        return answer;
    }
}