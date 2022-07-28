package com.xiaohua.tixiclass.class25;

/**
 *
 * @author xiaohua
 * @create 2022-07-19 0:54
给定一个只包含正数的数组arr，arr中任何一个子数组sub，
一定都可以算出(sub累加和 )* (sub中的最小值)是什么，
那么所有子数组中，这个值最大是多少？
 */

import java.util.Stack;

public class AllTimesMinToMax {

    public static int max1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {

                Integer min = st.pop();
                //这段逻辑：（栈为空？ true 直接拿前缀和的i-1的位置
                //                      false  拿前缀和的i-1的位置减去小于当前值的索引位置）*arr[min] 与max比大小
                max = Math.max(max,(st.isEmpty()?preSum[i-1]:preSum[i-1]-preSum[st.peek()])*arr[min]);
            }
            st.push(i);
        }

        while (!st.isEmpty()){

            Integer min = st.pop();
            //这段逻辑：（栈为空？ true 直接拿前缀和的最后位置（为什么是最后位置？因为后面没数比当前小，当然能拿到最后）
            //                      false  拿前缀和的最后位置减去小于当前值的索引位置）*arr[min] 与max比大小
            max = Math.max(max,(st.isEmpty()?preSum[arr.length-1]:preSum[arr.length-1]-preSum[st.peek()])*arr[min]);
        }

        return max;
    }

    public static int max2(int[] arr) {
        int size = arr.length;
        int[] sums = new int[size];
        sums[0] = arr[0];
        for (int i = 1; i < size; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int j = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sums[size - 1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
        }
        return max;
    }

    public static int[] gerenareRondomArray() {
        int[] arr = new int[(int) (Math.random() * 20) + 10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTimes = 2000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = gerenareRondomArray();
            if (max1(arr) != max2(arr)) {

                System.out.println("FUCK!");
                break;
            }
        }
        System.out.println("test finish");
    }

}