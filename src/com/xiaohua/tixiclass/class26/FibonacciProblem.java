package com.xiaohua.tixiclass.class26;

import java.util.HashMap;

/**
 * @author xiaohua
 * @create 2022-07-24 2:13
 */
public class FibonacciProblem {

    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
    public static int f3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1||n==2) {
            return 1;
        }

        long[][] dp = new long[][]{
                {1,1},{1,0}
        };
        long[][] ans = new long[][]{{1,0},{0,1}};
        n -= 2;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = muti(ans, dp);
            }
            dp = Mpow(dp);
            n /= 2;
        }
        return (int)(ans[0][0]%1000000007+ans[1][0]%1000000007)%1000000007;

    }

    private static long[][] muti(long[][] a, long[][] b) {
        long[][] tem = new long[a.length][a[0].length];
        tem[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]);
        tem[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]);
        tem[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]);
        tem[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]);
        return tem;
    }

    private static long[][] Mpow(long[][] dp) {
        long[][] ans = new long[dp.length][dp[0].length];
        ans[0][0] = (dp[0][0] * dp[0][0] + dp[0][1] * dp[1][0]);
        ans[0][1] = (dp[0][0] * dp[0][1] + dp[0][1] * dp[1][1]);
        ans[1][0] = (dp[1][0] * dp[0][0] + dp[1][1] * dp[1][0]);
        ans[1][1] = (dp[1][0] * dp[0][1] + dp[1][1] * dp[1][1]);

        return ans;
    }


    public static void main(String[] args) {
        int n = 50;
        System.out.println(f1(n));
        System.out.println(f2(n));
        System.out.println(f3(n));
        System.out.println("===");


    }




}
