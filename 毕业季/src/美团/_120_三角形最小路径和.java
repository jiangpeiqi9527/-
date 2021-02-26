package 美团;

import java.util.LinkedList;
import java.util.List;

public class _120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int size = triangle.size();
        int[][] dp = new int[size][size];
        int minStep = Integer.MAX_VALUE;

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                if (i == dp.length - 1) {
                    minStep = j == 0 ? dp[i][j] : Math.min(minStep, dp[i][j]);
                }
            }
        }
        return minStep;
    }
}
