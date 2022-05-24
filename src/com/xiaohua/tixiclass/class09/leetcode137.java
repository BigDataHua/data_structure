package com.xiaohua.tixiclass.class09;

/**
 * @author xiaohua
 * @create 2022-05-16 23:59
 */
public class leetcode137 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        int[] arr = new int[32];
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j <32 ; j++) {
                arr[j]=arr[j]+((nums[i]&(1<<j))==0?0:1);
            }

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i]%3;
            ans = ans + (arr[i] << i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3};
        int i = new leetcode137().singleNumber(arr);
    }
}
