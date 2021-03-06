package chapter2;

import java.util.Stack;

import ctciLibrary.ListNode;

/**
 * @author yongrong
 * 请编写一个函数，检查链表是否为回文。给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 */
public class Question2_7 {
    /**
     * 使用两个指针slow和fast，slow一次一步，fast一次两步，在fast到尾结点之前slow所遇到的所有结点压入堆栈，
     * 之后slow继续往后遇到的每个结点和堆栈中结点对比，都相同则返回true
     * @param pHead 头结点
     * @return 链表是否为回文
     */
    public static boolean isPalindrome(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        while (slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.val)
                return false;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 11;
        ListNode[] nodes = new ListNode[length];
        for (int i = 0; i < length; i++)
            nodes[i] = new ListNode(i < length / 2 ? i : length - 1 - i);
        ListNode head = ListNode.buildList(nodes, length);
        System.out.println(head.printForward());
        System.out.println("Is palindrome? " + (isPalindrome(nodes[0]) ? "yes" : "no"));
    }

}
