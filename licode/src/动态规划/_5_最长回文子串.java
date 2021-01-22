package 动态规划;

public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return s;
        boolean[][] dp = new boolean[chars.length][chars.length];
        int begin = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if ((j - i + 1) <= 2) { // 长度小于等于2只需要判断首尾是否相等即可
                    dp[i][j] = chars[i] == chars[j] ? true : false;
                    if (dp[i][j] && maxLen < (j - i + 1)) {
                        maxLen = j - i + 1;
                        begin = i;
                        end = j;
                    }
                } else { // 长度大于2，只需要判断dp[i + 1][j - 1]是否是回文串，
                    // 然后判断chars[i]与chars[j]是否相等（首尾是否相等)即可
                    if (dp[i + 1][j - 1]) {
                        dp[i][j] = chars[i] == chars[j] ? true : false;
                        if (dp[i][j] && maxLen < (j - i + 1)) {
                            maxLen = j - i + 1;
                            begin = i;
                            end = j;
                        }
                    }
                }
            }
        }
        return s.substring(begin,end + 1);
    }


}
