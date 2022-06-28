package com.xiaohua.tixiclass.class09;

import com.xiaohua.tixiclass.ListNode;

/**leetcode138
 一种特殊的单链表节点类描述如下
 class Node {
 int value;
 Node next;
 Node rand;
 Node(int val) { value = val; }
 }
 rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null
 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表的复制
 返回复制的新链表的头节点，要求时间复杂度O(N)，额外空间复杂度O(1)
 * @author xiaohua
 * @create 2022-05-18 0:42
 */
public class copyLinkHard {

    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        Node p = head;
        //创建链表插入到每个节点后面
        while (p!=null){
            Node myNode = new Node(p.val);
            myNode.next = p.next;
            p.next = myNode;
            p = myNode.next;
        }
        p = head;
        Node q = head;
        while (q.next!=null){
            q = p.next;
            q.random = p.random.next;
            p = q.next;
        }
        Node myHead = null;
        Node myRear = null;
        p = head;
        q = head;
        while (p!=null){
            q = p.next;
            p.next = q.next;
            q.next = null;
            if (myRear==null){
                myHead = q;
                myRear = q;
            }else {
                myRear.next = q;
                myRear = q;
            }
            q = p.next;
            p = q;

        }

        return myHead;
    }

}
