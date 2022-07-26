package com.xiaohua.tixiclass.class23;

/**
 * @author xiaohua
 * @create 2022-07-13 10:25
 */
public class leetcode91 {

    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0 ;
        }
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int index = N-1; index >=0 ; index--) {
            if(chars[index]=='0'){
                dp[index] = -1;
            }

            int p1 = 0;
            if(chars[index]!='0'){
                int next = dp[index + 1];
                if (next != -1) {
                    p1 += next;
                }

            }
            if (index+1<N&&((chars[index]-'0')*10+(chars[index+1]-'0')<=26)){
                int nextval = process(index + 2, chars);
                if (nextval != -1) {
                    p1 += nextval;
                }
            }
            dp[index] = p1;

        }
        return dp[0];
    }

    public int numDecodings1(String s) {
        if(s.charAt(0)=='0'){
            return 0 ;
        }
        return process(0, s.toCharArray());
    }

    private int process(int index, char[] chars) {
        if (index==chars.length){
            return 1;
        }
        if(chars[index]=='0'){
            return -1;
        }
        int p1 = 0;
        if(chars[index]!='0'){
            int next = process(index + 1, chars);
            if (next != -1) {
                p1 += next;
            }

        }
        if (index+1<chars.length&&((chars[index]-'0')*10+(chars[index+1]-'0')<=26)){
            int nextval = process(index + 2, chars);
            if (nextval != -1) {
                p1 += nextval;
            }
        }
        return p1;
    }


    public static void main(String[] args) {
        System.out.println(new leetcode91().numDecodings("226"));
    }

}
