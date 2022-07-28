package com.xiaohua.tixiclass.class20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xiaohua
 * @create 2022-07-05 23:59
 */
public class Coffee {

    // 题目
// 数组arr代表每一个咖啡机冲一杯咖啡的时间，每个咖啡机只能串行的制造咖啡。
// 现在有n个人需要喝咖啡，只能用咖啡机来制造咖啡。
// 认为每个人喝咖啡的时间非常短，冲好的时间即是喝完的时间。
// 每个人喝完之后咖啡杯可以选择洗或者自然挥发干净，只有一台洗咖啡杯的机器，只能串行的洗咖啡杯。
// 洗杯子的机器洗完一个杯子时间为a，任何一个杯子自然挥发干净的时间为b。
// 四个参数：arr, n, a, b
// 假设时间点从0开始，返回所有人喝完咖啡并洗完咖啡杯的全部过程结束后，至少来到什么时间点。

    /**
     * 用小根堆来模拟排序效果
     *
     * 在dp范围不好估计的时候  取最大值，另外值得注意当边界取最大值
     * 有些情况是不必要的，可以直接舍弃
     *
     */

    public static int right(int[] arr, int n, int a, int b) {
        int[] times = new int[arr.length];
        int[] drink = new int[n];
        return forceMake(arr, times, 0, drink, n, a, b);
    }

    // 每个人暴力尝试用每一个咖啡机给自己做咖啡
    public static int forceMake(int[] arr, int[] times, int kth, int[] drink, int n, int a, int b) {
        if (kth == n) {
            int[] drinkSorted = Arrays.copyOf(drink, kth);
            Arrays.sort(drinkSorted);
            return forceWash(drinkSorted, a, b, 0, 0, 0);
        }
        int time = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int work = arr[i];
            int pre = times[i];
            drink[kth] = pre + work;
            times[i] = pre + work;
            time = Math.min(time, forceMake(arr, times, kth + 1, drink, n, a, b));
            drink[kth] = 0;
            times[i] = pre;
        }
        return time;
    }

    public static int forceWash(int[] drinks, int a, int b, int index, int washLine, int time) {
        if (index == drinks.length) {
            return time;
        }
        // 选择一：当前index号咖啡杯，选择用洗咖啡机刷干净
        int wash = Math.max(drinks[index], washLine) + a;
        int ans1 = forceWash(drinks, a, b, index + 1, wash, Math.max(wash, time));

        // 选择二：当前index号咖啡杯，选择自然挥发
        int dry = drinks[index] + b;
        int ans2 = forceWash(drinks, a, b, index + 1, washLine, Math.max(dry, time));
        return Math.min(ans1, ans2);
    }

    public class Machine{
        int start;
        int time;
        public  Machine(int s,int t){
            start = s;
            time = t;
        }
    }
    public  int minTime1(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> machinesQueue = new PriorityQueue<>(new Comparator<Machine>() {
            @Override
            public int compare(Machine o1, Machine o2) {
                return (o1.time + o1.start) - (o2.start + o2.time);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            machinesQueue.add(new Machine(0, arr[i]));
        }
        int[] drink = new int[n];
        for (int i = 0; i < drink.length; i++) {
            Machine poll = machinesQueue.poll();
            drink[i] = poll.time + poll.start;
            poll.start = poll.start + poll.time;
            machinesQueue.add(poll);
        }
        return process(drink, 0, a, b,0);


    }

    private int process(int[] drink, int index, int a, int b,int washline) {
        if (index == drink.length) {
            return 0;
        }
        int selfClean= Math.max(drink[index], washline)+a;
        int restClean = process(drink, index + 1, a, b, selfClean);
        int p1 = Math.max(selfClean, restClean);
        int selfClean2 = drink[index]+b;
        int restClean2 = process(drink, index + 1, a, b, washline);
        int p2 = Math.max(selfClean2, restClean2);

        return Math.min(p1, p2);


    }




    // for test
    public static int[] randomArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        System.out.print("arr : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(len, max);
            int n = (int) (Math.random() * 7) + 1;
            int a = (int) (Math.random() * 7) + 1;
            int b = (int) (Math.random() * 10) + 1;
            int ans1 = right(arr, n, a, b);
            int ans2 = new Coffee().minTime1(arr, n, a, b);
            int ans3 = new Coffee().minTime2(arr, n, a, b);
            if (ans1 != ans2 ||ans2!=ans3) {
                printArray(arr);
                System.out.println("n : " + n);
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                System.out.println(ans1 + " , " + ans2+ ","+ans3);
                System.out.println("===============");
                break;
            }
        }
        System.out.println("测试结束");

    }

    private  int minTime2(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> machinesQueue = new PriorityQueue<>(new Comparator<Machine>() {
            @Override
            public int compare(Machine o1, Machine o2) {
                return (o1.time + o1.start) - (o2.start + o2.time);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            machinesQueue.add(new Machine(0, arr[i]));
        }
        int[] drink = new int[n];
        for (int i = 0; i < drink.length; i++) {
            Machine poll = machinesQueue.poll();
            drink[i] = poll.time + poll.start;
            poll.start = poll.start + poll.time;
            machinesQueue.add(poll);
        }
        return process2(drink ,a, b);
    }

    //a 洗 b挥发
    private static int process2(int[] drink, int a, int b) {
        int N = drink.length;
        int max = 0;
        for (int i = 0; i < drink.length; i++) {
            max = Math.max(max, drink[i]) + a;
        }
        int[][] dp = new int[N + 1][max + 1];

        //dp [N][....] = 0
        for (int index = N-1; index >=0 ; index--) {

            for (int i = 0; i <= max; i++) {

                int selfClean= Math.max(drink[index], i)+a;
                if (selfClean>max){
                    continue;
                }
                int restClean = dp[index + 1][selfClean];
                int p1 = Math.max(selfClean, restClean);
                int selfClean2 = drink[index]+b;
                int restClean2 = dp[index + 1][i];
                int p2 = Math.max(selfClean2, restClean2);
                dp[index][i] = Math.min(p1, p2);

            }

        }



        return dp[0][0];
    }

}
