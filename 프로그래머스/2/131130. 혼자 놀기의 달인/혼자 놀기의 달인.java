import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int solution(int[] cards) {
        List<Integer> openedList = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            int count = 0;
            while (true) {
                if (cards[i] != 0) {
                    int temp = cards[i];
                    // 열어본 카드의 값을 0으로 바꿈.
                    cards[i] = 0;
                    i = temp - 1;
                    count++;
                } else {
                    openedList.add(count);
                    break;
                }
            }
        }
        
        Collections.sort(openedList, Collections.reverseOrder());
        
        return openedList.size() > 1 ? openedList.get(0) * openedList.get(1) : 0;

    }
       
}