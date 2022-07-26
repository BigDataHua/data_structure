package com.xiaohua.tixiclass.class19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohua
 * @create 2022-07-02 22:14
 */
public class leetcode22 {

    public  static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        process(n-1,n-1,list,"");
        return list;
    }

    private static void process(int left,int right ,ArrayList<String> list, String path) {
        if (left>right){
            return;
        }
        if (left==-1&&right==-1){
            list.add(path);
            return;
        }
        if (left==-1){
            process(left,right-1,list,path+")");
        }else {
            process(left-1,right,list,path+"(");
            process(left,right-1,list,path+")");
        }


    }

    //这个到底能不能搞出动态规划表？
    public  static List<String> generateParenthesis1(int n){
        ArrayList<String> list = new ArrayList<>();
        String[][] dp = new String[n][n];


        return list;
    }



    public static void main(String[] args) {
        List<String> list = generateParenthesis(1);
        int i = 0;
        for (String s : list) {
            System.out.println(s);
//            System.out.println(i++);
        }
    }
}
