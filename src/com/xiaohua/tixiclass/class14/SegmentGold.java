package com.xiaohua.tixiclass.class14;

import java.util.PriorityQueue;

/**
 * @author xiaohua
 * @create 2022-06-20 22:58
 */
public class SegmentGold {

    public static int lessMoney2(int[] arr){

        int cost = 0;
        int result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        //贪心策略：哈夫曼树
        while (heap.size()>1){
            result = heap.poll() + heap.poll();
            cost += result;
            heap.add(result);
        }
        return cost;

    }

    public static int lessMoney1(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 6;
        int maxValue = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            if (lessMoney1(arr) != lessMoney2(arr)) {
                System.out.println("Oops!");
            }
            System.out.println(i);
        }
        System.out.println("finish!");
    }

}
