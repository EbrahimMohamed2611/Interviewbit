package com.interviewbit.amazone.linkedList;

public class RemoveNthNodeFromListEnd {

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode current = A;
        ListNode prev = A;
        for (int i = 0; i <= B; i++) {
            if (current == null)
                break;
            current = current.next;
        }
        if (current == null) {
            ListNode temp = A;
            A = A.next;
            temp.next = null;
            return A;
        }
        while (current != null) {
            prev = prev.next;
            current = current.next;
        }

        ListNode toBeRemoved = prev.next;
        prev.next = prev.next.next;
        toBeRemoved.next = null;
        return A;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = new ListNode(20);
        ListNode listNode1 = removeNthFromEnd(listNode, 3);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
