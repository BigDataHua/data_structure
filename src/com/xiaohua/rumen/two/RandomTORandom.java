package com.xiaohua.rumen.two;

/** 给你 返回 0 1 不等概率  让你等概率返回a-b的范围
 * @author xiaohua
 * @create 2022-03-18 23:12
 */
public class RandomTORandom {

    public static int f1(){
        return (Math.random()<0.8)? 0 : 1 ;
    }

    //f1函数输出  0 的概率x 1的概率 1-x
    //两次调用f1函数  0 0 概率为x*x 1 1 概率为（1-x）*（1-x） 重做
    //只有 0 1  1 0  概率均为x*（1-x）返回  这样就做到了 0 1 等概率返回
    public static int f2(){
        int num;
        do {
            num = f1();
        }while (f1()==num);
        return num;
    }

    //接着用 0 1 组合二进制等概率返回就行  不需要的部分重做

    public static void testRandom(int arr[]){

        for (int i = 0; i < 10000; i++) {
            arr[f2()]++;
        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);

        }


    }

    public static void main(String[] args) {
        int[] arr = new int[4];
        testRandom(arr);
    }

}
