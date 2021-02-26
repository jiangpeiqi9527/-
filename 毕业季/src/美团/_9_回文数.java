package 美团;

public class _9_回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int n = 0;
        while (temp != 0) {
            int a = temp % 10;
            n = n * 10 + a;
            temp /= 10;
        }
        return x == n;
    }
}
