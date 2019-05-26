package interview_question_11;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution {

    public static double Power(double base, int exponent) {
        double res = 1.0;
        int n = exponent;
        if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            n = -exponent;
        } else if (exponent == 0) {
            return 1;
        }
        while (n != 0) {
            System.out.printf("n = %d , res = %f, base = %f\n", n, res, base);
            if ((n & 1) == 1) {
                res *= base;
            }
            base *= base;
            n >>= 1;
        }
        return exponent > 0 ? res : 1 / res;
    }

    public static void main(String[] args) {
        System.out.println(Power(2.0, 5));
        System.out.println(Power(2.0, -5));
        System.out.println(Power(-2.0, 5));
        System.out.println(Power(-2.0, -5));
        System.out.println(Power(0.0, 5));
        System.out.println(Power(0.0, -5));
    }
}
