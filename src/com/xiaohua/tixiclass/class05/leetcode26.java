package com.xiaohua.tixiclass.class05;

/**
 * @author xiaohua
 * @create 2022-04-30 12:19
 */
public class leetcode26 {
    public static int removeDuplicates(int[] nums) {
        int rear =0;
        int count=0;
        if(nums==null||nums.length<1){
            return 0 ;
        }
        for(int i = 1;i<nums.length;i++){
            if(nums[rear]!=nums[i]){
                nums[++rear]=nums[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2};
        int k = removeDuplicates(arr);
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }

    }
}
