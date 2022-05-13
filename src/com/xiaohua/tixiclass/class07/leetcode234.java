package com.xiaohua.tixiclass.class07;


import com.xiaohua.tixiclass.ListNode;

import java.util.List;

/** 回文链表
 * @author xiaohua
 * @create 2022-05-08 23:19
 */
public class leetcode234 {

    public static boolean isPalindromeMath(ListNode head) {
        if(head ==null){
            return false;
        }
        if(head.next==null){
            return true;
        }


        ListNode p1 = head;
        ListNode p2 = head;
        double num = head.val;
        int count = 1;
        while (p1.next!=null){
            count++;
            p1 = p1.next;
        }
        p1 = head;
        while(p2!=null){
            if(p2.next==null||p2.next.next==null){
                break;
            }
            p1=p1.next;
            num=num*10+p1.val;
            p2=p2.next.next;
        }
        p2=p1.next;
        if (count%2==1){
            num = num/10;
        }


        while(p2!=null){
            int result = (int) (num % 10);
            if ((int)num%10!=p2.val){
                return false;
            }
            num/=10;
            p2 = p2.next;

        }

        return true;
    }



    public boolean isPalindrome(ListNode head) {
        //利用栈实现
        //利用双指针（遍历），加尾插法，进行一遍比较
        ListNode myhead = new ListNode();
        myhead.next = head;
        ListNode p = head;
        ListNode q = head;
        boolean flag = true;
        while (q!=null){
            if (q.next==null||q.next.next==null){
                break;
            }
            q = q.next.next;
            p=p.next;
        }
        q = p.next;
        //检查链表
        ListNode check = new ListNode();
        while (q!=null){
            p = q;
            q = q.next;
            p.next = check.next;
            check.next = p;
        }
        p = myhead.next;
        q = check.next;
        while (q!=null&&p!=null){
            if (q.val!=p.val){
                flag=false;
            }
            q = q.next;
            p = p.next;
        }


        return flag;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(0)));
        int[] arr = new int[]{8, 0, 7, 1, 7, 7, 9, 7, 5, 2, 9, 1, 7, 3, 7, 0, 6, 5, 1, 7, 7, 9, 3, 8, 1, 5, 7, 7, 8, 4, 0, 9, 3, 7, 3, 4, 5, 7, 4, 8, 8, 5, 8, 9, 8, 5, 8, 8, 4, 7, 5, 4, 3, 7, 3, 9, 0, 4, 8, 7, 7, 5, 1, 8, 3, 9, 7, 7, 1, 5, 6, 0, 7, 3, 7, 1, 9, 2, 5, 7, 9, 7, 7, 1, 7, 0, 8};
        System.out.println(arr.length);
        head = createList(arr);
        System.out.println(isPalindromeMath(head));


    }

    private static ListNode createList(int[] arr) {
        ListNode myhead = new ListNode();
        ListNode rear = myhead;
        for (int i = 0; i < arr.length; i++) {
            ListNode q = new ListNode(arr[i]);
            rear.next = q;
            rear = q;

        }
        return myhead.next;

    }

}
