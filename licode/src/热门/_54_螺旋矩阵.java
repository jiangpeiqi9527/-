package 热门;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int under = matrix.length - 1;
        int left = 0;
        List<Integer> result = new ArrayList<>();
        while (top <= under && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= under; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[under][i]);
            }
            under--;
            for (int i = under; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        _54_螺旋矩阵 test = new _54_螺旋矩阵();
        List<Integer> integers = test.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(integers);
    }
}
