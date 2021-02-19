package 动态规划;

public class _647_回文子串 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        int count = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int i = s.length(); i >= 1; i--) {
            for (int j = i; j < dp.length; j++) {
                if (j - i <= 2) { // j 和 i中间只有0个或1个元素，只需判断首尾
                    if (s.charAt(j) == s.charAt(i)) {
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    if (s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
