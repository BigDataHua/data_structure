package com.xiaohua.tixiclass.class21;

import java.util.Arrays;

/**
 * @author xiaohua
 * @create 2022-07-08 23:47
 */
public class leetcode5 {
    /*
    * 输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */

    public int jump(int[] nums) {
        return process(nums, 0);
    }

    private int process(int[] nums, int index) {
        if (index >= nums.length-1) {
            return 0;
        }
        int ans = 10000;
        for (int i = 1;i <= nums[index]; i++) {
            ans = Math.min(ans, process(nums, index + i)+1);
        }
        return ans;

    }



    public int jump1(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[N] = 0;
        for(int index = N-2;index>=0;index--) {

            int ans = 10000;
            for (int j = 1;index+j<=N-1&&j <= nums[index]; j++) {
                ans = Math.min(ans,dp[index+j]+1);
            }
            dp[index] = ans;



        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new leetcode5().jump1(new int[]{2,1}));
    }


}
