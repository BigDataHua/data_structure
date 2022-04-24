package com.xiaohua.tixiclass.class04;

import com.xiaohua.tixiclass.PublicMethodUtils;

/**
 * 归并排序
 *      递归实现与非递归实现
 *
 * @author xiaohua
 * @create 2022-04-19 21:57
 */
public class MergeSort {

    //归并排序递归实现
    public static void mergeGui(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }

        process(arr,0,arr.length-1);

    }
    public static void merge(int[] arr, int left,int mid, int right){
        int p1 = left;
        int p2 = mid+1;
        int[] help = new int[right-left+1];
        int i = 0;
        while (p1<=mid&&p2<=right){
            help[i++] =(arr[p1]<=arr[p2])?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=right){
            help[i++]=arr[p2++];
        }

        for (int j = 0; j <i ; j++) {
            arr[left+j]=help[j];
        }
    }
    public static void process(int[] arr, int left, int right) {
        if (left<right){

            int mid = left+((right-left)>>1);
            process(arr,left,mid);
            process(arr,mid+1,right);
            merge(arr,left,mid,right);

        }
    }
    //归并排序非递归实现
    public static void mergeXun(int[] arr){

        if (arr==null||arr.length<2){
            return;
        }

        XunProcess(arr);



    }
    private static void XunProcess(int[] arr) {
        int mergeSize = 1;
        while (mergeSize<arr.length){
            int left = 0;
            while (left+mergeSize<arr.length){
                int mid = left+mergeSize-1;
                //此处有可能mid超出整个数组越界，直接跳出做下一轮循环去
                if (mid>=arr.length){
                    break;
                }
                //此处用最小值，要么右组够，要么不够，取数组最末尾
                int right = Math.min(arr.length-1,mid+mergeSize);
                //merge去给我合并
                merge(arr,left,mid,right);
                //left给我更新到下一组开始排序的位置
                left=right+1;
            }
            if (mergeSize>arr.length/2){
                break;
            }
            mergeSize=mergeSize<<1;
        }
    }
    //用来比较
    public static void insertSort(int arr[]) {

        if (arr == null && arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && arr[j - 1] > num; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;

        }

    }
    public static void main(String[] args) {
        int max = 10000;
        int len = 1000;
        int time = 10000;
//        int[] randomArr = PublicMethodUtils.getRandomArr(max, len);
//        mergeXun(randomArr);
//        PublicMethodUtils.print(randomArr);

        boolean flag = true;
        for (int i = 0; i < time; i++) {
            int[] randomArr = PublicMethodUtils.getRandomArr(max, len);
            int[] copyArr = PublicMethodUtils.copyArr(randomArr);
            mergeXun(randomArr);
            insertSort(copyArr);
            flag=equalArr(randomArr,copyArr);
            if (!flag){
                break;
            }

        }
        if (flag==true){
            System.out.println("Nice");
        }else {
            System.out.println("nonono");
        }


    }
    public static boolean equalArr(int[] randomArr, int[] copyArr) {
        for (int i = 0; i < randomArr.length; i++) {
            if (randomArr[i]!=copyArr[i]){
                return false;
            }
        }

        return true;
    }

}
