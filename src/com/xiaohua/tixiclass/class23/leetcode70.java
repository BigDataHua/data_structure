package com.xiaohua.tixiclass.class23;

/**
 * @author xiaohua
 * @create 2022-07-13 1:17
 */
public class leetcode70 {

    //递归版 超出时间限制
    public int climbStairs1(int n) {
        return process(n);
    }

    private int process(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        int p1 = process(n - 1);
        int p2 = process(n - 2);
        return p1 + p2;
    }
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }


}
