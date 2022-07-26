package com.xiaohua.tixiclass.class19;

/**
 * 规定1和A对应、2和B对应、3和C对应...26和Z对应
 那么一个数字字符串比如"111”就可以转化为:
 "AAA"、"KA"和"AK"
 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 * @author xiaohua
 * @create 2022-07-02 7:22
 */
public class ConvertToLetterString {
    // str只含有数字字符0~9
    // 返回多少种转化方案
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    private static int process(char[] chars, int index) {
        if (index == chars.length) {
            return 1;
        }
        if (chars[index] == '0') {
            return 0;
        }
        int p1 = process(chars, index + 1);
        int p2 = 0;
        if (index + 1 < chars.length && (chars[index] - '0')*10 + chars[index + 1] - '0' < 27) {
            p2 =process(chars, index + 2);
        }
        return p1+ p2;
    }

    public static int dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int index = N-1; index >=0 ; index--) {
            if (str[index] != '0') {
                int p1 = dp[index + 1];
                int p2 = 0;
                if (index + 1 < str.length && (str[index] - '0')*10 + str[index + 1] - '0' < 27) {
                    p2 =dp[index + 2];
                }
                dp[index]= p1+ p2;
            }

        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(number("7210231231232031203123"));
        System.out.println(dp("7210231231232031203123"));
    }


}
