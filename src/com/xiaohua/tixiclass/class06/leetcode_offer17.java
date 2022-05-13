package com.xiaohua.tixiclass.class06;

import java.util.Arrays;

/**
 * @author xiaohua
 * @create 2022-05-04 13:29
 */
public class leetcode_offer17 {

    public void heapify(int[] arr,int index, int heaplength){

        int left = index*2+1;
        while (left<heaplength){

            int small = left+1<heaplength&&arr[left]>arr[left+1]?left+1:left;
            small = arr[index]<arr[small]?index:small;
            //孩子大于父亲退出
            if (index==small){
                break;
            }
            swap(arr,index,small);
            index = small;
            left = index*2+1;
        }
    }

    private void swap(int[] arr, int index, int small) {
        int temp = arr[index];
        arr[index] =arr[small];
        arr[small] = temp;
    }

    public int[] smallestK(int[] arr, int k) {
        if(k<=0||arr==null){
            return new int[]{};
        }
        int[] result = new int[k];
        for (int i = arr.length; i >=0; i--) {
            heapify(arr,i,arr.length);
        }
        int heaplength = arr.length;
        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
            swap(arr,0,arr.length-1-i);
            heapify(arr,0,heaplength-i-1);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        int[] ints = new leetcode_offer17().smallestK(arr, arr.length);
        for (int anInt : arr) {
            System.out.println(anInt);
        }
    }
}
