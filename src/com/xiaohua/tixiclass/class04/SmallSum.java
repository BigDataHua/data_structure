package com.xiaohua.tixiclass.class04;

import com.xiaohua.tixiclass.PublicMethodUtils;

/**  小和问题
 *      一个数左边有多少个比自己大的数总和
 * @author xiaohua
 * @create 2022-04-19 21:57
 */
public class SmallSum {

    public static int sumSamll(int[] arr){

        if (arr==null||arr.length<2){
            return 0;
        }
        return myProcess(arr);

    }

    public static int myProcess(int[] arr) {
        int mergeSize = 1;
        int result = 0;
        while (mergeSize<arr.length){

            int left = 0;
            while (left<arr.length){
                int mid = left+mergeSize-1;
                if (mid>=arr.length){
                    break;
                }
                int right = Math.min(mid+mergeSize,arr.length-1);
                result+=myMerge(arr,left,mid,right);
                left=right+1;
            }

            if (mergeSize/2>arr.length){
                break;
            }
            mergeSize<<=1;
        }
        return result;
    }
    private static int myMerge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid+1;
        int result = 0;
        int[] help = new int[right-left+1];
        int i = 0;
        while (p1<=mid&&p2<=right){
            result+=((arr[p1] < arr[p2]) ? arr[p1] * (right - p2+1) : 0);
            help[i++] = ((arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++]);
        }

        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=right){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left+j]=help[j];
        }
        return result;

    }

    public static int myCheck(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i]){
                    result+=arr[j];
                }
            }
        }


        return result;
    }


    public static void main(String[] args) {
        int max = 10000;
        int len = 10000;
        int time = 10000;
        int result =0;
        int check=0;
        boolean flag=true;
        for (int i = 0; i < time; i++) {
            int[] randomArr = PublicMethodUtils.getRandomArr(max, len);
            int[] copyArr = PublicMethodUtils.copyArr(randomArr);
            check = myCheck(copyArr);
            result=sumSamll(randomArr);

            if (check!=result){
                flag=false;
                break;
            }
        }

        System.out.println(flag);

    }

}
