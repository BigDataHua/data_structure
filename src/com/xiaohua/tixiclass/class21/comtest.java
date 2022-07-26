package com.xiaohua.tixiclass.class21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xiaohua
 * @create 2022-07-08 10:36
 */
public class comtest {

    public boolean canReceiveAllSignals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        return true;
        
    }


    public int minTransfers(int[][] distributions) {
        Integer[] count = new Integer[12];
        for (int[] distribution : distributions) {
            count[distribution[0]]-=distribution[2];
            count[distribution[1]]+=distribution[2];
        }
        //拿到所有清单
        Arrays.sort(count, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        PriorityQueue<Integer> add = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> mous = new PriorityQueue<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i]>0){
                add.add(count[i]);
            }else if (count[i]<0){
                mous.add(count[i]);
            }
        }
        int ans = 0;
        Integer num=0;
        Integer m=0;
        while (!mous.isEmpty()){
            ans++;
            if (num<=0){
                num+=add.poll();
            }
            if (m>=0){
                m=mous.poll();
            }
            int tem = num;
            num+=m;
            m+=tem;
        }
        return m==0?ans:ans+1;
    }

    
    
}
