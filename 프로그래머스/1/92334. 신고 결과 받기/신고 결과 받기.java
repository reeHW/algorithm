import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedByMap = new HashMap<>();
        Map<String, Integer> mailCountMap = new HashMap<>();

        // 각 유저가 신고당한 횟수 및 신고한 유저 기록
        for (String r : report) {
            String[] splitReport = r.split(" ");
            String reporter = splitReport[0];
            String reported = splitReport[1];

            // 신고한 유저 기록
            Set<String> reporters = reportedByMap.get(reported);
            if (reporters == null) {
                reporters = new HashSet<>();
                reportedByMap.put(reported, reporters);
            }
            reporters.add(reporter);
        }

        // k번 이상 신고된 유저 확인 및 정지 처리
        for (Map.Entry<String, Set<String>> entry : reportedByMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                Set<String> reporters = entry.getValue();
                for (String reporter : reporters) {
                    mailCountMap.put(reporter, mailCountMap.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        // 결과 계산
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            result[i] = mailCountMap.getOrDefault(userId, 0);
        }

        return result;
    } 
}
