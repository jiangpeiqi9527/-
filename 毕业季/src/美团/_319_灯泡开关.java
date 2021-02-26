package 美团;

public class _319_灯泡开关 {
    public int bulbSwitch(int n) {
        if (n < 2) return n;
        boolean[] flash = new boolean[n + 1];
        for (int i = 0; i < flash.length; i++) {
            flash[i] = true;
        }

        int i = 2;
        while (i <= n) {
            for (int j = 1; j < flash.length; j++) {
                if (j % i == 0) {
                    flash[j] = !flash[j];
                }
            }
            i++;
        }

        int count = 0;
        for (int j = 1; j < flash.length; j++) {
            if (flash[j]) count++;
        }

        return count;
    }
}
