import java.util.*;

class Solution {

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> data = preprocessInfo(info);

        List<Integer> results = processQueries(data, query);

        return results.stream().mapToInt(i -> i).toArray();
    }

    private Map<String, List<Integer>> preprocessInfo(String[] info) {
        Map<String, List<Integer>> data = new HashMap<>();

        for (String entry : info) {
            String[] parts = entry.split(" ");
            String language = parts[0];
            String job = parts[1];
            String experience = parts[2];
            String food = parts[3];
            int score = Integer.parseInt(parts[4]);

            String[] languages = {language, "-"};
            String[] jobs = {job, "-"};
            String[] experiences = {experience, "-"};
            String[] foods = {food, "-"};

            for (String l : languages) {
                for (String j : jobs) {
                    for (String e : experiences) {
                        for (String f : foods) {
                            String key = l + " " + j + " " + e + " " + f;
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

    private int countScores(List<Integer> scores, int threshold) {
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return scores.size() - left;
    }
}