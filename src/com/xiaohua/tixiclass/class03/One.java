package com.xiaohua.tixiclass.class03;

import com.xiaohua.tixiclass.PublicMethodUtils;
import com.xiaohua.tixiclass.class01.Two;
import org.junit.Test;

import java.util.ArrayList;


/**
 * 单链表双链表的反转
 * 删除给定的值
 * @author xiaohua
 * @create 2022-04-04 20:28
 */

class OneNode{

    int data;
    OneNode next;

    public OneNode(){

    }
    public OneNode(int v){
        data = v;
    }

}

class TwoNode {

    int data;
    TwoNode pre;
    TwoNode next;

    public TwoNode() {
    }

    public TwoNode(int data, TwoNode pre, TwoNode next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }
}




public class One {

    public void printLinkList(OneNode head){
        OneNode p = head;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }

    }
    public void printTwoLinkList(TwoNode head){
        TwoNode p = head;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }

    }

    //创造单链表
    public OneNode buildLinkList(int max,int lenght){

        int len = (int)(Math.random()*lenght);//获取链表长度
        if (len==0){
            return null;
        }
//        System.out.println("长度为："+len);
        OneNode head = new OneNode(PublicMethodUtils.getRandomNum(max));
        OneNode p = head;
        for (int i = 1; i < len; i++) {
            p.next=new OneNode(PublicMethodUtils.getRandomNum(max));
            p=p.next;
        }
        p.next = null;

        return head;

    }

    //单链表反转
    public OneNode reverseOne(OneNode head){
        OneNode pre = null;
        OneNode next = head;
        while (next!=null){
            head = next;
            next = head.next;
            head.next=pre;
            pre = head;

        }

        return head;
    }

    public OneNode copyLinklist(OneNode head){
        if (head==null){
            return null;
        }

        OneNode myhead = new OneNode();
        OneNode p = head;
        //头插法实现反转
        while (p!=null){
            OneNode myNode = new OneNode(p.data);
            myNode.next=myhead.next;
            myhead.next=myNode;
            p=p.next;
        }
        return myhead.next;
    }

    public boolean check(OneNode head1,OneNode head2){
        OneNode p = head1;
        OneNode q = head2;
        if (p==null&&q==null){
            return true;
        }
        while (p!=null){
            if (p.data!=q.data){
                return false;
            }
            p=p.next;
            q=q.next;
        }
        return true;
    }

    @Test
    public void test01(){
        int max = 1000;
        int len = 10;
        int time = 1000;
        boolean flag = true;
        OneNode head01;
        OneNode head02;
        System.out.println("测试开始");
        for (int i = 0; i < time; i++) {
            head01 = buildLinkList(max,len);
            head02 = copyLinklist(head01);
            head01=reverseOne(head01);
            boolean check = check(head01, head02);
            if (check==false){
                printLinkList(head01);
                printLinkList(head02);
                flag=false;
                break;
            }
        }
        String result = flag? "good":"fuck!!1";
        System.out.println("测试结束");
        System.out.println(result);

    }

//    ==============================================================================================
    //创建双链表
    public TwoNode buildTwoLinkList(int max,int lenght){

    int len = (int)(Math.random()*lenght);//获取链表长度
    if (len==0){
        return null;
    }

    TwoNode head = new TwoNode(PublicMethodUtils.getRandomNum(max),null,null);
    TwoNode p = head;
    for (int i = 1; i < len; i++) {
        p.next=new TwoNode(PublicMethodUtils.getRandomNum(max),p,null);
        p=p.next;
    }

    return head;
}
    //双链表的反转
    public TwoNode reverseTwo (TwoNode head){
        TwoNode pre=null;
        TwoNode next=head;
        while (next!=null){
            head=next;
            next = head.next;
            head.next=pre;
            head.pre=next;
            pre=head;
        }
        return head;

    }

    //用数组检验
    public int[] reverseArr(TwoNode head){
        if (head==null){
            return null;
        }
        TwoNode p = head;
        ArrayList<Integer> list = new ArrayList();
        while (p!=null){
            list.add(p.data);
            p=p.next;
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            arr[i]=integer;
            i++;
        }
        for (int j = 0; j < arr.length/2; j++) {
            int temp = arr[j];
            arr[j] = arr[arr.length-j-1];
            arr[arr.length-j-1]=temp;
        }
        return arr;
    }
    public boolean check(TwoNode head,int[] arr){
        if (arr==null&&head==null){
            return true;
        }
        TwoNode p = head;
        for (int i = 0; i < arr.length; i++) {
            if (p.data!=arr[i]){
                return false;
            }
            p=p.next;
        }
        return true;
    }
    @Test
    public void test02(){
        int max = 1000;
        int len = 10000;
        int time = 100000;
        boolean check=true;
        System.out.println("测试开始");
        for (int i = 0; i < time; i++) {
            TwoNode head = buildTwoLinkList(max,len);
            int[] arr = reverseArr(head);
            head = reverseTwo(head);

            check = check(head, arr);
            if (!check){
                PublicMethodUtils.print(arr);
                printTwoLinkList(head);
                break;
            }
        }

        String result = check?"good!":"fuck!!";
        System.out.println("测试结束");
        System.out.println(result);

    }


}
