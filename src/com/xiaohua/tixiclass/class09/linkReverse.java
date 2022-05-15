package com.xiaohua.tixiclass.class09;

import com.xiaohua.tixiclass.ListNode;

/**给定一个单链表的头节点head，请判断该链表是否为回文结构（返回后该链表保持原样）
 * @author xiaohua
 * @create 2022-05-14 23:56
 */
public class linkReverse {
    public boolean isHui(ListNode head){
        ListNode q = head;
        ListNode p = head;
        //找到中间位置 奇数为中点，偶数为上中点
        while (p!=null&&p.next!=null&&p.next.next!=null){
            p = p.next.next;
            q = q.next;
        }
        ListNode mid = q;
        ListNode cur =q;
        ListNode qre = cur.next;
        ListNode late = null;
        while (cur!=null){
            cur.next = late;
            late = cur;
            cur = qre;
            qre=qre==null?null:qre.next;
        }
        ListNode l =head;
        ListNode r = late;
        boolean flag = true;
        while (l!=null){
            if (l.val!=r.val){
                flag=false;
            }
            l = l.next;
            r = r.next;
        }
        //链表恢复原状
        cur =late;
        late=null;
        qre = cur.next;
        while (mid!=cur){
            cur.next = late;
            late = cur;
            cur = qre;
            qre = qre.next;
        }
        mid.next = late;


        return flag;


    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
        linkReverse lr = new linkReverse();
        System.out.println(lr.isHui(head1));
        System.out.println(lr.isHui(head2));
        while (head1!=null){
            System.out.print(head1.val+" ");
            head1 = head1.next;
        }
        System.out.println();
        while (head2!=null){
            System.out.print(head2.val+" ");
            head2 = head2.next;
        }
    }

}
