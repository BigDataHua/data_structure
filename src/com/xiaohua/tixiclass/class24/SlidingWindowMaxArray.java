package com.xiaohua.tixiclass.class24;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.util.LinkedList;
import java.util.WeakHashMap;

/**
 * @author xiaohua
 * @create 2022-07-15 23:24
 */
public class SlidingWindowMaxArray {

    /**
     * 每个 窗口的最大最小值
     * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || nums.length < k) {
            return null;
        }
        int N = nums.length;
        int[] ans = new int[N - k + 1];
        int index = 0;
        LinkedList<Integer> windows = new LinkedList<>();
        for (int R = 0; R < N; R++) {
            //如果窗口内有数，并且当前数大于等于窗口内的数
            //窗口内的数直接滚蛋
            while (!windows.isEmpty()&&nums[windows.peekLast()]<=nums[R]){
                //从尾巴出
                windows.pollLast();
            }
            //从尾巴进
            windows.addLast(R);
            //判断当前窗口最大值是否为该弹出元素的索引
            if (windows.peekFirst() == R - k) {
                windows.pollFirst();
            }
            //判断你的窗口是否已经形成
            if (R >= k - 1) {
                ans[index++] = nums[windows.peekFirst()];
            }
        }
        return ans;
    }


}
