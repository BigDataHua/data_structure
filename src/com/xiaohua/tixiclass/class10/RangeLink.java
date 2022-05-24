package com.xiaohua.tixiclass.class10;

import com.xiaohua.tixiclass.ListNode;



/**
 给定两个可能有环也可能无环的单链表，头节点head1和head2
 请实现一个函数，如果两个链表相交，请返回相交的第一个节点。如果不相交返回null
 要求如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 * @author xiaohua
 * @create 2022-05-18 13:21
 */
public class RangeLink {

    //判断链表是否有环，有环返回入环节点，无环返回null
    public ListNode isRange(ListNode head){
        if (head==null||head.next==null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast!=null&&fast.next!=null&&fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        //肯定无环
        if (fast!=slow){
            return null;
        }
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode isAccess(ListNode head1,ListNode head2,ListNode rear){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int count = 0;
        while (cur1!=rear){
            count++;
            cur1= cur1.next;
        }
        while (cur2!=rear){
            count--;
            cur2 = cur2.next;
        }
        cur1 = count > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        count = Math.abs(count);
        while (count!=0){
            count--;
            cur1 = cur1.next;
        }
        while (cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public ListNode isAccess(ListNode head1,ListNode head2){
        ListNode range1 = isRange(head1);
        ListNode range2 = isRange(head2);
        //两个链表无环
        if (range1 == range2&&range1==null){
            isAccess(head1,head2,null);
        } else if (range1!=null&&range2!=null){
            //两个链表有环
            if (range1==range2){
                //入环节点相同
                isAccess(head1, head2, range1);
            }else{
                //入环节点不同
                while (range1!=null){
                    //在环内能找到第二个链表的入环节点，则相交节点为第二个链表的入环节点
                    if (range1 ==range2){
                        return range1;
                    }
                    range1 = range1.next;
                }
                //在环内没找到第二个链表的入环节点，直接返回null
                // （因为退出while rang1为null ）直接返回range1
                return range1;
            }
        }


        //一个有环 一个无环
        return null;
    }


}
