package com.xiaohua.tixiclass.class24;

import java.util.LinkedList;

/**
 * @author xiaohua
 * @create 2022-07-16 0:21
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = cost.length;
        int M = N<<1;
        int[] sumCost = new int[M];//耗费油数的前缀和数组
        //给整个辅助数组设置初值
        for (int i = 0; i <cost.length ; i++) {
            sumCost[i] = gas[i]-cost[i];
            sumCost[i+N] = gas[i]-cost[i];
        }
        for (int i = 1; i < sumCost.length; i++) {
            sumCost[i]+=sumCost[i-1];
        }
        //窗口
        LinkedList<Integer> windos = new LinkedList<>();

        //将窗口形成 从0-（N-1）一共N个
        for (int i = 0; i < N; i++) {
            while (!windos.isEmpty()&&sumCost[windos.peekLast()]>=sumCost[i]){
                windos.pollLast();
            }
            windos.addLast(i);
        }
        //判断当前窗口内最小值减去前一个是否大于等于零
        for (int i = 0,offset = 0,j=N; i < N; j++,offset=sumCost[i++]) {
            if (sumCost[windos.peekFirst()]-offset>=0){
                return i;
            }
            //判断窗口是否过期
            if (windos.peekFirst()==j-N){
                windos.pollFirst();
            }
            //加入元素
            while (!windos.isEmpty()&&sumCost[windos.peekLast()]>=sumCost[j]){
                windos.pollLast();
            }
            windos.addLast(j);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(new int[]{7,1,0,11,4
}, new int[]{5,9,1,2,5}));
    }

}
