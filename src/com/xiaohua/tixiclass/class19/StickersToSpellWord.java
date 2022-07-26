package com.xiaohua.tixiclass.class19;



import java.util.HashMap;

/**
 给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文
 arr每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来
 返回需要至少多少张贴纸可以完成这个任务
 例子：str= "babac"，arr = {"ba","c","abcd"}
 ba + ba + c  3  abcd + abcd 2  abcd+ba 2
 所以返回2
 * @author xiaohua
 * @create 2022-07-02 11:18
 */
public class StickersToSpellWord {

    public int minStickers(String[] stickers, String target) {
        if (stickers == null || target == null || stickers.length < 1 || target.length() < 1) {
            return -1;
        }
        int ans = process(stickers,target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int process(String[] stickers, String target) {

        if (target.length()<=1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        //遍历每一个贴纸
        for (String sticker : stickers) {
            //minus用来减去用了当前贴纸还剩下哪些字符
            String rest=minus(sticker,target);
            if(rest.length()!=sticker.length()){
                min = Math.min(min, process(stickers, rest));
            }

        }

        return min+(min==Integer.MAX_VALUE?0:1);
    }

    private String minus(String sticker, String target) {
        int[] arrS = new int[26];
        int[] arrT = new int[26];
        for (char c : sticker.toCharArray()) {
            arrS[c - 'a'] += 1;
        }
        for (char c : target.toCharArray()) {
            arrT[c - 'a'] += 1;
        }
        for (int i = 0; i < arrS.length; i++) {
            arrS[i]=arrS[i]-arrT[i];
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i] > 0) {
                sb.append((i+'a')*arrS[i]);
            }
        }
        return sb.toString();
    }


    public static int minStickers1(String[] stickers, String target) {
        if (stickers == null || target == null || stickers.length < 1 || target.length() < 1) {
            return -1;
        }
        char[][] stickerSS = new char[stickers.length][26];
        //提前生成贴纸数组
        for (int i = 0; i <stickers.length ; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerSS[i][c - 'a']++;
            }
        }


        int ans = process1(stickerSS,target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int process1(char[][] stickerSS, String target) {

        if (target.length() ==0){
            return 0;
        }
        int[] countT = new int[26];

        for (int i =0;i<target.length();i++) {

            countT[target.charAt(i)-'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (char[] ss : stickerSS) {
            if (ss[target.charAt(0)-'a']>0){
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < countT.length; i++) {
                    int num = countT[i] - ss[i];
                    if (num>0){
                        for (int j = 0; j < num; j++) {

                            stringBuffer.append((char)('a'+i));
                        }
                    }
                }
                String sb = stringBuffer.toString();
                if (target!=sb){
                    min = Math.min(min, process1(stickerSS, sb));
                }
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }


    public  int minStickers2(String[] stickers, String target) {
        if (stickers == null || target == null || stickers.length < 1 || target.length() < 1) {
            return -1;
        }
        char[][] stickerSS = new char[stickers.length][26];
        for (int i = 0; i <stickers.length ; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerSS[i][c - 'a']++;
            }

        }

        HashMap<String, Integer> smap = new HashMap<>();
        int ans = process2(stickerSS,target,smap);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private  int process2(char[][] stickerSS, String target, HashMap<String, Integer> smap) {
        if (smap.get(target)!=null) {
            return smap.get(target);
        }
        if (target.length() ==0){
            return 0;
        }
        int[] countT = new int[26];

        for (int i =0;i<target.length();i++) {

            countT[target.charAt(i)-'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (char[] ss : stickerSS) {
            if (ss[target.charAt(0)-'a']>0){
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < countT.length; i++) {
                    int num = countT[i] - ss[i];
                    if (num>0){
                        for (int j = 0; j < num; j++) {

                            stringBuffer.append((char)('a'+i));
                        }
                    }
                }
                String sb = stringBuffer.toString();
                if (target!=sb){
                    min = Math.min(min, process1(stickerSS, sb));
                }
            }
        }
        smap.put(target,min + (min == Integer.MAX_VALUE ? 0 : 1));
        return min + (min == Integer.MAX_VALUE ? 0 : 1);

    }

    public static void main(String[] args) {
        String[] s = {"with", "example", "science"};
        minStickers1(s,"theheat");
    }


}
