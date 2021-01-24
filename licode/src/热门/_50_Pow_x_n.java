package 热门;

public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double result = 1.0;
        if ((n & 1) == 0) {
            double temp = myPow(x,n >> 1);
        x = n < 0 ? (1 / x) : x;
            result = temp * temp;
        } else {
            double temp = myPow(x,n >> 1);
        x = n < 0 ? (1 / x) : x;
            result = temp * temp * x;
        }
        return result;
    }

    public static void main(String[] args) {
        _50_Pow_x_n test = new _50_Pow_x_n();
        test.myPow(2.0,-2);
    }
}
