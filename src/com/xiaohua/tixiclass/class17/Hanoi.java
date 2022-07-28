package com.xiaohua.tixiclass.class17;

/** 汉诺塔问题
 * @author xiaohua
 * @create 2022-06-28 0:59
 */
public class Hanoi {
    public static void h1(int n){
        if (n==0){
            return;
        }
        leftToRight(n);
    }
    public static void leftToRight(int N){
        if (N==1){
            System.out.println("从左到右:"+N);
            return;
        }
        leftToMid(N - 1);
        System.out.println("从左到右："+N);
        midToRight(N - 1);
    }

    private static void midToRight(int N) {
        if (N==1){
            System.out.println("从中到右:"+N);
            return;
        }
        midToLeft(N-1);
        System.out.println("从中到右:"+N);
        leftToRight(N - 1);
    }

    private static void midToLeft(int N) {
        if (N==1){
            System.out.println("从中到左:"+N);
            return;
        }
        midToRight(N-1);
        System.out.println("从中到左:"+N);
        rightToleft(N - 1);

    }

    private static void rightToleft(int N) {
        if (N==1){
            System.out.println("从右到左:"+N);
            return;
        }
        rightToMid(N - 1);
        System.out.println("从右到左:"+N);
        midToLeft(N-1);
    }

    private static void rightToMid(int N) {
        if (N==1){
            System.out.println("从右到中:"+N);
            return;
        }
        rightToleft(N-1);
        System.out.println("从右到中:"+N);
        leftToMid(N-1);
    }

    private static void leftToMid(int N) {
        if (N==1){
            System.out.println("从左到中:"+N);
            return;
        }
        leftToRight(N - 1);
        System.out.println("从左到中:"+N);
        rightToMid(N - 1);
    }

    public static void h2(int n){
        if (n==0){
            return;
        }
        from_to(n,"left","right","mid");
    }
    public static void from_to(int N,String from,String to,String other) {
        if (N==1){
            System.out.println(from+" to "+to+" :"+N);
            return;
        }
        from_to(N - 1, from, other, to);
        System.out.println(from+" to "+to+" :"+N);
        from_to(N - 1, other, to, from);


    }


    public static void main(String[] args) {
        Hanoi.h1(3);
        System.out.println("----------------");
        Hanoi.h2(3);
    }

}
