import java.util.*;
class Solution {
        public int solution(String[][] book_time) {
        int n = book_time.length;
        List<int[]> events = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int start = timeToMinutes(book_time[i][0]);
            int end = timeToMinutes(book_time[i][1]) + 10; // 종료시간에 청소시간 추가
            events.add(new int[]{start, 1}); // 시작 이벤트
            events.add(new int[]{end, -1}); // 종료 이벤트
        }
        
        // 이벤트를 시간 순으로 정렬, 시간이 같다면 종료 이벤트를 먼저 처리
        events.sort((a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        int maxRooms = 0;
        int currentRooms = 0;
        
        for (int[] event : events) {
            currentRooms += event[1];
            maxRooms = Math.max(maxRooms, currentRooms);
        }
        
        return maxRooms;
    }
    
       // "hh:mm" 형식의 시간을 분으로 변환
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}