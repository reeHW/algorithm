/*
0번째 1
n=1 11011
n=2 11011 / 11011 / 00000 / 11011 / 11011 
n=3 11011 11011 00000 11011 11011 / 11011 11011 00000 11011 11011 / 00000  00000  00000  00000 00000 / 11011 11011 00000 11011 11011 / 11011 11011 00000 11011 11011

-> n번째 비트열의 길이는: 5^n

n=1 11011
n=2 4/4/0/4/4  
n=3 16/16/0/16/16
```
-> n번째 비트열의 1의 개수는 4^(n-1)

*/
class Solution {
    public int solution(int n, long l, long r) {
        return countOnes(n, 1, (long) Math.pow(5, n), l, r);
    }

    private static int countOnes(int n, long start, long end, long l, long r) {
        
        long length = (long) Math.pow(5, n - 1);
        int bitOneCount = (int) Math.pow(4, n - 1);
        int totalOnes = 0;
        
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            
            long segmentStart = start + i * length;
            long segmentEnd = segmentStart + length - 1;
            
            if (segmentEnd < l || segmentStart > r) {
                continue;
            }

            if (l <= segmentStart && segmentEnd <= r) {
                totalOnes += bitOneCount;
            } else {
                totalOnes += countOnes(n - 1, segmentStart, segmentEnd, l, r);
            }
        }
        
        return totalOnes;
    }
}