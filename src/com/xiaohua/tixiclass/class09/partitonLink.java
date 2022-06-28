package com.xiaohua.tixiclass.class09;

import com.xiaohua.tixiclass.ListNode;

/**给定一个单链表的头节点head，给定一个整数n，将链表按n划分成左边<n、中间==n、右边>n
 * @author xiaohua
 * @create 2022-05-18 0:19
 */
public class partitonLink {

    public ListNode partition(ListNode head,int target){

        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode mH = null;
        ListNode mT = null;
        ListNode next = null;
        while (head!=null){
            next = head.next;
            head.next = null;
            if (head.val<target){
                if (sH==null){

                    sH = head;
                    sT = head;
                }else {

                    sT.next = head;
                    sT = sT.next;
                }
            }else if (head.val==target){
                if (eH==null){
                    eH = head;
                    eT = head;
                }else {

                    eT.next = head;
                    eT = eT.next;
                }
            }else {
                if (mH==null){
                    mH = head;
                    mT = head;
                }else {

                    mT.next = head;
                    mT = mT.next;
                }
            }
            head = next;
        }

        if (sT!=null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT!=null){
            eT.next = mH;
        }
        return sT != null ? sH : eT != null ? eH : mH;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(10, new ListNode(3))));
        head = new partitonLink().partition(head,4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
