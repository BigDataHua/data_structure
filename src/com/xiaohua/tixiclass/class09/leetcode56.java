package com.xiaohua.tixiclass.class09;

import com.xiaohua.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 * @author xiaohua
 * @create 2022-05-14 12:47
 */
public class leetcode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length<=1){
            return intervals;
        }
        //一个容器存储答案
        ArrayList<Integer[]> list = new ArrayList<>();
        //实现排序，定义比较器
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0]-o2[0];
            }
        });
        int p = 0;
        int i = 1;
        int max = intervals[p][1];
        for (; i < intervals.length; i++) {
            max = intervals[i - 1][1] >= max ? intervals[i - 1][1] : max;
            if (intervals[i][0]>max){
                list.add(new Integer[]{intervals[p][0],max});
                p = i;
            }
        }
        list.add(new Integer[]{intervals[p][0], intervals[i-1][1]>=max?intervals[i-1][1]:max});
        int[][] ans = new int[list.size()][2];
        for (int i1 = 0; i1 < list.size(); i1++) {
            ans[i1][0] = list.get(i1)[0];
            ans[i1][1] = list.get(i1)[1];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = new leetcode56().merge(arr);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0]+" "+merge[i][1]);
        }
    }

}
