package com.xiaohua.tixiclass;

import org.junit.Test;

/**一些常用方法
 * @author xiaohua
 * @create 2022-03-23 22:45
 */
public class PublicMethodUtils {

    public static void print(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();

    }

    /**
     * 判断两个数组是否相等
     * @param arr1
     * @param arr2
     * @return 如果两个数相等返回true 否则返回false
     */
    public static boolean equals(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 拷贝数组
     * @param arr 原始数组
     * @return
     */
    public static int[] copyArr(int arr[]){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i]=arr[i];
        }

        return newArr;

    }

    /**
     * 随机数方法
     * @param maxValue 随机数的最大值
     * @return 返回从-N 至 N的一个随机数
     */
    public static int getRandomNum(int maxValue){
        int num= (int)(Math.random()*maxValue)-(int)(Math.random()*maxValue);
        return num;
    }

    /**
     * 生成随机数组
     * @param maxValue 数组的最大值
     * @param maxlen 数组的长度
     * @return
     */
    public static int[] getRandomArr(int maxValue,int maxlen){
        int len = (int)(Math.random()*maxlen);
        int[] newArr = new int[len];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i]=getRandomNum(maxValue);
        }
        return newArr;
    }
    /**
     * 获取数组长度
     */
    public static int getArrLen(int length){
        int arrlen=0;
        do {
            arrlen = (int) (Math.random()*length);
        }while (arrlen<=3);
        return arrlen;
    }

    /**
     * 打乱数组顺序
     */
    public static int[] getArrToRandom(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int num1 = (int) (Math.random() * arr.length);
            int num2 = (int) (Math.random() * arr.length);
            int tmp = arr[num1];
            arr[num1]=arr[num2];
            arr[num2]= tmp;

        }
        return arr;
    }




}
