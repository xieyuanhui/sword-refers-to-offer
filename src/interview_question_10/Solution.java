package interview_question_10;

/**
 * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
 */
public class Solution {

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(5));
        System.out.println(NumberOf1(0));
        System.out.println(NumberOf1(-10));
        System.out.println(Integer.toBinaryString(-5));
    }

}
