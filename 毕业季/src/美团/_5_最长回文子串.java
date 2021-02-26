package 美团;

public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[arr.length + 1][arr.length + 1];
        int begin = 0;
        int end = 0;
        int maxLex = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[0].length; j++) {
                if ((j - i + 1) < 3) {
                    dp[i][j] = arr[i] == arr[j] ? true : false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] ? arr[i] == arr[j]
                            : false;
                }
                if (dp[i][j]) {
                    if (maxLex < j - i + 1) {
                        maxLex = j - i + 1;
                        begin = i;
                        end = j;
                    } else {

                    }
                }
            }
        }
        return s.substring(begin, end);
    }
}
