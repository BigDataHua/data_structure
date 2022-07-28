package com.xiaohua.tixiclass.class27;

/**
 * @author xiaohua
 * @create 2022-07-28 1:19
 */
public class KMP {

    public static int KMPRealise(String s1,String s2) {

        if (s1 == null || s2 == null || s1.length() < s2.length() || s2.length() < 1) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] nextArr = getStrNext(str2);
        int x = 0;
        int y = 0;

        while (x < str1.length && y < str2.length) {

            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (nextArr[y]!=-1) {
                y = nextArr[y];
            } else {//y==0
                x++;
            }

        }
        return y == str2.length ? x - y : -1;

    }

    public static int[] getStrNext(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1};
        }
        int[] ans = new int[str2.length];
        ans[0] = -1;
        ans[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < str2.length) {
            if (str2[index - 1] == str2[cn]) {
                ans[index++] = ++cn;
            }else if (cn>0){
                cn = ans[cn];
            }else {
                ans[index++]=0;
            }
        }
        return ans;
    }
    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (KMPRealise(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }



}
