package com.xiaohua.tixiclass.class04;

import com.xiaohua.tixiclass.PublicMethodUtils;



/**
 * 逆序对问题 leetcode原题
 * @author xiaohua
 * @create 2022-04-19 21:58
 */
public class ReverseSum {

    public static int sumRe(int[]arr){
        if (arr==null||arr.length<2){
            return 0;
        }

        return myProcess(arr);
    }

    public static int myProcess(int[] arr) {
        int result = 0;

        int mergeSize = 1;
        while (mergeSize<arr.length){

            int left = 0;
            while (left<arr.length){
                int mid = left+mergeSize-1;
                if (mid>=arr.length-1){
                    break;
                }
                int right = Math.min(mid+mergeSize,arr.length-1);
                result+=merge(arr,left,mid,right);
                left=right+1;
            }

            if (mergeSize>arr.length/2){
                break;
            }
            mergeSize<<=1;

        }

        return result;
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int result=0;

        int p1 = mid;
        int p2 = right;
        int[] help = new int[right-left+1];
        int i =help.length-1;
        while (p1>=left&&p2>=mid+1){
            result+=arr[p1]>arr[p2]?p2-mid:0;
            help[i--]=(arr[p1]>arr[p2]?arr[p1--]:arr[p2--]);
        }
        while (p1>=left){
            help[i--]=arr[p1--];
        }
        while (p2>=mid+1){
            help[i--]=arr[p2--];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left+j]=help[j];
        }



        return result;
    }

    public static int myCheck(int[] arr){
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j >i ; j--) {
                if (arr[i]>arr[j]){
                    result++;
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
            System.out.println(i);
            int[] randomArr = PublicMethodUtils.getRandomArr(max, len);
            int[] copyArr = PublicMethodUtils.copyArr(randomArr);
            check = myCheck(copyArr);
            result=sumRe(randomArr);

            if (check!=result){
                PublicMethodUtils.print(randomArr);
                PublicMethodUtils.print(copyArr);

                flag=false;
                break;
            }
        }

        System.out.println(flag);

    }

}
