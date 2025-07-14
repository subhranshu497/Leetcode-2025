package com.july;

public class ConvertBinaryNumberinaLinkedListtoInteger {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        int num = getDecimalValue(head);
        System.out.println(num);
    }

    private static int getDecimalValue(ListNode head) {
        int num =0;
        while(head != null){
            num = (2*num)+head.val;
            head = head.next;
        }
        return num;
    }

}
class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}