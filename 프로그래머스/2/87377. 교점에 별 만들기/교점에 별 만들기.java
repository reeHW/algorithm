import java.util.*;

public class Solution {
    public String[] solution(int[][] line) {
        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] intersection = findIntersection(line[i], line[j]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        if (points.isEmpty()) {
            return new String[0];
        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }

        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        
        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = '.';
            }
        }

        for (int[] p : points) {
            grid[maxY - p[1]][p[0] - minX] = '*';
        }

        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++) {
                sb.append(grid[i][j]);
            }
            result[i] = sb.toString();
        }

        return result;
    }

    private int[] findIntersection(int[] line1, int[] line2) {
        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];
        long denominator = A * D - B * C;

        // 평행하거나 일치
        if (denominator == 0) {
            return null;
        }

        long xNumerator = B * F - E * D;
        long yNumerator = E * C - A * F;
        
        // 정수가 아닌 경우
        if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
            return null;
        }

        int x = (int) (xNumerator / denominator);
        int y = (int) (yNumerator / denominator);

        return new int[]{x, y};
    }
}