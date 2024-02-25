import java.util.*;

class Solution {
    public int solution(String[] board) {
        
        int checkO = 0;
        int checkX = 0;
        
        for (int i = 0; i < board.length; i++) {
            checkO += countChar(board[i], 'O');
            checkX += countChar(board[i], 'X');
        }
        
        // 게임 시작 안 한 경우
        if(checkO == 0 && checkX == 0) return 1;
        
        // "O"의 개수가 "X"의 개수보다 적거나, 번갈아서 한 번씩 체크하지 않은 경우 유효하지 않음
        if (checkO < checkX || checkO > checkX + 1) return 0;
        
        
        // "O" 가 이기고 게임이 종료되었을 때, "O"의 개수가 "X"의 개수보다 적거나 같으면 유효하지 않음.
        if(isGameEnded(board, 'O')){
            if(checkO <= checkX) return 0;
        } 
        
         // "X" 가 이기고 게임이 종료되었을 때, "X"의 개수가 "O" 의 개수와 같지 않다면 유효하지 않음.
        if(isGameEnded(board, 'X')){
            if(checkO != checkX) return 0;
        } 
        
        // 게임 규칙이 지켜짐.
        return 1;
    }
    
    private static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
    
 
    private static boolean isGameEnded(String[] board, char check) {
       
        for (int i = 0; i < 3; i++) {
            //가로 빙고
            if (board[i].charAt(0) == check && board[i].charAt(1) == check && board[i].charAt(2) == check) return true;
            //세로 빙고
            if (board[0].charAt(i) == check && board[1].charAt(i) == check && board[2].charAt(i) == check) return true;   
        }
        
        //대각선 빙고
        if (board[0].charAt(0) == check && board[1].charAt(1) == check && board[2].charAt(2) == check) return true;
        if (board[0].charAt(2) == check && board[1].charAt(1) == check && board[2].charAt(0) == check) return true;
        
        return false;
    }
}
