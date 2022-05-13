package com.xiaohua.tixiclass.class09;

import com.xiaohua.tixiclass.ListNode;
import com.xiaohua.tixiclass.PublicMethodUtils;

/**
 * @author xiaohua
 * @create 2022-05-13 22:03
 */
public class LinkProblem {

    //输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public ListNode midder1(ListNode head){

        ListNode p = head;
        ListNode q = head;
        while (p!=null&&p.next!=null&&p.next.next!=null){
            p = p.next.next;
            q = q.next;
        }
        return q;

    }
    public ListNode check1(ListNode head,int num){
        ListNode q = head;
        int count = 1;
        while (count!=(num+1)/2){
            q = q.next;
            count++;
        }
        return q;
    }
    //输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public ListNode midder2(ListNode head){
        ListNode p = head;
        ListNode q = head;
        while (p!=null&&p.next!=null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }
    public ListNode check2(ListNode head,int num){
        ListNode q = head;
        int count = 1;
        if (num%2==1){
            num += 1;
        }else {
            num += 2;
        }
        while (count!=num/2){
            q = q.next;
            count++;
        }
        return q;
    }
//    输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    public ListNode midder3(ListNode head){
        ListNode p = head;
        ListNode q = head;
        while (p!=null&&p.next!=null&&p.next.next!=null){
            p=p.next.next;
            if (p==null||p.next==null||p.next.next==null){
                break;
            }
            q = q.next;
        }
        return q;
    }
    public ListNode check3(ListNode head,int num){
        ListNode q = head;
        int count = 1;
        if (num%2==0){
            num -= 2;
        }
        while (count!=num/2){
            q = q.next;
            count++;
        }
        return q;
    }
//    输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
    public ListNode midder4(ListNode head){
        ListNode p = head;
        ListNode q = head;
        while (p!=null&&p.next!=null&&p.next.next!=null){
            p = p.next.next;
            if (p==null||p.next==null){
                break;
            }
            q = q.next;
        }
        return q;
    }
    public ListNode check4(ListNode head,int num){
        ListNode q = head;
        int count = 1;

        while (count!=num/2){
            q = q.next;
            count++;
        }
        return q;
    }
    public ListNode arrToLink(int[] arr){
        ListNode myhead = new ListNode();
        ListNode rear = myhead;
        for (int i = 0; i < arr.length; i++) {
            ListNode q = new ListNode(arr[i]);
            rear.next = q;
            rear = q;
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        int time = 10000;
        int max = 1000;
        int len = 10000;
        boolean flag = true;
        int[] randomArr=null;
        for (int i = 0; i <time ; i++) {
            do {

                randomArr = PublicMethodUtils.getRandomArr(max, len);
            }while (randomArr==null||randomArr.length<3);
            System.out.println("第"+i+"次："+"数组长为："+randomArr.length);
            LinkProblem p = new LinkProblem();
            ListNode head=p.arrToLink(randomArr);
            ListNode m = p.midder4(head);
            ListNode c = p.check4(head, randomArr.length);
            flag=(m==c);
            if (!flag){
                System.out.println(m.val);
                System.out.println(c.val);
                break;
            }

        }
        if (flag==true){
            System.out.println("Nice");
        }else {
            System.out.println("nonono");
        }


    }

}
