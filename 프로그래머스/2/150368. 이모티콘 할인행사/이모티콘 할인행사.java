class Solution {
    private static final int[] DISCOUNTS = {10, 20, 30, 40}; // 할인율
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2]; 
        gaolFinder(users, emoticons, new int[emoticons.length], 0, answer);
        return answer;
    }
    private void gaolFinder(int[][] users, int[] emoticons, int[] discounts, int index, int[] answer) {
        if (index == emoticons.length) {
            int[] result = calculate(users, emoticons, discounts);
            // 더 좋은 결과라면 업데이트
            if (result[0] > answer[0] || (result[0] == answer[0] && result[1] > answer[1])) {
                answer[0] = result[0];
                answer[1] = result[1];
            }
            return;
        }
        for (int discount : DISCOUNTS) {
            discounts[index] = discount;
            gaolFinder(users, emoticons, discounts, index + 1, answer);
        }
    }

    private int[] calculate(int[][] users, int[] emoticons, int[] discounts) {
        int joinCount = 0; // 이모티콘 플러스 서비스 가입자 수
        int sales = 0; // 이모티콘 판매액
        for (int[] user : users) {
            int minDiscount = user[0]; // 사용자가 구매할 최소 할인율
            int threshold = user[1]; // 이모티콘 구매를 취소하고 이모티콘 플러스에 가입하는 금액
            int totalSales = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= minDiscount) {
                    totalSales += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }
            if (totalSales >= threshold) {
                joinCount++;
            } else {
                sales += totalSales;
            }
        }
        return new int[]{joinCount, sales};
    }
}