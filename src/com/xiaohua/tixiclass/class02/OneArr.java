package com.xiaohua.tixiclass.class02;

/**
 * 一个数组 一种数为奇数  其他为偶数 求出那个奇数
 * 思路 ：采用 与 运算  因为一个数 与 上自己还是自己
 * 其他数 都是偶数个 所以遍历一遍就可以得到那个奇数
 * @author xiaohua
 * @create 2022-03-28 23:25
 */
public class OneArr {


    public static int OneArr(int[] arr){
        if (arr==null||arr.length<1){
            return 9999999;
        }

        int result = arr[0];

        for(int i = 0;i<arr.length;i++){
            result=result^arr[i];
        }

        return result;
    }



    public static void main(String[] args){

        int arr[] = {1,1,1,4,4,6,6};
        int result = OneArr(arr);
        System.out.println(result);
    }




}
