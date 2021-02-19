package DFS练习;

public class _面试题_08_10_颜色填充 {
    private int[][] arr = null;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        arr = image;
        return helper(image[sr][sc], sr, sc, newColor);
    }

    private int[][] helper(int i, int sr, int sc, int newColor) {
        if (sr >= 0 && sr < arr.length && sc >= 0 && sc < arr[0].length && arr[sr][sc] == i && i != newColor) {
            arr[sr][sc] = newColor;
            helper(i, sr + 1, sc, newColor);
            helper(i, sr - 1, sc, newColor);
            helper(i, sr, sc + 1, newColor);
            helper(i, sr, sc - 1, newColor);
        }
        return arr;
    }
}
