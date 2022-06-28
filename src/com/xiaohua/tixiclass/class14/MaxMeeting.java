package com.xiaohua.tixiclass.class14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xiaohua
 * @create 2022-06-20 22:42
 */
public class MaxMeeting {

    public static class Program{
        int start;
        int end;
        public Program(int s,int e){
            start = s;
            end = e;
        }
    }

    public static int MaxProgram(Program[] arr){

        if (arr == null || arr.length == 0) {
            return 0;
        }
        //贪心策略：每次选最早结束的会议
        Arrays.sort(arr, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });
        int start = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (start <= arr[i].start) {
                ans++;
                start = arr[i].end;
            }
        }
        return ans;

    }



}
