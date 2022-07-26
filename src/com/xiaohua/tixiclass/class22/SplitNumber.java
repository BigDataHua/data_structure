package com.xiaohua.tixiclass.class22;

/**
 *
 * @author xiaohua
 * @create 2022-07-11 0:45
 */
public class SplitNumber {
    /*
    * 给定一个正数n，求n的裂开方法数，
规定：后面的数不能比前面的数小
比如4的裂开方法有：
1+1+1+1、1+1+2、1+3、2+2、4
5种，所以返回5
    * */

    // n为正数
    public static int ways(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return process(1, n);
    }

    // 上一个拆出来的数是pre
    // 还剩rest需要去拆
    // 返回拆解的方法数
    public static int process(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (rest < pre) {
            return 0;
        }
        int ans = 0;
        for (int i = pre; i <=rest ; i++) {
            ans+=process(i, rest - i);
        }
        return ans;
    }

    public static int dp1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int pre = n-1; pre >=1; pre--) {

            for (int rest = pre + 1; rest <= n; rest++) {

                int ans = 0;
                for (int i = pre; i <= rest; i++) {
                    ans += dp[i][rest - i];
                }
                dp[pre][rest] = ans;
            }
        }

        return dp[1][n];
    }

    public static int dp2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int pre = n-1; pre >=1 ; pre--) {
            for (int rest = pre+1; rest <= n ; rest++) {
                dp[pre][rest] = dp[pre + 1][rest] + dp[pre][rest - pre];
            }

        }


        return dp[1][n];
    }

    public static void main(String[] args) {
        int test = 39;
        System.out.println(ways(test));
        System.out.println(dp1(test));
        System.out.println(dp2(test));
    }


}
