package 热门;

public class _剑指_Offer_62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        boolean[] numbers = new boolean[n];
        // 总共要删除 n - 1 次，删除 --> 把对应的索引设置为true
        int index = 0;
        while (n > 1) {
            int step = 3;
            while (step > 1) {
                index = (index + 1) % numbers.length;
                index = sureFalseOrToNextFalse(numbers,index);
                step--;
            }
            numbers[index] = true;
            index = (index + 1) % numbers.length;
            index = sureFalseOrToNextFalse(numbers,index);
            n--;
        }
        return index;
    }

    // 这个方法可以让index指针永远指向false
    private int sureFalseOrToNextFalse(boolean[] numbers, int index) {
        if (!numbers[index]) return index;
        while (numbers[index]) index = (index + 1) % numbers.length;
        return index;
    }

}
