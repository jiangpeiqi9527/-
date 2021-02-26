package 美团;

public class _59_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        if (n == 0) return null;
        int[][] res = new int[n][n];
        int maxValue = n * n;

        int i = 1;
        int up = 0;
        int left = 0;
        int down = n - 1;
        int right = n - 1;
        while (i <= maxValue) {
            for (int j = left; j <= right; j++) {
                res[up][j] = i;
                i++;
            }
            up++;
            if (i == maxValue) break;

            for (int j = up; j <= down; j++) {
                res[j][right] = i;
                i++;
            }
            right--;
            if (i == maxValue) break;

            for (int j = right; j >= left; j--) {
                res[down][j] = i;
                i++;
            }
            down--;
            if (i == maxValue) break;

            for (int j = down; j >= up; j--) {
                res[j][left] = i;
                i++;
            }
            left++;
            if (i == maxValue) break;
        }
        return res;
    }
}
