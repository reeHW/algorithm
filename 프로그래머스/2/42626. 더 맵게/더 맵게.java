import java.util.PriorityQueue;
class Solution {
        static int solution(int[] scoville, int k) {

        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : scoville) {
            heap.add(i);
        }

        while (heap.peek() < k) {
            int min1 = heap.poll();
            int min2 = heap.poll();

            int mixedScoville = min1 + min2 * 2;
            heap.add(mixedScoville);

            answer++;

            if (heap.peek() >= k) break;
            if (heap.size() == 1 && heap.peek() < k) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}