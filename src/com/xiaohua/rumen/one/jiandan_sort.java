package com.xiaohua.rumen.one;

/**
 * 练习简单 选择
 *
 *
 * @author xiaohua
 * @create 2022-03-16 13:56
 */

public class jiandan_sort {

    //用于打印
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //交换函数
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //简单选择排序
    public static void selectsort(int[] arr) {
        if (arr ==null ||arr.length <2){
            return;
        }

        for (int i = 0; i <arr.length; i++) {
            int curindex = i;
            for (int j = i+1;j<arr.length;j++){
                curindex = (arr[curindex]>arr[j])? j:curindex;
            }
            swap(arr,curindex,i);
        }


    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        if (arr ==null ||arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int second = 1;second<arr.length-i;second++){
                if(arr[second-1]>arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    //直接插入排序
    public static void insertSort(int[] arr){
        if (arr ==null ||arr.length <2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int curnum = arr[i];
            int end;
            //用直接插入排序时   注意比较的是保留的元素，不是迭代的元素
            for (end = i;i-1>=0&&curnum<arr[end-1];end--){
                arr[end]= arr[end-1];
            }
            arr[end] = curnum;
        }
    }

    public static void main(String[] args) {

        int arr[] = {1,5,4,3,7,333,234,8,6,4};
        print(arr);
        insertSort(arr);
        print(arr);

    }




}
