package interview_question_12;

/**
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，
 * 则打印出1、2、3 一直到最大的3位数即999。
 */
public class Solution {

    /**
     * 回溯法
     * @param n
     */
    public static void printOneToNthDigits(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must large than zero");
        }
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    public static void printOneToNthDigits(int n, int[] arr) {
        if (n >= arr.length) {
            printArray(arr);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            arr[n] = i;
            printOneToNthDigits(n + 1, arr);
        }
    }

    private static void printArray(int[] arr) {
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        if (index < arr.length) {
            System.out.println();
        }
    }

    public static void printOneToNthDigits2(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must large than zero");
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
        while (!addOne(arr)) {
            printArray(arr);
        }
    }

    /**
     * 从数组的最后一位开始加1，如果大于9则需要进位，
     * 当数组中数都处理过之后如果还有进位，说明处理前的数字的最后一个数字了，如果n=1的话是9，n=2的话是99
     * @param arr
     * @return
     */
    private static boolean addOne(int[] arr) {
        int carry = 1;
        int len = arr.length;
        while (len > 0) {
            int temp = arr[len - 1] + carry;
            arr[len - 1] = temp % 10;
            carry = temp / 10;
            len--;
        }
        if (carry > 0 && len == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        printOneToNthDigits(4);
        System.out.println("======");
        printOneToNthDigits2(2);
    }
}
