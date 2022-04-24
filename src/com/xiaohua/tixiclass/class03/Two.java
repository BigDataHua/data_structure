package com.xiaohua.tixiclass.class03;

/**
 * 实现栈和队列
 *
 * @author xiaohua
 * @create 2022-04-04 22:29
 */

//数组实现
//栈
class mystackarr {

    private int[] arr = null;
    private int index = 0;

    public mystackarr(int num) {
        arr = new int[num];
    }

    public boolean push(int num) {
        if (index >= arr.length) {
            System.out.println("栈空间已满");
            return false;
        }
        arr[index++] = num;
        System.out.println("插入成功");
        return true;
    }

    public boolean pop() {
        if (index <= 0) {
            System.out.println("栈内无元素");
            return false;
        }
        System.out.println("出栈元素" + arr[--index]);
        return true;
    }

}

class mystackLinklist {
    private TwoNode head = null;
    private TwoNode rear = null;

    public boolean push(int num) {
        if ((head == rear) && (head == null)) {
            head = new TwoNode(num, null, null);
            rear = head;
            System.out.println("插入成功");
            return true;
        }
        rear.next = new TwoNode(num, rear, null);
        rear = rear.next;
        System.out.println("插入成功");
        return true;
    }

    public boolean pop() {
        if ((head == rear) && (head == null)) {
            System.out.println("栈内已经没有元素");
            return false;
        }
        int num;
        if (head == rear) {
            num = rear.data;
            head = null;
            rear = null;
            System.out.println("删除元素为：" + num);
            return true;
        }
        num = rear.data;
        rear = rear.pre;
        rear.next = null;
        System.out.println("删除元素为：" + num);
        return true;
    }
}

class myqueenarr {

    private int[] arr = null;
    private int start = 0;
    private int rear = 0;
    private int size = 0;

    public myqueenarr(int num) {
        if (num <= 0) {
            num = 10;
        }
        arr = new int[num];
    }

    public boolean push(int num) {
        if (size>=arr.length){
            System.out.println("队列以满");
            return false;
        }
        size++;
        arr[rear]=num;
        rear=compute(rear);
        System.out.println("已加入队列"+num);
        return true;
    }

    public boolean pop() {
        if (size<=0){
            System.out.println("队列为空");
            return false;
        }
        size--;
        int num = arr[start];
        start=compute(start);
        System.out.println("出队"+num);
        return true;
    }
    private int compute(int num){
        return num==arr.length? 0:num++;
    }
}

class myqueenLinklist{
    int size=0;
    TwoNode start = null;
    TwoNode rear = null;

    public boolean push(int num){

        if (size==0){
            start = new TwoNode(num,null,null);
            rear=start;
            size++;
            System.out.println("队列为:"+num);
            return true;
        }

        rear.next=new TwoNode(num,rear,null);
        rear=rear.next;
        size++;
        System.out.println("队列为:"+num);
        return true;
    }

    public boolean pop(){
        if (size==0){
            System.out.println("队列为空");
            return false;
        }


        if (size==1){
            int num = start.data;
            start=rear=null;
            size--;
            System.out.println("出队"+num);
            return true;
        }

        int num = start.data;
        TwoNode next = start.next;
        start.next=null;
        next.pre=null;
        start=next;
        size--;
        System.out.println("出队"+num);
        return true;
    }
}

public class Two {

    public static void main(String[] args) {
        myqueenLinklist stack = new myqueenLinklist();
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(3);
        stack.push(3);
        stack.push(3);
    }


}
