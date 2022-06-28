package com.xiaohua.tixiclass.class17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohua
 * @create 2022-06-28 23:57
 */
public class PrintAllPermutations {

    static class charet{
        char value;

        public charet(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "charet{" +
                    "value=" + value +
                    '}';
        }
    }
    public static List<String> permutation1(String s){
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<charet> str = new ArrayList<>();
        for (char c : s.toCharArray()) {
            str.add(new charet(c));
        }
        process(str,"",ans);
        return ans;
    }

    private static void process(ArrayList<charet> str, String path, ArrayList<String> ans) {
        if (str.isEmpty()){
            ans.add(path);
        }else {
            int N = str.size();
            for (int i = 0; i < N; i++) {
                charet charet = str.get(i);
                str.remove(i);
                process(str,path+charet,ans);
                str.add(i, charet);
            }
        }
    }


    public static List<String> permutation2(String s){
        ArrayList<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        f(str, 0, ans);
        return ans;
    }

    private static void f(char[] str, int index, ArrayList<String> ans) {
        if (index==str.length){
            ans.add(String.valueOf(str));

        }else {
            for (int i = index; i <str.length ; i++) {
                swap(str, index, i);
                f(str,index+1,ans);
                swap(str, index, i);
            }
        }

    }

    public static List<String> permutation3(String s){
        ArrayList<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        g(str, 0, ans);
        return ans;
    }

    private static void g(char[] str, int index, ArrayList<String> ans) {
        if (index==str.length){
            ans.add(String.valueOf(str));
        }else {
            boolean[] visited = new boolean[256];
            for (int i = index; i < str.length; i++) {
                if (!visited[str[i]]) {
                    visited[str[i]] = true;
                    swap(str, index, i);
                    g(str, index + 1,ans);
                    swap(str, index, i);
                }

            }
        }
    }


    private static void swap(char[] str, int i, int j) {
        char tep = str[i];
        str[i] = str[j];
        str[j] = tep;
    }


    public static void main(String[] args) {
        String s = "acc";
        List<String> ans1 = permutation1(s);
        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans2 = permutation2(s);
        for (String str : ans2) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans3 = permutation3(s);
        for (String str : ans3) {
            System.out.println(str);
        }
    }


    }
