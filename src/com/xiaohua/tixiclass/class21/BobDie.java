package com.xiaohua.tixiclass.class21;

/**
 *
 * 给定5个参数，N，M，row，col，k
 表示在N*M的区域上，醉汉Bob初始在(row,col)位置
 Bob一共要迈出k步，且每步都会等概率向上下左右四个方向走一个单位
 任何时候Bob只要离开N*M的区域，就直接死亡
 返回k步之后，Bob还在N*M的区域的概率
 --------------------------------------------------------
 *
 * @author xiaohua
 * @create 2022-07-08 0:40
 */
public class BobDie {

    public static double livePosibility1(int row, int col, int k, int N, int M) {
        return (double) process(row, col, k, N, M) / Math.pow(4, k);
    }

    private static int process(int row, int col, int k, int n, int m) {
        if (col<0||col>n||row>m||row<0){
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int way = process(row + 1, col, k - 1, n, m);
        way += process(row - 1 , col, k - 1, n, m);
        way += process(row , col+1, k - 1, n, m);
        way += process(row , col-1, k - 1, n, m);
        return way;
    }

    public static double livePosibility2(int row, int col, int k, int N, int M) {
        long[][][] dp = new long[k+1][N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[0][i][j] = 1;
            }
        }
        for (int degree = 1;degree <=k; degree++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dp[degree][i][j] += pick(dp, N, M, i+1, j, degree - 1);
                    dp[degree][i][j] += pick(dp, N, M, i, j+1, degree - 1);
                    dp[degree][i][j] += pick(dp, N, M, i, j-1, degree - 1);
                    dp[degree][i][j] += pick(dp, N, M, i-1, j, degree - 1);

                }

            }

        }

        return ((double) dp[k][row][col]) / Math.pow(4, k);
    }

    public static long pick(long[][][] dp, int N, int M, int r, int c, int rest) {
        if (r < 0 || r == N || c < 0 || c == M) {
            return 0;
        }
        return dp[rest][r][c];
    }

    public static void main(String[] args) {
        System.out.println(livePosibility1(6, 6, 10, 50, 50));
        System.out.println(livePosibility2(6, 6, 10, 50, 50));
    }


}
