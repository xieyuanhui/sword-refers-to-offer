package interview_question_04;

public class ReplaceBlank {
    /**
     * 题目：
     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     *
     * 思路：
     * 在原字符串上替换时，如果从前往后替换后面的字符需要移动多次，时间复杂度是O(n^2)，所以需要优化
     * 可以从后往前替换，根据题意每碰到一个空格都会使字符串长度变长2，所以我们可以先计算替换后的字符长度，
     * 然后从后往前将字符串填入，遇到空格时则填%20
     */

    public static String replaceBlank(char[] string, int oldLength) {
        if (string == null || string.length < oldLength) {
            return null;
        }
        int blank = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                blank++;
            }
        }
        int newLength = blank * 2 + oldLength;
        if (newLength > string.length) {
            return null;
        }
        if (blank == 0) {
            return new String(string);
        }
        oldLength--;
        newLength--;
        while (oldLength >= 0 && oldLength < newLength) {
            if (string[oldLength] == ' ') {
                string[newLength--] = '0';
                string[newLength--] = '2';
                string[newLength--] = '%';
            } else {
                string[newLength--] = string[oldLength];
            }
            oldLength--;
        }
        return new String(string);
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';
        System.out.println(replaceBlank(string, 12));
    }
}
