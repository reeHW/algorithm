class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"1", "2", "4"};
        //3진법 변환을 기반으로 하고, 각 자리수의 3 대신 4를 사용하고 0 대신 4를 사용
         while (n > 0) {
            n--; 
            int remainder = n % 3;
            sb.insert(0, numbers[remainder]);
            n /= 3;
        }
        
        return sb.toString();
    }
}