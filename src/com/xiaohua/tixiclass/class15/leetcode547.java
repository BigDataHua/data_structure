package com.xiaohua.tixiclass.class15;

/**
 * @author xiaohua
 * @create 2022-06-22 0:36
 */
public class leetcode547 {

    public static int findCircleNum(int[][] isConnected) {
        UnionArr union = new UnionArr(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j <isConnected.length ; j++) {
                if (isConnected[i][j]==1){
                    union.union(i,j);
                }

            }
        }
        return union.sets;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        findCircleNum(arr);
    }

}
