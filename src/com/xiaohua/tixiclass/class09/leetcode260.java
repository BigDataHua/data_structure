package com.xiaohua.tixiclass.class09;

/** 此题还要防止溢出
 * @author xiaohua
 * @create 2022-05-17 0:24
 */
public class leetcode260 {

    public int[] singleNumber(int[] nums) {
        long ans1 = 0;
        for (int i =0 ; i < nums.length; i++) {
            ans1 ^= nums[i];
        }
        long judge = (ans1 == Integer.MIN_VALUE ? ans1 : ans1 & (-ans1));
        long ans2 = 0;
        for (int i = 0; i <nums.length ; i++) {
            if ((judge & nums[i]) == 0){
                ans2 ^= nums[i];
            }
        }
        return new int[]{(int) (ans1 ^ ans2), (int) ans2};

    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 3};
        new leetcode260().singleNumber(arr);
    }
}
