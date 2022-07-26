package com.xiaohua.tixiclass.class22;

/**
 * @author xiaohua
 * @create 2022-07-11 1:34
 */
public class MinCoinsNoLimit {

    /*
    * arr是面值数组，其中的值都是正数且没有重复。再给定一个正数aim。
每个值都认为是一种面值，且认为张数是无限的。
返回组成aim的最少货币数

    本题位置依赖有点难搞   注意怎么依赖
    dp[index][rest-arr[index]] 是加1以后与 dp[index+1][rest]进行pk
    为什么？因为你那个格子已经使用了一张arr[index]的面值

    * */

    public static int minCoins(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    // arr[index...]面值，每种面值张数自由选择，
    // 搞出rest正好这么多钱，返回最小张数
    // 拿Integer.MAX_VALUE标记怎么都搞定不了
    private static int process(int[] arr, int index, int aim) {
        if (index == arr.length) {
            return aim == 0 ? 0 : Integer.MAX_VALUE;
        }
        else {
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i * arr[index] <= aim; i++) {
                int next = process(arr, index + 1, aim - (i * arr[index]));
                if (next != Integer.MAX_VALUE) {
                    ans = Math.min(next + i, ans);
                }
            }
            return ans;
        }
    }




    public static int dp1(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
//        java数组默认初始值为0
//        dp[N][0]=0
        for (int i = 1; i <= aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }

        for (int index = N - 1; index >=0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = Integer.MAX_VALUE;
                for (int i = 0; i * arr[index] <= rest; i++) {
                    int next = dp[ index + 1][ rest - (i * arr[index])];
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(next + i, ans);
                    }
                }
                dp[index][rest]=ans;
            }
        }


        return dp[0][aim];
    }
    public static int dp2(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
//        java数组默认初始值为0
//        dp[N][0]=0
        for (int i = 1; i <= aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }

        for (int index = N - 1; index >=0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0
                        &&
                        dp[index][rest - arr[index]] != Integer.MAX_VALUE) {
                    dp[index][rest] = Math.min(dp[index][rest], dp[index][rest - arr[index]] + 1);
                }
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
        int maxLen = 20;
        int maxValue = 30;
        int testTime = 300000;
        System.out.println("功能测试开始");
        for (int i = 0; i < testTime; i++) {
            int N = (int) (Math.random() * maxLen);
            int[] arr = randomArray(N, maxValue);
            int aim = (int) (Math.random() * maxValue);
            int ans1 = minCoins(arr, aim);
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
        System.out.println("功能测试结束");
    }



}
