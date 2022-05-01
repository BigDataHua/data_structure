package com.xiaohua.tixiclass.class05;

/**
 * @author xiaohua
 * @create 2022-05-01 12:22
 */
public class leetcode141 {
    public static boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        if(head==null||head.next ==null){
            return false;
        }
        while(p1!=p2){
            //保证不会空指针
            if(p2==null||p2.next==null||p2.next.next==null){
                return false;
            }
            p2 = p2.next.next;
            p1 = p1.next;

        }
        return true;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,new ListNode(6)));
        boolean cycle = hasCycle(head);
        System.out.println(cycle);
    }

}
