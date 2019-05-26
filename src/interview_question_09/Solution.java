package interview_question_09;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class Solution {

    public long Fibonacci(int n) {
        long first = 0;
        long second = 1;
        while (n > 0) {
            second += first;          //将第一个数和第二个数的和赋值给第二个数
            first = second - first;   //将之前的第二个数的值赋值给第一个数
            n--;
        }
        return first;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci(3));
        long begin = System.currentTimeMillis();
        System.out.println(solution.Fibonacci(39));
        System.out.println(System.currentTimeMillis() - begin);
    }
}
