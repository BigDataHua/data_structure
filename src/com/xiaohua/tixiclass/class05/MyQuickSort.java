package com.xiaohua.tixiclass.class05;

import com.xiaohua.tixiclass.PublicMethodUtils;


import java.util.Stack;

import static com.xiaohua.tixiclass.class04.MergeSort.equalArr;
import static com.xiaohua.tixiclass.class04.MergeSort.mergeXun;

/**
 * 荷兰国旗问题2.0版本
 * 快速排序递归版3.0版本
 * @author xiaohua
 * @create 2022-04-25 21:35
 */
public class MyQuickSort {



    public static void swap(int[] arr,int p,int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
    //荷兰国旗问题
    //小于target放左边 等于target 放中间 大于target放右边
    public static int[] helanpro(int[] arr, int left, int right){
        if (arr==null||left>=right){
            return new int[]{-1,-1};
        }
        int less = left-1;
        int more = right;
        int index = left;
        while (index<more){
            //等于直接跳
            if (arr[right]==arr[index]){
                index++;
            }else if (arr[index]<arr[right]){
                //小于则交换，然后跳下一个
                swap(arr,++less,index++);
            }else {
                //大于则交换，不跳继续比较
                swap(arr,index,--more);
            }

        }

        swap(arr,more,right);
        return new int[]{++less,more};
    }

    public static void process(int[] arr,int left,int right){

        if (left>=right){
            return;
        }
        swap(arr,left+(int) (Math.random()*(right-left+1)),right);
        int[] mid = helanpro(arr, left, right);
        process(arr,left,mid[0]-1);
        process(arr,mid[1]+1,right);

    }

    public static void quicksortGui(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }

        process(arr,0,arr.length-1);
    }

    //非递归
    //不用系统栈，自己实现栈
    public static void quicksortNG(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        Stack<Order> orders = new Stack<Order>();
        swap(arr, (int) (arr.length*(Math.random())),arr.length-1);
        int[] ins = helanpro(arr, 0, arr.length - 1);
        orders.push(new Order(0,ins[0]-1));
        orders.push(new Order(ins[1]+1,arr.length-1));
        while (!orders.empty()){
            Order pop = orders.pop();
            if (pop.left>=pop.right){
                continue;
            }
            swap(arr, pop.left+(int) ((pop.right-pop.left+1)*(Math.random())),pop.right);
            int[] helanpro = helanpro(arr, pop.left, pop.right);
            orders.push(new Order(pop.left,helanpro[0]-1));
            orders.push(new Order(helanpro[1]+1,pop.right));
        }

    }

    public static void main(String[] args) {

        int max = 10000;
        int len = 1000;
        int time  =10000;
        boolean flag = true;
        for (int i = 0; i < time; i++) {
            int[] randomArr = PublicMethodUtils.getRandomArr(max, len);
            int[] copyArr = PublicMethodUtils.copyArr(randomArr);
            quicksortNG(randomArr);
            quicksortGui(copyArr);
            flag=equalArr(randomArr,copyArr);
            if (!flag){
                break;
            }
            for (int i1 : copyArr) {
                System.out.println(i1);
            }

        }
        if (flag==true){
            System.out.println("Nice");
        }else {
            System.out.println("nonono");
        }
    }

}

class Order{

    int left;
    int right;
    public Order(int left,int right){
        this.left = left;
        this.right = right;
    }
}
