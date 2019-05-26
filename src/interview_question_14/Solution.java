package interview_question_14;

public class Solution {

    public static void reOrderArray(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int oddCount = 0;
        int oddBegin = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddCount++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                newArray[oddBegin++] = array[i];
            } else {
                newArray[oddCount++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }

    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reOrderArray(array);
        printArray(array);
    }
}
