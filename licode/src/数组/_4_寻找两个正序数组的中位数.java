package 数组;

public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两个数组
        int[] newArr = new int[nums1.length + nums2.length];
        int newArrLen = newArr.length;
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index < newArrLen && index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                newArr[index++] = nums1[index1++];
            } else {
                newArr[index++] = nums2[index2++];
            }
        }
        if (index != newArrLen) {
            if (index1 != nums1.length) {
                while (index1 < nums1.length) {
                    newArr[index++] = nums1[index1++];
                }
            } else {
                while (index2 < nums2.length) {
                    newArr[index++] = nums2[index2++];
                }
            }
        }
        int totalNum = nums1.length + nums2.length;
        if (totalNum < 2) return totalNum == 0 ? 0 : newArr[0];
        if ((totalNum & 1) == 0) { // 是偶数
            double n1 = newArr[(totalNum >> 1)];
            double n2 = newArr[(totalNum >> 1) - 1];
            double res = (n1 + n2) / 2.0;
            return res;
        } else { // 是奇数
            return newArr[(totalNum >> 1)];
        }
    }

    public static void main(String[] args) {
        _4_寻找两个正序数组的中位数 o = new _4_寻找两个正序数组的中位数();
        double medianSortedArrays = o.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }
}
