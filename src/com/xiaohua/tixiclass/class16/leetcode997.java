package com.xiaohua.tixiclass.class16;

/**
 * @author xiaohua
 * @create 2022-06-26 0:44
 */
public class leetcode997 {

    public int findJudge(int n, int[][] trust) {
        if (trust.length==0){
            return 0;
        }
        int[] ansArr = new int[n+1];
        for (int[] arr : trust) {
            ansArr[arr[0]]--;
            ansArr[arr[1]]++;
        }
        for (int i = 0; i < ansArr.length; i++) {
            if (ansArr[i]==n-1){
                return i;
            }

        }
        return -1;

    }

}
