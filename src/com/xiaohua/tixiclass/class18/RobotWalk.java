package com.xiaohua.tixiclass.class18;

/**
 * 假设有排成一行的N个位置记为1~N，N一定大于或等于2
 开始时机器人在其中的M位置上(M一定是1~N中的一个)
 如果机器人来到1位置，那么下一步只能往右来到2位置；
 如果机器人来到N位置，那么下一步只能往左来到N-1位置；
 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 给定四个参数 N、M、K、P，返回方法数
 * @author xiaohua
 * @create 2022-07-01 0:00
 */


public class RobotWalk {

    public static int ma1(int N, int start, int aim, int K){
        return f1(N, start,aim,K);
    }
    public static int f1(int N, int start, int aim, int K){
        if (K==0){
            return start==aim?1:0;
        }
        if (start==1){
            return f1(N, 2, aim, K-1);
        }
        if (start == N) {
            return f1(N, N - 1, aim, K-1);
        }
        return f1(N, start- 1, aim, K-1) + f1(N, start + 1,  aim, K-1);

    }

    public static int ways1(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        return process1(start, K, aim, N);
    }

    // 机器人当前来到的位置是cur，
    // 机器人还有rest步需要去走，
    // 最终的目标是aim，
    // 有哪些位置？1~N
    // 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) { // 如果已经不需要走了，走完了！
            return cur == aim ? 1 : 0;
        }
        // (cur, rest)
        if (cur == 1) { // 1 -> 2
            return process1(2, rest - 1, aim, N);
        }
        // (cur, rest)
        if (cur == N) { // N-1 <- N
            return process1(N - 1, rest - 1, aim, N);
        }
        // (cur, rest)
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }


    public static int ma2(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(N, start, aim, K, dp);
    }

    private static int f2(int N, int start, int aim, int K, int[][] dp) {
//        System.out.println("start:"+start+"  K:"+K);
        if (dp[start][K]!=-1){
            return dp[start][K];
        }
        int ans = 0;
        if (K==0){
            ans = start == aim ? 1 : 0;
        }else if (start == 1) {
            ans = f2(N, 2, aim, K - 1, dp);
        }else if (start == N) {
            ans = f2(N, N - 1, aim, K - 1, dp);
        }else {
            ans = f2(N, start - 1, aim, K - 1, dp) + f2(N, start + 1, aim, K - 1, dp);
        }
        dp[start][K] = ans;
        return ans;

    }

    // dp[0].length  是行的个数
    // dp.length 是列的个数
    public static int ma3(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K + 1];
        //第一列填完
        dp[aim][0]=1;
        for (int i = 1; i <dp[0].length ; i++) {
            dp[1][i] = dp[2][i-1];
            for (int j = 2; j < dp.length-1; j++) {
                System.out.println("j:"+j+" i:"+i);
                dp[j][i]=dp[j-1][i-1]+dp[j+1][i-1];

            }

            dp[N][i] = dp[N-1][i - 1];

        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"\t");

            }
            System.out.println();

        }
        return dp[start][K];
    }

    public static void main(String[] args) {
        System.out.println(ways1(4, 2, 4, 3));
        System.out.println(ma1(5, 2, 4, 6));
        System.out.println(ma2(5, 2, 4, 6));
        System.out.println(ma3(5, 2, 4, 6));
    }

}
