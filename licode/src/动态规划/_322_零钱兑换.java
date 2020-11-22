package 动态规划;
/**
 *  https://leetcode-cn.com/problems/coin-change/
 */
public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return -1;
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin > amount) break;
            dp[coin] = 1;
        }
        int min = Integer.MAX_VALUE;
        return coin(amount,coins,dp,min);
    }

    private int coin(int amount, int[] coins, int[] dp,int min) {
        if (amount < 1) return Integer.MAX_VALUE;
        if (dp[amount] == 0) {

            for (int coin : coins) {
                min = Math.min(min,coin(amount - coin,coins,dp,min));
            }
        }
        return dp[amount];
    }
}
