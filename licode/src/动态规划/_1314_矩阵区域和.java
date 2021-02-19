package 动态规划;

public class _1314_矩阵区域和 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                ans[0][0] += mat[i][j];
            }
        }
        return ans;
    }
}
