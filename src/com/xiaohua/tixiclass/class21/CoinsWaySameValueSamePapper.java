package com.xiaohua.tixiclass.class21;

import java.util.HashMap;
import java.util.Set;

/**
 *
 *
 * arr是货币数组，其中的值都是正数。再给定一个正数aim。
 每个值都认为是一张货币，
 认为值相同的货币没有任何不同，
 返回组成aim的方法数
 例如：arr = {1,2,1,1,2,1,2}，aim = 4
 方法：1+1+1+1、1+1+2、2+2
 一共就3种方法，所以返回3
 ----------------------------------------------
 货币纸张限制类题目  那么
 你需要考虑 你会不会多算重一个单元的值？？
 你需要的是  你下一行的I位置 加上 你当前行的前一个coin的位置，同样你当前行前一个的位置
 你需要的是 你下一行  i位置 i-（coin*1） ...i-（coin*zhang）  而你当前行的前一个需要
 你下一行  i位置 （i-coin）-（coin*1） ...（i-coin）-（coin*zhang）
 你会多加了一个当前行（i-coin）-（coin*zhang）的位置  所以要减掉  这个位置可以为当前行的0索引位置
 * @author xiaohua
 * @create 2022-07-07 1:29
 */
public class CoinsWaySameValueSamePapper {
    public static class Info {
        public int[] coins;
        public int[] zhangs;

        public Info(int[] c, int[] z) {
            coins = c;
            zhangs = z;
        }
    }
    public static Info getInfo(int[] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = hashMap.get(arr[i]) == null ? 0 : hashMap.get(arr[i]);
            hashMap.put(arr[i], count + 1);
        }
        Set<Integer> keySet = hashMap.keySet();
        int[] coins = new int[hashMap.size()];
        int[] zhangs = new int[hashMap.size()];
        int index = 0;
        for (Integer key : keySet) {
            coins[index] = key;
            zhangs[index++] = hashMap.get(key);
        }
        return new Info(coins, zhangs);
    }

    public static int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        return process(info.coins, info.zhangs, 0, aim);
    }

    private static int process(int[] coins, int[] zhangs, int index, int aim) {
        if (index == coins.length) {
            return aim == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang <= zhangs[index]&& zhang*coins[index]<=aim; zhang++) {
            ways += process(coins, zhangs, index + 1, aim - (coins[index]*zhang));
        }
        return ways;

    }



    public static int dp1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for(int index = N-1;index>=0;index--) {

            for (int i = 0; i <= aim; i++) {

                int ways = 0;
                for (int zhang = 0; zhang <= zhangs[index]&& zhang*coins[index]<=i; zhang++) {
                    ways += dp[index + 1][ i - (coins[index]*zhang)];
                }
                dp[index][i] = ways;
            }
        }

        return dp[0][aim];



    }

    public static int dp2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for(int index=N-1;index>=0;index--) {

            for(int i = 0;i<=aim;i++){

                dp[index][i] = dp[index + 1][i];
                if (i-coins[index]>=0){
                    dp[index][i] += dp[index][i-coins[index]];
                }
                if (i - (zhangs[index] + 1) * coins[index] >= 0) {
                    dp[index][i] -= dp[index + 1][i - (zhangs[index] + 1) * coins[index]];
                }
            }

        }
        return dp[0][aim];
    }

    // 为了测试
    public static int[] randomArray(int maxLen, int maxValue) {
        int N = (int) (Math.random() * maxLen);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
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
        int maxValue = 20;
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
