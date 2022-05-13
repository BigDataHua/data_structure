package com.xiaohua.tixiclass.class07;

import com.xiaohua.tixiclass.ListNode;

/**
 * @author xiaohua
 * @create 2022-05-09 13:57
 */
public class leetcode143 {
    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        //反转链表
        ListNode myhead = new ListNode();
        ListNode q = head;
        while(q!=null){
            q = q.next;
            head.next = myhead.next;
            myhead.next = head;
            head = q;
        }
        return myhead.next;
    }

    public void reorderList(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        ListNode myhead = new ListNode();
        ListNode rear = myhead;

        ListNode work = head;

        //寻找中间节点断开
        while(q!=null){
            if(q.next==null||q.next.next==null){
                break;
            }
            q=q.next.next;
            p = p.next;
        }
        q = p.next;
        p.next = null;
        q =  reverse(q);
        p = head;

        while(q!=null&&p!=null){

                work = p.next;
                p.next = rear.next;
                rear.next = p;
                rear = p;
                p = work;


                work = q.next;
                q.next =rear.next;
                rear.next = q;
                rear = q;
                q = work;

        }
        rear.next = p;
        head = myhead.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new leetcode143().reorderList(head);

    }
}
