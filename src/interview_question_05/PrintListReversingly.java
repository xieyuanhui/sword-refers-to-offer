package interview_question_05;

import java.util.Stack;

public class PrintListReversingly {
    /**
     * 题目：
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     *
     * 思路：
     * 1.使用栈存储所有节点，再遍历栈输出 2.栈的本质是递归，直接使用递归
     */

    public static class ListNode {
        int val;
        ListNode next;
    }

    public static void printListInversinglyWithStack(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
        System.out.println("\n------------------------------");
    }

    public static void printListInversinglyRecursive(ListNode root) {
        if (root != null) {
            printListInversinglyRecursive(root.next);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

        printListInversinglyWithStack(root);
        printListInversinglyRecursive(root);
    }
}
