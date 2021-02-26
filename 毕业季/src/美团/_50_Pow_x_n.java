package 美团;

public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double res = 1.0;
        if ((n & 1) == 0) {
            double temp = myPow(x, n >> 1);
            res = temp * temp;
        } else {
            double temp = myPow(x, n >> 1);
            res = temp * temp * x;
        }
        return res;
    }
}
