package com.jxz.sort;

public class QuickSort<E extends Comparable<E>> extends Sort<E>  {
    @Override
    protected void sort() {
        sort(0,array.length);
    }


    /**
     * 对 [begin,end) 范围内的元素进行快速排序
     * @param begin
     * @param end
     */
    private void sort (int begin, int end) {
        if (end - begin < 2) return;

        // 确定轴点元素
        int mid = pivotIndex(begin,end);
        // 对子序列进行快速排序
        sort(begin,mid);
        sort(mid + 1,end);
    }

    /**
     * 构造出 [begin,end) 范围的轴点元素
     * @param begin
     * @param end
     * @return 轴点元素的最终位置
     */
    private int pivotIndex (int begin, int end) {
        // 备份begin位置上的元素
        E pivot = array[begin];

        // end指向最后一个元素
        end--;

        while (begin < end) {

            //    <--
            while (begin < end) {
                if (cmp(pivot,array[end]) < 0) {
                    end--;
                } else {
                    array[begin++]=array[end];
                    break;
                }
            }

            // -->
            while (begin < end) {
                if (cmp(pivot,array[begin]) > 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        // 将轴点元素放入最终位置
        array[begin] = pivot;
        // 返回轴点元素的位置
        return begin;
    }
}
