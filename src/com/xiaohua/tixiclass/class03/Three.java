package com.xiaohua.tixiclass.class03;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**用栈如何实现队列？用队列如何实现栈？
 * @author xiaohua
 * @create 2022-04-06 22:19
 */

//    用栈如何实现队列？
//            两点原则  一次性倒完 pop栈不空，不能倒数据
class myqueen{
    private Stack<Integer> pushstack = new Stack<>();
    private Stack<Integer> popstack = new Stack<>();

    //倒数据
    private void pushToPop(Stack<Integer> push,Stack<Integer> pop){
        if (pop.empty()){
            while (!push.empty()){
                pop.push(push.pop());
            }
        }
    }
    public boolean offer(int num){
        pushstack.push(num);
        System.out.println("加入的数据"+num);
        pushToPop(pushstack,popstack);
        return true;
    }
    public boolean pop(){
        if (pushstack.empty()&&popstack.empty()){
            System.out.println("队列为空");
            return false;
        }
        pushToPop(pushstack,popstack);
        Integer pop = popstack.pop();
        System.out.println("出队元素为"+pop);
        return true;

    }



}

//    用队列如何实现栈？
//    两个队列来会玩   一组数据先进队列，如果要数据那么队列一数据（n-1个）进入队列二，
//      队列一返回，然后继续进
class mystack{

    private LinkedList<Integer> queue = new LinkedList<>();
    private LinkedList<Integer> help = new LinkedList<>();



    //倒数据
    private void queueToHelp(LinkedList<Integer>myqueue,LinkedList<Integer> myhelp){
        while (myqueue.size()>1){
            myhelp.offer(myqueue.pop());
        }

    }

    public boolean push(Integer num){
        queue.add(num);
        System.out.println("加入栈："+num);
        return true;
    }
    public boolean pop(){
        if (queue.size()==0){
            System.out.println("栈为空");
            return false;
        }
        queueToHelp(queue,help);
        Integer pop = queue.pop();
        System.out.println("出栈："+pop);
        LinkedList<Integer> temp = queue;
        queue = help;
        help=temp;
        return true;
    }


}


public class Three {

//    用栈如何实现队列？
//            两点原则  一次性倒完 pop栈不空，不能倒数据
    @Test
    public void test01(){
        myqueen myqueen = new myqueen();
        myqueen.offer(1);
        myqueen.offer(2);
        myqueen.offer(3);
        myqueen.offer(4);
        myqueen.offer(5);
        myqueen.pop();
        myqueen.pop();
        myqueen.pop();
        myqueen.pop();
        myqueen.pop();
        myqueen.pop();
        myqueen.pop();
        myqueen.pop();
        myqueen.pop();
    }


//    用队列如何实现栈？
//    两个队列来会玩   一组数据先进队列，如果要数据那么队列一数据（n-1个）进入队列二，
//      队列一返回，然后继续进
@Test
public void test02(){
    mystack myqueen = new mystack();
    myqueen.push(1);
    myqueen.push(2);
    myqueen.push(3);
    myqueen.push(4);
    myqueen.push(5);
    myqueen.pop();
    myqueen.pop();
    myqueen.pop();
    myqueen.pop();
    myqueen.pop();
    myqueen.pop();
    myqueen.pop();
    myqueen.pop();
    myqueen.pop();
}

}
