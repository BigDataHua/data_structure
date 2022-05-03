package com.xiaohua.tixiclass.class05;

/**
 * @author xiaohua
 * @create 2022-05-01 15:22
 */
public class leetcode92 {
    public void reverse(ListNode head,ListNode rear){
        ListNode myhead = new ListNode();
        ListNode p = head;
        while(p!=null){
            p = p.next;
            head.next = myhead.next;
            myhead.next = head;
            head = p;
        }

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //排除特殊情况
        if(left==right||head==null||head.next==null){
            return head;
        }
        ListNode myhead = new ListNode();
        myhead.next = head;
        ListNode p = myhead;
        ListNode q = myhead;
        ListNode rp = myhead;
        ListNode rq = myhead;
        //p和q分别来到left和right的前一个
        for(int i = 1;i<=right;i++){
            if(i<left&&p!=null){
                p = p.next;
            }
            if(i<=right&&q!=null){
                q = q.next;
            }
        }
        rp = p.next;
        rq = q;
        q = q.next;
        rq.next = null;
        reverse(rp,rq);
        p.next = rq;
        rp.next = q;

        return myhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        leetcode92 lt = new leetcode92();

        lt.reverseBetween(head,2,4);


    }

}
