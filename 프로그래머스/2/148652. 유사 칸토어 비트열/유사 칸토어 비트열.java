class Solution {
    public int solution(int n, long l, long r) {
        return countOnes(n, l, r);
    }

    private int countOnes(int n, long start, long end) {
        if (n == 0) {
            return (start == 1 && end == 1) ? 1 : 0;
        }

        long lengthOfPrevious = (long) Math.pow(5, n - 1);
        int count = 0;

        for (int i = 0; i < 5; i++) {
            long segmentStart = i * lengthOfPrevious + 1;
            long segmentEnd = (i + 1) * lengthOfPrevious;

            if (segmentStart > end || segmentEnd < start) {
                continue;
            }

            if (segmentStart >= start && segmentEnd <= end) {
                if (i == 2) {
                    continue; // The middle segment is always 0
                }
                count += countOnes(n - 1, 1, lengthOfPrevious);
            } else {
                long partialStart = Math.max(start, segmentStart) - segmentStart + 1;
                long partialEnd = Math.min(end, segmentEnd) - segmentStart + 1;
                if (i != 2) {
                    count += countOnes(n - 1, partialStart, partialEnd);
                }
            }
        }

        return count;
    }
}