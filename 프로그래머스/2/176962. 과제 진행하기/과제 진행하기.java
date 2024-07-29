import java.util.*;

public class Solution {
    public String[] solution(String[][] plans) {
        // 과제 계획을 시작 시간 순으로 정렬
        Arrays.sort(plans, (a, b) -> timeToMinutes(a[1]) - timeToMinutes(b[1]));

        Stack<String[]> pausedTasks = new Stack<>();
        List<String> completedTasks = new ArrayList<>();
        int currentTime = 0;

        for (String[] plan : plans) {
            String taskName = plan[0];
            int startTime = timeToMinutes(plan[1]);
            int playTime = Integer.parseInt(plan[2]);

            // 진행 중인 과제가 있을 경우
            while (!pausedTasks.isEmpty() && currentTime < startTime) {
                String[] pausedTask = pausedTasks.pop();
                int remainingTime = Integer.parseInt(pausedTask[2]);
                int availableTime = startTime - currentTime;

                if (remainingTime <= availableTime) {
                    currentTime += remainingTime;
                    completedTasks.add(pausedTask[0]);
                } else {
                    remainingTime -= availableTime;
                    pausedTask[2] = Integer.toString(remainingTime);
                    pausedTasks.push(pausedTask);
                    currentTime = startTime;
                }
            }

            // 새로운 과제를 시작해야 하는 시점
            currentTime = startTime;
            pausedTasks.push(new String[]{taskName, plan[1], Integer.toString(playTime)});
        }

        // 남아 있는 과제들을 처리
        while (!pausedTasks.isEmpty()) {
            String[] pausedTask = pausedTasks.pop();
            completedTasks.add(pausedTask[0]);
        }

        return completedTasks.toArray(new String[0]);
    }

    // "hh:mm" 형식의 시간을 분으로 변환
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}