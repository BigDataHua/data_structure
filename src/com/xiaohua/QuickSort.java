package com.xiaohua;

import java.util.Comparator;

/**
 * @author xiaohua
 * @create 2022-05-09 23:18
 */
public class QuickSort {



    public static <T> void sort(T arr [], Comparator<T> comp){
        if (arr==null||arr.length<2){
            return;
        }
        quicksort(arr,0,arr.length-1,comp);

    }

    private static <T> void quicksort(T[] arr, int left, int right, Comparator<T> comp) {

        if (left>=right){
            return;
        }
        int[] mid = helan(arr,left,right,comp);
        quicksort(arr,left,mid[0]-1,comp);
        quicksort(arr,mid[1]+1,right,comp);

    }

    private static <T> int[] helan(T[] arr, int left, int right, Comparator<T> comp) {
        //先交换一下
       swap(arr,right,(int)(Math.random()*(right-left+1)+left));
       int l = left-1;
       int r = right;
       int index = left;
       while (index<r){
           if (comp.compare(arr[index],arr[right])<0){
               swap(arr,index++,++l);
           }else if (comp.compare(arr[index],arr[right])==0){
               index++;
           }else {
               swap(arr,index,--r);
           }
       }
       swap(arr,index,right);
       return new int[]{l+1,r};
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
