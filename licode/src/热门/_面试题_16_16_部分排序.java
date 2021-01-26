package 热门;

public class _面试题_16_16_部分排序 {
    public int[] subSort(int[] array) {
        // 先从左往右扫描最后一个逆序对

        int max = Integer.MIN_VALUE;
        int right = 0; // 记录逆序对的索引
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max,array[i]);
            if (array[i] < max) {
                right = i;
            }
        }
        // 再从右往左扫描最后一个逆序对
        int min = Integer.MAX_VALUE;
        int left = array.length - 1; // 记录逆序对的索引
        for (int i = array.length - 1; i >= 0; i++) {
            min = Math.min(min,array[i]);
            if (array[i] > min) {
                left = i;
            }
        }
        return (right == 0 || left == array.length - 1) ? new int[]{-1,-1} : new int[]{left,right};
    }
}
