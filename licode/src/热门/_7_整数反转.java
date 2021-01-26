package 热门;

public class _7_整数反转 {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 +  (x % 10);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) result;
    }
}
