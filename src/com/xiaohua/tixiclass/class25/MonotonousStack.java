package com.xiaohua.tixiclass.class25;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author xiaohua
 * @create 2022-07-18 23:47
 */

//从小到大

public class MonotonousStack {

    // arr = [ 3, 1, 2, 3]
    //         0  1  2  3
    //  [
    //     0 : [-1,  1]
    //     1 : [-1, -1]
    //     2 : [ 1, -1]
    //     3 : [ 2, -1]
    //  ]

    /**
     * 刷题心得：
     *  如果数组中元素不重复，可以随便折腾，没有影响
     *  一旦数组中元素重复，那么就要用栈顶链表的最后元素来充当左边最小索引
     */

    public static int[][] getNearLessNoRepeat(int[] arr) {
        //ans用来得到 数组中每个元素左边比自己小的元素的索引   右边比自己小的元素的索引
        int[][] ans = new int[arr.length][2];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                //因为栈中的元素就是索引，ans的长度就是按照arr造的  直接栈中元素当索引
                Integer pop = st.pop();
                ans[pop][0] = st.isEmpty() ? -1 : st.peek();
                ans[pop][1] = i;
            }
            st.push(i);
        }
        //数组造完、可是栈中不一定就没有元素了
        while (!st.isEmpty()) {
            Integer pop = st.pop();
            ans[pop][0] = st.isEmpty() ? -1 : st.peek();
            ans[pop][1] = -1;
        }
        return ans;
    }

    public static int[][] getNearLess(int[] arr) {
        int[][] ans = new int[arr.length][2];
        Stack<ArrayList<Integer>> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty()&&arr[st.peek().get(0)]>arr[i]){
                ArrayList<Integer> pop = st.pop();
                for (Integer integer : pop) {
                    //使用的是 栈顶链表最后一个元素
                    ans[integer][0] = st.isEmpty()?-1:st.peek().get(st.peek().size()-1);
                    ans[integer][1] = i;
                }
            }
            //当栈中最后一个链表的元素等于当前入栈的元素 直接挂在栈顶链表的最后位置
            if (!st.isEmpty()&&arr[st.peek().get(0)] == arr[i]) {
                st.peek().add(i);
            }else {
                //否则创建新链表入栈
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                st.push(list);
            }
        }
        while (!st.isEmpty()) {

            ArrayList<Integer> pop = st.pop();
            for (Integer integer : pop) {
                //使用的是 栈顶链表最后一个元素
                ans[integer][0] = st.isEmpty() ? -1 : st.peek().get(st.peek().size()-1);
                ans[integer][1] = -1;
            }

        }

        return ans;
    }

    // for test
    public static int[] getRandomArrayNoRepeat(int size) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int swapIndex = (int) (Math.random() * arr.length);
            int tmp = arr[swapIndex];
            arr[swapIndex] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    // for test
    public static int[] getRandomArray(int size, int max) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
        }
        return arr;
    }

    // for test
    public static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[][] res1, int[][] res2) {
        if (res1.length != res2.length) {
            return false;
        }
        for (int i = 0; i < res1.length; i++) {
            if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
                return false;
            }
        }

        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 10;
        int max = 20;
        int testTimes = 2000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = getRandomArrayNoRepeat(size);
            int[] arr2 = getRandomArray(size, max);
            if (!isEqual(getNearLessNoRepeat(arr1), rightWay(arr1))) {
                System.out.println("Oops!");
                printArray(arr1);
                break;
            }
            if (!isEqual(getNearLess(arr2), rightWay(arr2))) {
                System.out.println("Oops!");
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}