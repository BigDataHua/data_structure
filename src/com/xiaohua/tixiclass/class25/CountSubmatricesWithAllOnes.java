package com.xiaohua.tixiclass.class25;

import java.util.Stack;

/**
 * @author xiaohua
 * @create 2022-07-21 1:01
 */
public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int ans = 0;
        int N = mat.length;
        int M = mat[0].length;
        int[] dp = new int[M];
        int[] st = new int[M];
        int index = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[j] = mat[i][j] == 0 ? 0 : dp[j] + 1;
            }

            for (int j = 0; j < M; j++) {

                while (index!=-1 && dp[st[index]] >= dp[j]) {
                    if (dp[st[index]] == dp[j]) {
                        index--;
                    }else {
                        Integer pop = st[index--];
                        ans += (dp[pop] - Math.max(dp[j], index!=-1 ? 0 : dp[st[index]]))
                                *(j-(index!=-1?-1:st[index])-1)
                                *(j-(index!=-1?-1:st[index]))/2;
                    }
                }
                st[++index]=j;

            }
            while (index!=-1) {
                Integer pop = st[index--];
                ans += (dp[pop] -(index!=-1 ? 0 : dp[st[index]]))
                        *(dp.length-(index!=-1?-1:st[index])-1)
                        *(dp.length-(index!=-1?-1:st[index]))/2;
            }


        }




        return ans;
    }

}
