class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"1", "2", "4"};
        //n을 3으로 나누었을 때 나머지가 0 일 경우 4로 치환
         while (n > 0) {
            n--; 
            int remainder = n % 3;
            sb.insert(0, numbers[remainder]);
            n /= 3;
        }
        
        return sb.toString();
    }
}