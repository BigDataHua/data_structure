package com.xiaohua.tixiclass.class19;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * @author xiaohua
 * @create 2022-07-02 20:15
 */
public class LongestCommonSubsequenceProblem {


    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() < 1 || text2.length() < 1) {
            return 0;
        }
        return process(text1.toCharArray(), text2.toCharArray(), text1.length() - 1, text2.length() - 1);
    }

    private int process(char[] text1, char[] text2, int index1, int index2) {
        if (index1==index2&&index1==0){
            return text1[index1] == text2[index2] ? 1 : 0;
        }
        if (index1 == 0) {
            if (text1[index1]==text2[index2]){
                return 1;
            }else {
                return process(text1, text2, index1, index2 - 1);
            }
        }else if(index2== 0){
            if (text1[index1]==text2[index2]){
                return 1;
            }else {
                return process(text1, text2, index1-1, index2);
            }
        }else {
            int p1 = process(text1, text2, index1 - 1, index2);
            int p2 = process(text1, text2, index1, index2 - 1);
            int p3 = text1[index1] == text2[index2] ? 1 + process(text1, text2, index1 - 1, index2 - 1) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() < 1 || text2.length() < 1) {
            return 0;
        }
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int[][] dp = new int[text1.length()][text2.length()];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str2.length; i++) {
            dp[i][0] = str1[0] == str2[i] ? 1 : dp[i-1][0];
        }
        for (int i = 1; i <str1.length ; i++) {
            dp[0][i] = str1[i] == str2[0] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1[i] == str2[j] ? 1 + dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }

        }
        return dp[text1.length() - 1][text2.length() - 1];
    }



}
