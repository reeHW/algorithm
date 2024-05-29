/*
0번째 1
1번째 11011
2번째 11011 / 11011 / 00000 / 11011 / 11011 
length : 25 segmentEnd : 11 segmentEnd : 15   (25/5)*2+1

3번째 11011 11011 00000 11011 11011 / 11011 11011 00000 11011 11011 / 00000  00000  00000  00000  00000 / 11011 11011 00000 11011 11011 / 11011 11011 00000 11011 11011
length 125 segmentEnd : 51 segmentEnd : 80    (125/5)*2+1 

-> n번째 비트열의 길이는: 5^n

n=1 11011
n=2 4/4/0/4/4  
n=3 16/16/0/16/16
n=4 64/64/0/64/64
...
-> n번째 비트열의 1의 개수는 4^(n-1)

n=3
l=10, r = 18  
-> 16/16/0/16/16
*/
class Solution {
    public int solution(int n, long l, long r) {
        return countOnes(n, 1, (long) Math.pow(5, n), l, r);
    }

    private static int countOnes(int n, long start, long end, long l, long r) {
        long length = (long) Math.pow(5, n - 1);

        int[] bitOnesCount = new int[] {
            (int) Math.pow(4, n - 1),
            (int) Math.pow(4, n - 1),
            0,
            (int) Math.pow(4, n - 1),
            (int) Math.pow(4, n - 1)
        };

        int totalOnes = 0;
        for (int i = 0; i < 5; i++) {
            
            long segmentStart = start + i * length;
            long segmentEnd = segmentStart + length - 1;
          
            System.out.println("segmentStart: " + segmentStart);
            System.out.println("segmentEnd: " + segmentEnd);
            //System.out.println("length: " + length);
            //System.out.println("length/5 + 1: " + length/5 + 1);

            if (segmentEnd < l || segmentStart > r) {
                System.out.println("Skipped");
                continue;
            }

            if (l <= segmentStart && segmentEnd <= r) {
                System.out.println("Entirely Inside");
                totalOnes += bitOnesCount[i];
            } else {
                System.out.println("Partially Inside");
                 if (i == 2) {
                    System.out.println("Skipping middle segment");
                    continue;
                }
                totalOnes += countOnes(n - 1, segmentStart, segmentEnd, l, r);
            }
        }

        return totalOnes;
    }
}