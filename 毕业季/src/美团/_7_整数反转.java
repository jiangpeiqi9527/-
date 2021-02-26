package 美团;

public class _7_整数反转 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int cur = x % 10;
            res = (res + cur) * 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) (res / 10);
    }
}
