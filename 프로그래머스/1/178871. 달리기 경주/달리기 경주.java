import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> currRank = new HashMap<>();
    
        for(int i = 0; i < players.length; i++){
            currRank.put(players[i], i);
        }
        
        for(String calledPlayer : callings){
            int calledPlayerIndex = currRank.get(calledPlayer); // 호명한 선수의 순위
            int frontPlayerIndex = calledPlayerIndex - 1; // 앞 선수의 순위
            String frontPlayer = players[frontPlayerIndex];
            
            /* 호명한 선수와 앞 선수의 index를 변경. */
            currRank.replace(calledPlayer, frontPlayerIndex);
            players[frontPlayerIndex] = calledPlayer;
            currRank.replace(frontPlayer, calledPlayerIndex);  
            players[calledPlayerIndex] = frontPlayer;
        }
       
        return players;
    }
}