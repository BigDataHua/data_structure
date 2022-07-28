package com.xiaohua.tixiclass.class25;

import org.hamcrest.core.Is;

import java.util.Stack;

/**
 * @author xiaohua
 * @create 2022-07-19 1:55
 */
public class LargestRectangleInHistogram {


    /*
    * 刷题心得：
    *       用单调栈来记录以当前格子为最小值能向外扩的范围
    *
    * */
    public int largestRectangleArea(int[] heights) {

        int max = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                Integer min = st.pop();
                //当触发这个条件的时候，那么 满足的范围是从 st.peek+1到i-1范围内的个数
                max = Math.max(max, (st.isEmpty() ? i : i  - st.peek()-1) * heights[min]);
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            Integer pop = st.pop();
            //当触发这个条件的时候，
            //那么则代表右边格子都满足以栈内的元素做最小值
            //范围是从 st.peek+1到heights.length范围内的个数
            max = Math.max(max, (st.isEmpty() ? heights.length : heights.length - st.peek()-1) * heights[pop]);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{4,2}));
    }


}
