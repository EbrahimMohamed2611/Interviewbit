package com.interviewbit.amazone.linkedList;

public class MergeTwoSortedLists {


    class ListNode {
     public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }

    /**
     * Time O(Min(N,M))
     * Space O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode tail = root;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 == null)
            tail.next = list2;
        if(list2 == null)
            tail.next = list1;

        return root.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
}
