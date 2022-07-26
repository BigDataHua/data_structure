package com.xiaohua.tixiclass.class25;

import java.util.Stack;

/**
 * @author xiaohua
 * @create 2022-07-20 0:55
 */
public class MaximalRectangle {


    /*
    * 刷题心得： 看到柱子类型的题目，往单调栈上靠
    *           看能不能转为以当前为最小值 并 往外扩求出以当前为最小值的最大值
    *           另外注意  扩张的范围要注意确定好
    * */
    public int maximalRectangle(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int N = matrix.length;
        int M = matrix[0].length;
        int[] dp = new int[M];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            int index = 0;
            for (int j = 0; j < M; j++,index++) {
                dp[index] = matrix[i][j] == 0 ? 0 : dp[index]+1;
            }

            for (int j = 0; j < dp.length; j++) {
                while (!st.isEmpty() && dp[st.peek()] >= dp[j]) {
                    Integer pop = st.pop();
                    ans = Math.max(ans, (st.isEmpty() ? j : j - st.peek() - 1) * dp[pop]);
                }
                st.push(j);
            }

            while (!st.isEmpty()){
                Integer pop = st.pop();
                ans = Math.max(ans, (st.isEmpty() ? dp.length : dp.length - st.peek() - 1) * dp[pop]);
            }

        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(new int[][]{
                {1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 0}

        }));
    }
}
