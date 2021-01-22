package 动态规划;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxlirui = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
                continue;
            }
            maxlirui = Math.max(maxlirui, prices[i] - min);
        }
        return maxlirui;
    }

    public int shiyongdongtaiguihua(int[] prices) {
        if (prices.length == 0) return 0;
        if (prices.length == 1) return 0;
        int[] chajia = new int[prices.length - 1];
        for (int i = 0; i < chajia.length; i++) {
            chajia[i] = prices[i + 1] - prices[i];
        }
        int max = chajia[0];
        for (int i = 1; i < chajia.length; i++) {
            if (chajia[i - 1] <= 0) {

            } else {
                chajia[i] += chajia[i - 1];
            }
            max = Math.max(max, chajia[i]);
        }
        return max > 0 ? max : 0;
    }
}
