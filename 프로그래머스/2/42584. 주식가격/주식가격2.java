import java.util.LinkedList;
import java.util.Queue;
 
public class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
 
        for (int price : prices) {
            queue.add(price);
        }
 
        int index = 0;
        while (!queue.isEmpty()) {
            int curPrice = queue.poll();
            for (int i = (prices.length - queue.size()); i < prices.length; i++) {
                if (curPrice > prices[i]) {
                    answer[index]++;
                    break;
                }
                if (curPrice <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}
