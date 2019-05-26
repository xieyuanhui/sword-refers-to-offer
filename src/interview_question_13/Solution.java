package interview_question_13;

/**
 * 题目：
 * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点
 */
public class Solution {

    public static class ListNode {
        int value; // 保存链表的值
        ListNode next; // 下一个结点
    }

    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }
        if (head == toBeDeleted) {
            return head.next;
        }
        if (toBeDeleted.next == null) {
            ListNode tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            tmp.next = null;
        } else {
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.value = 12;

        head = deleteNode(head, head); // 删除头结点
        printList(head);
        head = deleteNode(head, last); // 删除尾结点
        printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);

        head = deleteNode(head, node); // 删除的结点不在链表中
        printList(head);
    }
}
