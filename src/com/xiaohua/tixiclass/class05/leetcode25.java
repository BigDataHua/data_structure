package com.xiaohua.tixiclass.class05;

/**
 * K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author xiaohua
 * @create 2022-04-29 17:40
 */
public class leetcode25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode myhead = new ListNode();
        ListNode p1 = head;//工作指针1
        ListNode q1 = head;//工作指针1
        ListNode p2 = head;//工作指针2
        ListNode rear = myhead;//工作指针3记录返回链表尾部
        while (p2!=null){
            int i = 0;
            //每次遍历k个
            ListNode myrear = p1;//工作指针3记录尾部
            for (; i < k - 1&&p2!=null; i++) {
                p2=p2.next;
            }
            if (p2==null){
                //剩余单元格不够了,剩余的直接放在最后，然后退出吧
                rear.next=p1;
                break;
            }
            p2=p2.next;
            while (p1!=p2){
                q1 = p1.next;
                p1.next=rear.next;
                rear.next=p1;
                p1=q1;
            }
            rear=myrear;
        }

        return myhead.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode myhead = reverseKGroup(head, 2);
        while (myhead!=null){

            System.out.println(myhead.val);
            myhead=myhead.next;
        }
    }


}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }