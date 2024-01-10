class Solution {
    public int[] solution(int[] prices) {
        /* 현재 시점의 가격을 유지한 기간. */
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                answer[i]++;
                if (prices[i] > prices[j]) break;
            }
        }
        
        return answer;
    }
}