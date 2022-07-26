package com.xiaohua.tixiclass.class23;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.regexp.internal.RE;
import com.xiaohua.tixiclass.class16.Edge;

/**
 * @author xiaohua
 * @create 2022-07-14 0:43
 */
public class SplitSumClosedSizeHalf {

    /*
    *
给定一个正数数组arr，请把arr中所有的数分成两个集合
如果arr长度为偶数，两个集合包含数的个数要一样多
如果arr长度为奇数，两个集合包含数的个数必须只差一个
请尽量让两个集合的累加和接近
返回最接近的情况下，较小集合的累加和
    *
    * */

    public static int right(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (arr.length%2==0){
            return process(arr, 0, sum / 2, arr.length/2);
        }else {
            return Math.max(process(arr, 0, sum / 2, (arr.length + 1) / 2), process(arr, 0, sum / 2, arr.length / 2));
        }

    }

    private static int process(int[] arr, int index, int target, int size) {
        if (index == arr.length) {
            return size == 0 ? 0 : -1;
        }

        int p1 = process(arr, index + 1, target, size);
        int p2 = -1;
        if (arr[index] <= target) {
            int next = process(arr, index + 1, target - arr[index], size - 1);
            if (next != -1) {
                p2 = (arr[index] + next);
            }
        }
        return Math.max(p1,p2);


    }


    public static int dp(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int N = arr.length;
        sum /= 2;
        int picks = (N+1)/2;
        int[][][] dp = new int[N + 1][picks+1][sum+1];
        for (int i = 0; i <=N; i++) {
            for (int j = 0; j <= picks; j++) {
                for (int k = 0; k <= sum; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        for (int i = 0; i <= sum; i++) {
            dp[N][0][i] = 0;
        }

        for (int index = N-1; index >=0 ; index--) {

            for (int pick = 0; pick <= picks; pick++) {

                for (int rest = 0; rest <= sum; rest++) {
                    int p1 = dp[index + 1][pick][rest];
                    int p2 = -1;
                    if (pick-1>=0&&arr[index]<=rest){

                        int next = dp[index + 1][pick - 1][rest - arr[index]];
                        if (next != -1) {
                            p2 = arr[index] + next;
                        }

                    }

                    dp[index][pick][rest] = Math.max(p1, p2);

                }

            }

        }

        if (arr.length%2==0){
            return dp[ 0][ N/2][ sum];
        }else {
            return Math.max(dp[0][ (N + 1)/2][ sum ], dp[0][ N / 2][ sum ]);
        }
    }





    public static int dp2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        sum >>= 1;
        int N = arr.length;
        int M = (arr.length + 1) >> 1;
        int[][][] dp = new int[N][M + 1][sum + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= sum; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int k = 0; k <= sum; k++) {
                dp[i][0][k] = 0;
            }
        }
        for (int k = 0; k <= sum; k++) {
            dp[0][1][k] = arr[0] <= k ? arr[0] : Integer.MIN_VALUE;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= Math.min(i + 1, M); j++) {
                for (int k = 0; k <= sum; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (k - arr[i] >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k - arr[i]] + arr[i]);
                    }
                }
            }
        }
        return Math.max(dp[N - 1][M][sum], dp[N - 1][N - M][sum]);
    }

    // for test
    public static int[] randomArray(int len, int value) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 10;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * maxLen);
            int[] arr = randomArray(len, maxValue);
            int ans1 = right(arr);
            int ans2 = dp(arr);
            int ans3 = dp2(arr);
            if (ans1 != ans2 || ans1 != ans3) {
                printArray(arr);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }



}
