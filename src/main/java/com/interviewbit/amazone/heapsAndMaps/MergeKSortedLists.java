package com.interviewbit.amazone.heapsAndMaps;

import com.interviewbit.amazone.linkedList.ListNode;

import java.util.*;

public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((list1, list2) -> list1.val - list2.val);

        for (ListNode node : lists)
            if (node != null)
                minHeap.add(node);

        ListNode head = null, tail = null;

        while (!minHeap.isEmpty()) {
            ListNode minElement = minHeap.poll();
            if (head == null)
                head = tail = minElement;
            else {
                tail.next = minElement;
                tail = tail.next;
            }


            if (minElement.next != null)
                minHeap.add(minElement.next);
        }

        return head;
    }
}
