package com.xiaohua.tixiclass.class26;

/**
 * @author xiaohua
 * @create 2022-07-26 23:48
 */
public class OntTwoToN {

//    刷题总结：忽然之间  对于返回值是 a[0][0]+a[1][0]有了疑惑
//    前面的系数是由递归公式前面的系数得出的 因此不要再疑惑了
//    一个人可以一次往上迈1个台阶，也可以迈2个台阶，返回迈上N级台阶的方法数

    public static int getN1(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getN1(n - 1) + getN1(n - 2);
    }

    public static int getN2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[][] dp = new int[][]{
                {1, 1},
                {1, 0}
        };
        int[][] ans = mitul(dp, n - 2);
        return ans[0][0]  + ans[1][0];


    }

    private static int[][] mitul(int[][] dp, int N) {

        int[][] ans = new int[][]{{1, 1}, {1, 0}};
        while (N != 0) {
            if ((N&1)==1){
                ans = mi(ans, dp);
            }
            dp = mi(dp,dp);
            N /= 2;
        }
        return ans;

    }

    private static int[][] mi(int[][] a, int[][] b) {
        int[][] ans = new int[a.length][b[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {

                for (int k = 0; k < a[0].length; k++) {
                    ans[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getN1(n));
        System.out.println(getN2(n));

    }

}
