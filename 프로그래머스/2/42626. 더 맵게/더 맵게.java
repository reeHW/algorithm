import java.util.PriorityQueue;
class Solution {
        static int solution(int[] scoville, int k) {

        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : scoville) {
            heap.add(i);
        }

        while (!heap.isEmpty() && heap.peek() < k) {
            int min1 = heap.poll();

            if(!heap.isEmpty()){
                int min2 = heap.poll();
                heap.add(min1+min2*2);
                answer++;
            } else {
                return -1;
            }
           
        }

        return answer;
    }
}
