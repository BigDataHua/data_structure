package com.xiaohua.tixiclass.class17;

import java.util.Stack;

/**
 * @author xiaohua
 * @create 2022-06-29 1:12
 */
public class ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack){

        if(stack.isEmpty()){
            return;
        }
        int f = f(stack);
        reverse(stack);
        stack.push(f);

    }
    //将取出栈底的元素
    public static int f(Stack<Integer> stack){
        Integer pop = stack.pop();
        if (stack.isEmpty()){
            return pop;
        }

        int last = f(stack);
        stack.push(pop);
        return last;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
