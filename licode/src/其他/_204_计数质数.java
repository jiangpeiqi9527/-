package 其他;

import java.util.Arrays;

public class _204_计数质数 {
    public int countPrimes(int n) {
        boolean [] PrimeNumberList = new boolean[n+1];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(PrimeNumberList[i]){
                continue;
            }
            count++;
            for(int j = 2*i; j <= n; j+=i){
                PrimeNumberList[j] = true;
            }
        }
        return count;
    }
}
