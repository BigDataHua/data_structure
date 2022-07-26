package com.xiaohua.tixiclass.class21;

/**
 arr是面值数组，其中的值都是正数且没有重复。再给定一个正数aim。
 每个值都认为是一种面值，且认为张数是无限的。
 返回组成aim的方法数
 例如：arr = {1,2}，aim = 4
 方法如下：1+1+1+1、1+1+2、2+2
 一共就3种方法，所以返回3
 * @author xiaohua
 * @create 2022-07-07 0:52
 */
public class CoinsWayNoLimit {

    public static int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int aim) {
        if (aim < 0) {
            return 0;
        }
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }

        int ans = 0;
        for (int zhang = 0; zhang*arr[index] <= aim; zhang++) {
            ans += process(arr, index + 1, aim - (zhang * arr[index]));
        }
        return ans;

    }


    public static int dp1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int i = N-1; i >=0 ; i--) {
            for (int j = 0; j <= aim; j++) {
                int ways = 0;
                for (int k = 0;k*arr[i]<=j; k++) {

                    ways += dp[i + 1][ j - (k * arr[i])];
                }
                dp[i][j] = ways;
            }

        }
        return dp[0][aim];

    }

    public static int dp2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N-1; index >=0 ; index--) {
            for (int target = 0; target <= aim; target++) {
                dp[index][target] = dp[index + 1][target] + (target - arr[index] >= 0 ? dp[index][target - arr[index]] : 0);

            }
        }

        return dp[0][aim];
    }

    // 为了测试
    public static int[] randomArray(int maxLen, int maxValue) {
        int N = (int) (Math.random() * maxLen);
        int[] arr = new int[N];
        boolean[] has = new boolean[maxValue + 1];
        for (int i = 0; i < N; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) + 1;
            } while (has[arr[i]]);
            has[arr[i]] = true;
        }
        return arr;
    }

    // 为了测试
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 为了测试
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int aim = (int) (Math.random() * maxValue);
            int ans1 = coinsWay(arr, aim);
            int ans2 = dp1(arr, aim);
            int ans3 = dp2(arr, aim);
            if (ans1 != ans2 || ans1 != ans3) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println(aim);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                break;
            }
        }
        System.out.println("测试结束");
    }


}
