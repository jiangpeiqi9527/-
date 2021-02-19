package 数组;

public class _剑指_Offer_49_丑数 {
    public int nthUglyNumber(int n) {
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] urglyNum = new int[n];
        urglyNum[0] = 1;
        for (int i = 1; i < n; i++) {
            int num1 = urglyNum[index2] * 2;
            int num2 = urglyNum[index3] * 3;
            int num3 = urglyNum[index5] * 5;
            urglyNum[i] = Math.min(num1,Math.min(num2,num3));
            if (urglyNum[i] == num1) index2++;
            if (urglyNum[i] == num2) index3++;
            if (urglyNum[i] == num3) index5++;
        }
        return urglyNum[n - 1];
    }
}
