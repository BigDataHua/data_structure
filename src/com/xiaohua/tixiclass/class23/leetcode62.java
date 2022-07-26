package com.xiaohua.tixiclass.class23;

/**
 * @author xiaohua
 * @create 2022-07-12 9:07
 */
public class leetcode62 {
//  leetcode 62
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }
    //leetcode 63
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0]+grid[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <dp[0].length ; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1])+grid[i][j];
            }
        }
        return dp[M - 1][N - 1];
    }

}
