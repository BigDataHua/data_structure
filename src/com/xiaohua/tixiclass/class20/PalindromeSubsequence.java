package com.xiaohua.tixiclass.class20;

import com.xiaohua.tixiclass.PublicMethodUtils;

/**
 * @author xiaohua
 * @create 2022-07-04 23:54
 */
public class PalindromeSubsequence {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        return process(s.toCharArray(), 0, s.length() - 1);

    }

    private int process(char[] arr, int left, int right) {
        if (left == right) {
            return 1;
        }
        if (left == right - 1) {
            return arr[left] == arr[right] ? 2 : 1;
        }
        int p1 = process(arr, left + 1, right);
        int p2 = process(arr, left, right - 1);
        int p3 = process(arr, left + 1, right - 1);
        int p4 = arr[left] != arr[right] ? 0 : 2 + process(arr, left + 1, right - 1);
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }


    public int longestPalindromeSubseq1(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int N = arr.length;
        int[][] dp = new int[N][N];
        dp[N - 1][N - 1] = 1;
        for (int i = 0; i <N-1 ; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = arr[i]==arr[i+1]?2:1;
        }

        for (int i = N-3; i >=0; i--) {
            for (int j =i+2 ; j<N  ; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                if (arr[i] == arr[j]) {
                    dp[i][j] = Math.max(dp[i][j],2+dp[i+1][j-1]);
                }
            }

        }
        return dp[0][N - 1];
    }


    public static boolean canJump(int[] nums) {
        return process1(nums, 0);
    }

    public static boolean process1(int[] nums, int index) {
        if (index+1 == nums.length) {
            return true;
        }
        if(index>nums.length){
            return false;
        }
        boolean ans = false;
        for (int i = 1; i <= nums[Math.min(index,nums.length-1)]; i++) {
            ans = process1(nums, index + i)||ans;
        }
        return ans;
    }

    public static boolean canJump1(int[] nums) {
        int[] dp = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            index= Math.max(i + nums[i],index);
            if(index == i&&nums[i]==0){
                return false;
            }

            if (index >= nums.length - 1) {
                dp[nums.length - 1] = 1;
                break;
            }

        }

        return dp[dp.length - 1]>0;
    }


    public static void main(String[] args) {
//        System.out.println(new PalindromeSubsequence().canJump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}));
        System.out.println(new PalindromeSubsequence().canJump1(new int[]{3,0}));
    }
}
