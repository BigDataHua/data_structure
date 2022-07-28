package com.xiaohua.tixiclass.class14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xiaohua
 * @create 2022-06-20 22:19
 */
public class IPO {

    public static class Program{
        int capital;
        int profits;
        public Program(int c ,int p ){
            capital = c;
            profits = p;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //根据captial进行的排序的小根堆
        PriorityQueue<Program> smallHeap = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.capital - o2.capital;
            }
        });
        //根据profit进行排序的大根堆
        PriorityQueue<Program> bigHeap = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o2.profits - o1.profits;
            }
        });

        //所有项目加入到小根堆
        for (int i = 0; i < profits.length; i++) {
            smallHeap.add(new Program(capital[i], profits[i]));
        }
        while(k>0){

            //只要小根堆里有项目就进行判断
            while (smallHeap.size()>0){
                //当本金大于小根堆里项目的启动资金的时候 将项目加入大根堆，不大于那么直接
                //退出循环
                if (w>=smallHeap.peek().capital){
                    bigHeap.add(smallHeap.poll());
                }else {
                    break;
                }
            }
            //如果大根堆里有项目那么进行收获本金和利益
            //否则直接退，没有项目能够启动，无法获益
            if (bigHeap.size()>0){
                w += bigHeap.poll().profits;
                k--;
            }else {
                break;
            }

        }

        return w;
    }

}
