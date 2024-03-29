import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution1 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i + 1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}

class Solution2 {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();
         // 전화번호를 해시로 매핑하여 해시맵에 저장
        for (String phoneNumber : phone_book) {
            map.put(phoneNumber, true);
        }
        
        // 각 전화번호의 접두사가 해시 테이블에 있는지 확인
        for (String phoneNumber : phone_book) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false; // 접두사를 발견한 경우 false를 반환
                }
            }
        }
        
        return true;
    }
}
