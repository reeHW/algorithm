class Solution {

    public static int solution(int n) {
        int prevPrev = 0;
        int prev = 1;
        int fibo = 0;
        
        for (int i = 2; i <= n; i++) {
            fibo = (prevPrev + prev) % 1234567;
            prevPrev = prev;
            prev = fibo;
        }

        return fibo;
    }

}