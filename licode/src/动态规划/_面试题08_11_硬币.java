package 动态规划;

public class _面试题08_11_硬币 {
    private static final int mo = 1000000007;
    private int[] coins = {1,5,10,25};
    // 看似没有问题，但是是错误的：because：但是事实却是 6 的情况只有两种，
    // （1，1，1，1，1，1）和（1，5）。这里是把（1，5）和（5，1）
    // 前后顺序不同的情况重复算了 1 次。因此我们应该去考虑硬币顺序带来的影响。
//    public int waysToChange(int n) {
//        if (n <= 0) return 0;
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        for (int i = 1; i < dp.length; i++) {
//           int count = 0;
//           for (int coin : coins) {
//               if (i - coin < 0) break;
//               count = (count + dp[i - coin]) % mo;
//           }
//           dp[i] = count;
//        }
//        return dp[n];
//    }

    // 改进后
    public int waysToChange(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
