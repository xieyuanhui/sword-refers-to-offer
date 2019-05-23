package interview_question_03;

public class FindNum {
    /**
     * 题目：
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 思路：
     * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
     * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
     * 查找的范围，直到找到要查找的数字，或者查找范围为空。
     */

    public static boolean findNum(int[][] matrix, int number) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row >= 0 && row < rows && column >= 0 && column < columns) {
            if (matrix[row][column] == number) {
                return true;
            } else if (matrix[row][column] > number) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(findNum(matrix, 7));    // 要查找的数在数组中
        System.out.println(findNum(matrix, 5));    // 要查找的数不在数组中
        System.out.println(findNum(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println(findNum(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println(findNum(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println(findNum(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println(findNum(null, 16));     // 健壮性测试，输入空指针
    }
}
