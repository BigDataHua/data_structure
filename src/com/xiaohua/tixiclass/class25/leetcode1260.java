package com.xiaohua.tixiclass.class25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaohua
 * @create 2022-07-20 0:26
 */
public class leetcode1260 {

    public void swap(int[] arr,int left,int right){
        while (left < right) {
            int tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;
            left++;
            right--;
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int N = grid.length;
        int M = grid[0].length;
        while (k>N*M){
            k -= (N * M);
        }
        int[] dp = new int[N * M];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[index++] = grid[i][j];
            }
        }
        swap(dp, 0, dp.length - 1 - k);
        swap(dp, dp.length - k, dp.length - 1);
        swap(dp, 0, dp.length-1);
        index = 0;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                list.add(dp[index++]);
            }
            lists.add(list);
        }
        return lists;
    }

}
