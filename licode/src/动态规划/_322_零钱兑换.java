package 动态规划;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _322_零钱兑换 {
    //    public int coinChange(int[] coins, int amount) {
//        if (amount < 1) return -1;
//        int[] dp = new int[amount + 1];
//        for (int coin : coins) {
//            if (coin > amount) break;
//            dp[coin] = 1;
//        }
//        int min = Integer.MAX_VALUE;
//        return coin(amount,coins,dp,min);
//    }
//
//    private int coin(int amount, int[] coins, int[] dp,int min) {
//        if (amount < 1) return Integer.MAX_VALUE;
//        if (dp[amount] == 0) {
//
//            for (int coin : coins) {
//                min = Math.min(min,coin(amount - coin,coins,dp,min));
//            }
//        }
//        return dp[amount];
//    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = minNum(dp,coins,i);
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private int minNum(int[] dp, int[] coins, int i) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = i - coin >=0 ? Math.min((dp[i - coin] == Integer.MAX_VALUE ? dp[i - coin] - 1 : dp[i - coin]) + 1,min)
                    : min;
        }
        return min;
    }

    public static void main(String[] args) {
        _322_零钱兑换 test = new _322_零钱兑换();
        test.coinChange(new int[]{2},3);
    }
}
