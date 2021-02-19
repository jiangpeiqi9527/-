package 数组;

public class _面试题_17_09_第k个数 {
    public int getKthMagicNumber(int k) {
        if (k == 0 || k == 1) return k;
        int index3 = 0;
        int index5 = 0;
        int index7 = 0;
        int[] res = new int[k];
        res[0] = 1;
        for (int i = 1; i < k; i++) {
            int num1 = res[index3] * 3;
            int num2 = res[index5] * 5;
            int num3 = res[index7] * 7;
            res[i] = Math.min(num1,Math.min(num2,num3));
            if (res[i] == num1) index3++;
            if (res[i] == num2) index5++;
            if (res[i] == num3) index7++;
        }
        return res[k - 1];
    }
}
