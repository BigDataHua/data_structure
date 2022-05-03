package com.xiaohua.tixiclass.class05;

/**
 * @author xiaohua
 * @create 2022-05-01 12:43
 */
public class leetcode82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode p1 = head;
        ListNode q = null;
        ListNode rear = head;
        //寻找第一个不重复的节点

        int pre = Integer.MAX_VALUE;
        while(p1!=null&&(p1.val==p1.next.val||p1.val==pre)){
            pre=p1.val;
            p1 = p1.next;

        }
        //整条链表都是重复则p1为null
        if(p1==null){
            return p1;
        }
        head = p1;
        rear = head;
        while(true){
            while((p1!=null&&p1.next!=null)&&(p1.val==p1.next.val||p1.val==pre)){
                pre=p1.val;
                p1 = p1.next;
            }
            //p1等于null那么重复元素查找完毕
            if(p1==null){
                break;
            }
            pre = p1.val;
            q = p1;
            p1 =p1.next;
            q.next = rear.next;
            rear.next = q;
            rear = q;
        }

        rear.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(5))))))));
        ListNode listNode = deleteDuplicates(head);

    }
}
