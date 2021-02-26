package 美团;

public class _557_反转字符串中的单词III {

    public static void main(String[] args) {
        _557_反转字符串中的单词III o = new _557_反转字符串中的单词III();
        System.out.println(o.reverseWords("Let's take"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < arr.length) {
            while (rightIndex < arr.length) {
                if (arr[rightIndex] == ' ') break;
                rightIndex++;
            }
            // 此时rightIndex指向空格
            int spaceIndex = rightIndex;
            rightIndex--;
            while (leftIndex < rightIndex) {
                char temp = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = temp;
                leftIndex++;
                rightIndex--;
            }

            if (spaceIndex > arr.length - 1) break;
            leftIndex = spaceIndex + 1;
            rightIndex = spaceIndex + 1;
        }

        return new String(arr);
    }
}
