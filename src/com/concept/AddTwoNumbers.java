package com.concept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode res = addTwoNumbers(l1, l2);

        while(res !=null){
            System.out.print(res.val+"-->");
            res = res.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode res = result;
        int carry =0;
        while(l1 !=null || l2 != null || carry !=0)
        {
            int val1 = l1 !=null ? l1.val:0;
            int val2 = l2 !=null ?l2.val:0;
            int sum = val1+val2+carry;
            carry = sum/10;
            result.next = new ListNode(sum%10);
            if(l1 !=null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;
            result = result.next;
        }
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
}
