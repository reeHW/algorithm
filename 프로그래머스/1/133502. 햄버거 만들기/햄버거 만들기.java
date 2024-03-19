import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int ing : ingredient) {
            stack.push(ing);

            // 스택의 크기가 4 이상이면 햄버거 확인
            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1 && // 빵
                    stack.get(stack.size() - 3) == 2 && // 야채
                    stack.get(stack.size() - 2) == 3 && // 고기
                    stack.peek() == 1) {                // 빵
                    count++; // 햄버거 카운트 증가
                    stack.pop(); // 빵 제거
                    stack.pop(); // 고기 제거
                    stack.pop(); // 야채 제거
                    stack.pop(); // 빵 제거
                }
            }
        }

        return count;
    }
}
