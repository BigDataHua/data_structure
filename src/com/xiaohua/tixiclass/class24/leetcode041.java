package com.xiaohua.tixiclass.class24;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.LinkedList;

/**
 * @author xiaohua
 * @create 2022-07-16 16:48
 */
public class leetcode041 {

    class MovingAverage {
        int size = 0;
        int limit = 0;
        int total = 0;
        LinkedList<Integer> window = new LinkedList<>();
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.limit = size;
        }

        public double next(int val) {
            total+=val;
            size++;
            window.addLast(val);

            if (size>limit){
                size--;
                total -= window.pollFirst();
            }

            return (double) ((double) total / (double) size);
        }
    }

}
