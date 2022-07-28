package com.xiaohua.tixiclass.class20;

/**请同学们自行搜索或者想象一个象棋的棋盘，
 然后把整个棋盘放入第一象限，棋盘的最左下角是(0,0)位置
 那么整个棋盘就是横坐标上9条线、纵坐标上10条线的区域
 给你三个 参数 x，y，k
 返回“马”从(0,0)位置出发，必须走k步
 最后落在(x,y)上的方法数有多少种?
 * @author xiaohua
 * @create 2022-07-05 1:19
 */
public class HorseJump {

    // 当前来到的位置是（x,y）
    // 还剩下rest步需要跳
    // 跳完rest步，正好跳到a，b的方法数是多少？
    // 10 * 9
//    public static int jump(int a, int b, int k) {
//        return process(0, 0, k, a, b);
//    }
//
//    private static int process(int y, int x, int rest, int a, int b) {
//        if (x < 0 || x > 9 || y < 0 || y > 8) {
//            return 0;
//        }
//        if (rest == 0) {
//            return (x == a && y == b) ? 1 : 0;
//        }
//        int ways = process(x + 2, y + 1, rest - 1, a, b);
//        ways += process(x + 1, y + 2, rest - 1, a, b);
//        ways += process(x - 1, y + 2, rest - 1, a, b);
//        ways += process(x - 2, y + 1, rest - 1, a, b);
//        ways += process(x - 2, y - 1, rest - 1, a, b);
//        ways += process(x - 1, y - 2, rest - 1, a, b);
//        ways += process(x + 1, y - 2, rest - 1, a, b);
//        ways += process(x + 2, y - 1, rest - 1, a, b);
//        return ways;
//
//    }

    public static int getNum(int[][][] dp ,int x,int y,int degree){
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][degree];
    }

    public static int waysdp(int a, int b, int s) {

        int[][][] dp = new int[10][9][s+1];
        dp[a][b][0] = 1;
        for (int rest = 1; rest <=s ; rest++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 9; y++) {
                    int ways = getNum(dp, x + 2, y + 1, rest - 1);
                    ways += getNum(dp, x + 1, y + 2, rest - 1);
                    ways += getNum(dp, x - 1, y + 2, rest - 1);
                    ways += getNum(dp, x -2, y + 1, rest - 1);
                    ways += getNum(dp, x -2, y - 1, rest - 1);
                    ways += getNum(dp, x - 1, y - 2, rest - 1);
                    ways += getNum(dp, x + 1, y - 2, rest - 1);
                    ways += getNum(dp, x + 2, y - 1, rest - 1);
                    dp[x][y][rest] = ways;
                }
            }
        }
        return dp[0][0][s];

    }

    // 在dp表中，得到dp[i][j][step]的值，但如果(i，j)位置越界的话，返回0；



    public static int jump1(int a, int b, int k) {
        return process1(0, 0, k, a, b);
    }

    public static int process1(int x, int y, int rest, int a, int b) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        if (rest == 0) {
            return (x == a && y == b) ? 1 : 0;
        }
        int ways = process1(x + 2, y + 1, rest - 1, a, b);
        ways += process1(x + 1, y + 2, rest - 1, a, b);
        ways += process1(x - 1, y + 2, rest - 1, a, b);
        ways += process1(x - 2, y + 1, rest - 1, a, b);
        ways += process1(x - 2, y - 1, rest - 1, a, b);
        ways += process1(x - 1, y - 2, rest - 1, a, b);
        ways += process1(x + 1, y - 2, rest - 1, a, b);
        ways += process1(x + 2, y - 1, rest - 1, a, b);
        return ways;
    }


    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(jump1(x, y, step));
        System.out.println(waysdp(x, y, step));

//        System.out.println(jump(x, y, step));
    }


}
