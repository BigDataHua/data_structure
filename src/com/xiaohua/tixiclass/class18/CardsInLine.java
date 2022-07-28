package com.xiaohua.tixiclass.class18;

/**
 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 玩家A和玩家B依次拿走每张纸牌
 规定玩家A先拿，玩家B后拿
 但是每个玩家每次只能拿走最左或最右的纸牌
 玩家A和玩家B都绝顶聪明
 请返回最后获胜者的分数

 本题从暴力递归改动态规划
 大局思想
 第一步
    我先手 拿走L位置上的加上我后手拿L+1，R上的
            拿走R位置上的加上我后手拿L，R-1上的
            谁大拿谁
    后手   求最小值  我先手在L+1，R上的与我先手拿L，R-1上的
第二步
    有了暴力递归  开始优化
    从找区间变化范围  做出表  需要几个我就造几个
    一个表就直接传 俩表我全部塞给你
 第三步
    从条件找能够确定的点，然后通过第二步的函数反推依赖关系
    得到最终动态规划答案

 * @author xiaohua
 * @create 2022-07-01 1:01
 */
public class CardsInLine {

    public static int win1(int[] arr){
        int frist = f1(arr,0,arr.length-1);
        int secondry = g1(arr,0,arr.length-1);
        return Math.max(frist, secondry);
    }

    private static int f1(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int ans1 = arr[left]+g1(arr, left + 1, right);
        int ans2 = arr[right]+g1(arr, left, right - 1);

        return Math.max(ans1, ans2);
    }
    private static int g1(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int ans1 = f1(arr, left + 1, right);
        int ans2 = f1(arr, left, right - 1);
        return Math.min(ans1,ans2);
    }
    public static int win2(int[] arr){
        int[][] fTable = new int[arr.length][arr.length];
        int[][] gTable = new int[arr.length][arr.length];
        for (int i = 0; i < fTable.length; i++) {
            for (int j = 0; j < fTable[0].length; j++) {
                fTable[i][j] = -1;
                gTable[i][j] = -1;
            }

        }
        int frist = f2(arr,0,arr.length-1,fTable,gTable);
        int secondry = g2(arr,0,arr.length-1,fTable,gTable);
        return Math.max(frist, secondry);
    }

    private static int g2(int[] arr, int left, int right, int[][] fTable, int[][] gTable) {
        if (gTable[left][right] != -1) {
            return gTable[left][right];
        }
        int ans = 0;
        if (left != right) {
            int p1 = f2(arr, left + 1, right, fTable, gTable);
            int p2 = f2(arr, left, right - 1, fTable, gTable);
            ans = Math.min(p1, p2);
        }



        gTable[left][right] = ans;
        return ans;
    }

    private static int f2(int[] arr, int left, int right, int[][] fTable, int[][] gTable) {
        if (fTable[left][right]!=-1){
            return fTable[left][right];
        }
        int ans = 0;
        if (left == right) {
            ans = arr[left];
        }else {
        int p1 = arr[left] + g2(arr, left + 1, right, fTable, gTable);
        int p2 = arr[right] + g2(arr, left, right - 1, fTable, gTable);
        ans = Math.max(p1, p2);

        }
        fTable[left][right] = ans;
        return ans;
    }



    public static int win3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[][] fTable = new int[arr.length][arr.length];
        int[][] gTable = new int[arr.length][arr.length];
        for (int i = 0; i < fTable.length; i++) {
            fTable[i][i] = arr[i];
            gTable[i][i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int L = 0;
            int R = i + 1;
            while (R < arr.length) {

                fTable[L][R] = Math.max(arr[L]+gTable[L+1][R],arr[R]+gTable[L][R-1]);
                gTable[L][R] = Math.min(fTable[L+1][R],fTable[L][R-1]);
                L++;
                R++;
            }
        }


        return Math.max(fTable[0][arr.length-1], gTable[0][arr.length-1]);
    }


    public static void main(String[] args) {
        int[] arr = {  5,3,4,5 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));

    }

}
