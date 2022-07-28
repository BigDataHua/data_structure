package com.xiaohua.tixiclass.class23;

/**
 * n皇后问题
 * leetcode52
 * @author xiaohua
 * @create 2022-07-13 0:42
 */
public class NQueen {

    //暴力递归版
    public int totalNQueens1(int n) {
        int[] dp = new int[n];
        return process1(0,dp);
    }
    private int process1(int index, int[] dp) {
        if (index==dp.length){
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (isVaild(dp,index,i)){
                dp[index] = i;
                ans += process1(index + 1, dp);
            }
        }
        return ans;
    }
    private boolean isVaild(int[] dp, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (dp[i] == col || (Math.abs(i - row) == Math.abs(dp[i] - col))) {
                return false;
            }
        }
        return true;
    }

    //位运算
    public int totalNQueens(int n) {
        int limit = (1 << n) - 1;
        return process(limit,0,0,0);
    }

    private int process(int limit, int colLimit, int leftLimit, int rightLimit) {
        if (limit == colLimit) {
            return 1;
        }
        int pos = limit & (~(colLimit | leftLimit | rightLimit));
        int ans = 0;
        while (pos!=0){

            int index = pos & (~pos + 1);
            pos -= index;
            ans+=process(limit,colLimit|index,(leftLimit|index)<<1,(rightLimit|index)>>>1);

        }

        return ans;
    }


}
