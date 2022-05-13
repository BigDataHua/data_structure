package com.xiaohua.tixiclass.class06;

import com.xiaohua.tixiclass.PublicMethodUtils;

import java.util.Arrays;

import static com.xiaohua.tixiclass.class04.MergeSort.equalArr;
import static com.xiaohua.tixiclass.class05.MyQuickSort.quicksortNG;
import static com.xiaohua.tixiclass.class05.MyQuickSort.swap;

/**
 * @author xiaohua
 * @create 2022-05-04 12:05
 */
public class myheap {

    //插入方法
    public static void heapinsert(int[] arr,int index){
        if (index>=arr.length||arr==null){
            return;
        }
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    //下沉方法
    public static void heapify(int[] arr,int index,int heaplength){
        int left = index*2+1;
        while (left<heaplength){
            int bigger = left+1<heaplength&&arr[left]<arr[left+1]? left+1:left;
            //孩子不比老子大，直接退出吧
            if (arr[index]>arr[bigger]){
                break;
            }
            swap(arr,index,bigger);
            index = bigger;
            left = index*2+1;
        }

    }

    public static void heapsort(int[]arr){
        if (arr==null||arr.length<2){
            return;
        }
        int heaplength = arr.length;
//        for (int i = heaplength-1; i >=0 ; i--) {
//            heapify(arr,i,heaplength);
//        }
        for (int i = 0; i < arr.length; i++) {
            heapinsert(arr,i);

        }

        for (int i = 0; i < arr.length; i++) {
            swap(arr,0,--heaplength);
            heapify(arr,0,heaplength);
        }
    }

    public static void main(String[] args) {

        int max = 10000;
        int len = 10000;
        int time  =10000;
        boolean flag = true;
        for (int i = 0; i < time; i++) {
            int[] randomArr = PublicMethodUtils.getRandomArr(max, len);
            int[] copyArr = PublicMethodUtils.copyArr(randomArr);
//            for (int i1 : copyArr) {
//                System.out.print(i1+" ");
//            }
            heapsort(copyArr);
            quicksortNG(randomArr);
//            System.out.println();
            System.out.println(i);
            flag=equalArr(randomArr,copyArr);
            if (!flag){
                System.out.println(i);
                for (int i1 : copyArr) {
                    System.out.print(i1+" ");
                }
                break;
            }

        }
        if (flag==true){
            System.out.println("Nice");
        }else {

            System.out.println("nonono");
        }

//        int[] arr = new int[]{-7307 ,408, -522 ,-1553 ,-116 ,2831 ,4936 ,1254 ,5122};
//        heapsort(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }

    }

}
