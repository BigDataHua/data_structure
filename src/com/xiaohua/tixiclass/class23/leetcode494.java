package com.xiaohua.tixiclass.class23;

/**
 * @author xiaohua
 * @create 2022-07-13 14:14
 */
public class leetcode494 {

    public int findTargetSumWays1(int[] nums, int target) {
        return process(0,nums,target);
    }
    public int process(int index,int[] nums,int target){

        if (index==nums.length){
            return target==0 ?1:0;
        }
        int p1 = process(index+1,nums,target-nums[index]);
        int p2 = process(index+1,nums,target+nums[index]);
        return p1+p2;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        int[][] dp = new int[N+1][target+1];
        dp[N][0] = 1;
        for (int index = N-1; index >=0 ; index--) {

            for (int aim = 0; aim <= dp[0].length; aim++) {
                dp[index][aim] =
                        (aim-nums[index]>=0&&aim-nums[index]<=target?dp[index+1][aim-nums[index]]:0)
                        +
                        (aim+nums[index]>=0&&aim+nums[index]<=target?dp[index+1][aim+nums[index]]:0);
            }

        }
        return dp[0][target];
    }

}
