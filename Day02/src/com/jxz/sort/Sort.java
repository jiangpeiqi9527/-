package com.jxz.sort;

import java.text.DecimalFormat;

public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>> {
    protected E[] array;
    private int cmpCount;
    private int swapCount;
    private Long time;

    public Long getTime() {
        return time;
    }

    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort (E[] array) {
        if (array == null || array.length < 2) return;
        this.array = array;
        Long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    protected abstract void sort();

    /**
     * 返回值大于0，则 i1 > i2
     * 返回值等于0，则 i1 = i2
     * 返回值小于0，则 i1 < i2
     * @param i1
     * @param i2
     * @return
     */
    protected int cmp (int i1, int i2) {
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }

    protected int cmp (E v1, E v2) {
        cmpCount++;
        return v1.compareTo(v2);
    }

    protected void swap (int i1, int i2) {
        swapCount++;
        E temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    @Override
    public int compareTo(Sort<E> o) {
        int result = (int)(time - o.time);
        if (result != 0) return result;

        result = cmpCount - o.cmpCount;
        if (result != 0) return result;

        return swapCount - o.swapCount;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        return "【" + getClass().getSimpleName() + "】\n"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";

    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }
}
