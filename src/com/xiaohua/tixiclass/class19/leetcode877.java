package com.xiaohua.tixiclass.class19;

/**
 * @author xiaohua
 * @create 2022-07-03 0:22
 */
public class leetcode877 {

    public boolean stoneGame1(int[] piles) {
        int frist = f(piles, 0, piles.length - 1);
        int sec = g(piles, 0, piles.length - 1);
        return frist> sec;
    }

    private int g(int[] piles, int left, int right) {
        if (left == right) {
            return 0;
        }
        int p1 = f(piles, left + 1, right);
        int p2 = f(piles, left, right - 1);
        return Math.min(p1, p2);
    }

    private int f(int[] piles, int left, int right) {
        if (left == right) {
            return piles[left];
        }
        int p1 = piles[left] + g(piles, left + 1, right);
        int p2 = piles[right] + g(piles, left, right - 1);
        return Math.max(p1, p2);
    }
    public boolean stoneGame(int[] nums) {
        int[][] f = new int[nums.length][nums.length];
        int[][] g = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i][i] = nums[i];
            g[i][i] = 0;
        }
        for (int i = 1; i <nums.length ; i++) {
            int left= 0;
            int right = i;
            while (right < nums.length) {
                f[left][right] = Math.max(nums[left] + g[left + 1][right], nums[right] + g[left][right - 1]);
                g[left][right] = Math.min(f[left + 1][right], f[left][right - 1]);
                left++;
                right++;
            }
        }



        return f[0][nums.length-1]> g[0][nums.length-1];
    }

    public static void main(String[] args) {
        new leetcode877().stoneGame(new int[]{5, 3, 4, 5});
    }
}
