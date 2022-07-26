package com.xiaohua.tixiclass.class22;

/**
 * @author xiaohua
 * @create 2022-07-10 23:33
 */
public class KillMonster {

    /*
    * 给定3个参数，N，M，K
怪兽有N滴血，等着英雄来砍自己
英雄每一次打击，都会让怪兽流失[0~M]的血量
到底流失多少？每一次在[0~M]上等概率的获得一个值
求K次打击之后，英雄把怪兽砍死的概率

*/
    public static double right(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        return process(N,M,K)/Math.pow((double)(M+1),(double) K);
    }

    private static double process(int n, int m, int k) {
        if (k==0){
            return n <= 0 ? 1 : 0;
        }
        if (n<=0){
            return Math.pow((double) m + 1, (double) k);
        }
        double ans = 0;
        for (int i = 0; i <=m ; i++) {
            ans+=process(n - i, m, k - 1);
        }
        return ans;
    }

    public static double dp1(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long all = (long) Math.pow((double) M + 1, K);
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int time = 1; time <=K; time++) {
            dp[time][0]=(long) Math.pow((double)M+1,(double)time);
            for (int hp = 1; hp <= N; hp++) {
                long ans = 0;
                for (int i = 0; i <=M ; i++) {
                    if (hp-i>=0){
                        ans += dp[time-1][hp-i];
                    }else {
                        ans+=(long) Math.pow((double)M+1,(double)time-1);
                    }
                }
                dp[time][hp]=ans;
            }
        }
        return (double) ((double) dp[K][N] / (double) all);

    }

    public static double dp2(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long all = (long) Math.pow(M + 1, K);
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int time = 1; time <= K; time++) {
            dp[time][0] = (long) Math.pow((double) M + 1, (double) time);
            for (int hp = 1; hp <=N ; hp++) {
                dp[time][hp] += dp[time - 1][hp];
                dp[time][hp] += dp[time][hp - 1];
                if (hp - (M+1) >= 0) {
                    dp[time][hp]-=dp[time-1][hp-(M+1)];
                }else {
                    dp[time][hp] -= Math.pow((double) M + 1, (double) time-1);
                }

            }

        }


        long kill = dp[K][N];
        return (double) ((double) kill / (double) all);
    }

    public static void main(String[] args) {
        int NMax = 10;
        int MMax = 10;
        int KMax = 10;
        int testTime = 200;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int N = (int) (Math.random() * NMax);
            int M = (int) (Math.random() * MMax);
            int K = (int) (Math.random() * KMax);
            double ans1 = right(N, M, K);
            double ans2 = dp1(N, M, K);
            double ans3 = dp2(N, M, K);
            if (ans1 != ans2 || ans1 != ans3) {
                System.out.println("Oops!");
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                break;
            }
        }
        System.out.println("测试结束");
    }



}
