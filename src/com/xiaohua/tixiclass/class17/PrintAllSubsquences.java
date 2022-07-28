package com.xiaohua.tixiclass.class17;

import com.xiaohua.tixiclass.PublicTmpTest;

import java.util.ArrayList;
import java.util.List;

/**打印所有子序列
 * 打印所有不重复的子序列  只需要将生成的答案换成set即可
 * @author xiaohua
 * @create 2022-06-28 23:45
 */
public class PrintAllSubsquences {

    public static List<String> sub(String s){
        ArrayList<String> ans = new ArrayList<>();

        process(s.toCharArray(), 0, ans, "");
        return ans;
    }

    private static void process(char[] s, int index, ArrayList<String> ans, String path) {
        if (index==s.length){
            ans.add(path);
            return;
        }
        process(s,index+1,ans,path);
        process(s,index+1,ans,path+s[index]);

    }

    public static void main(String[] args) {
        String test = "abc";
        List<String> ans1 = sub(test);
//        List<String> ans2 = subsNoRepeat(test);

        for (String str : ans1) {
            System.out.println(str);
        }
//        System.out.println("=================");
//        for (String str : ans2) {
//            System.out.println(str);
//        }
//        System.out.println("=================");

    }
}
