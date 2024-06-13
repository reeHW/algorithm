import java.util.*;

class Solution {

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> data = processInfo(info);

        List<Integer> results = processQueries(data, query);

        return results.stream().mapToInt(i -> i).toArray();
    }

    private Map<String, List<Integer>> processInfo(String[] info) {
        Map<String, List<Integer>> data = new HashMap<>();

        for (String entry : info) {
            String[] parts = entry.split(" ");

            String[] languages = {parts[0], "-"};
            String[] jobs = {parts[1], "-"};
            String[] experiences = {parts[2], "-"};
            String[] foods = {parts[3], "-"};
            int score = Integer.parseInt(parts[4]);

            for (String l : languages) {
                for (String j : jobs) {
                    for (String e : experiences) {
                        for (String f : foods) {
                            String key = l + " " + j + " " + e + " " + f;
                            //같은 경우의 수 -> 원래 있던 value데이터에 새로운 score 추가
                            data.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                        }
                    }
                }
            }
        }

        for (List<Integer> scores : data.values()) {
            Collections.sort(scores);
        }

        return data;
    }

    private List<Integer> processQueries(Map<String, List<Integer>> data, String[] query) {
        List<Integer> results = new ArrayList<>();

        for (String q : query) {
            String[] parts = q.replace(" and", "").split(" ");
            String key = parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3];
            int score = Integer.parseInt(parts[4]);

            if (data.containsKey(key)) {
                List<Integer> scores = data.get(key);
                int count = countScores(scores, score);
                results.add(count);
            } else {
                results.add(0);
            }
        }

        return results;
    }

    //정렬된 점수를 인덱스의 중간지점부터 확인하여 어떤 지점이 queryScore 값 이상이 나올 때까지 탐색
    private int countScores(List<Integer> scores, int queryScore) {
       int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < queryScore) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return scores.size() - left;
    }
}