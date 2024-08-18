import java.util.Stack;

public class Solution {

    public String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환
        if (p.isEmpty()) return p;

        // 2. 문자열을 두 균형잡힌 괄호 문자열 u, v로 분리
        int index = divideString(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        // 3. u가 올바른 괄호 문자열인지 확인
        if (isCorrect(u)) {
            // 3-1. v에 대해 재귀적으로 수행한 결과를 u에 이어 붙인 후 반환
            return u + solution(v);
        } else {
            // 4. u가 올바른 괄호 문자열이 아닌 경우
            StringBuilder answer = new StringBuilder();
            // 4-1. 빈 문자열에 '('를 붙임
            answer.append("(");
            // 4-2. v에 대해 재귀적으로 수행한 결과 문자열을 이어 붙임
            answer.append(solution(v));
            // 4-3. ')'를 다시 붙임
            answer.append(")");
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임
            String uTrimmed = u.substring(1, u.length() - 1);
            answer.append(reverse(uTrimmed));
            // 4-5. 생성된 문자열을 반환
            return answer.toString();
        }
    }

    // 균형잡힌 문자열을 나누는 함수
    private int divideString(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else count--;
            if (count == 0) return i + 1;
        }
        return p.length(); // 기본적으로 문자열 끝까지를 반환
    }

    // 올바른 괄호 문자열인지 확인
    private boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // 문자열의 괄호 방향을 뒤집는 함수
    private String reverse(String p) {
        StringBuilder reversed = new StringBuilder();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                reversed.append(')');
            } else {
                reversed.append('(');
            }
        }
        return reversed.toString();
    }
}
