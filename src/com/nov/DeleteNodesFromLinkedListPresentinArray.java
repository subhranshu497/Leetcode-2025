package com.nov;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentinArray {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int [] nums = {1,2,3};
        ListNode res = modifiedList(head, nums);

        while (res !=null){
            System.out.print(res.val+", ");
            res = res.next;
        }
    }

    private static ListNode modifiedList(ListNode head, int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        ListNode res = new ListNode();
        ListNode finalRes = res;
        while (head !=null ){
            if(!set.contains(head.val)){
                res.next = new ListNode(head.val);
                res = res.next;
            }
            head = head.next;
        }
        return finalRes.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
    ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
 }

