package com.xiaohua.tixiclass.class15;

/**
 * @author xiaohua
 * @create 2022-06-23 22:44
 */
public class leetcode695 {

    public int maxAreaOfIsland(int[][] grid) {
        UnionArrTwo unionArrTwo = new UnionArrTwo(grid);
        int row = grid.length;
        int col = grid[0].length;
        //第一行
        for (int i = 0; i < col; i++) {
            if (i>0){
                unionArrTwo.union(0,i,0,i-1,col);
            }
        }
//        第一列
        for (int i = 0; i <row ; i++) {
            if (i>0){
                unionArrTwo.union(i,0,i-1,0,col);
            }
        }
        //剩余元素
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <col ; j++) {
                unionArrTwo.union(i,j,i-1,j,col);
                unionArrTwo.union(i,j,i,j-1,col);
            }
        }

        return unionArrTwo.sizeMax;
    }

    public static void main(String[] args) {
        int i = new leetcode695().maxAreaOfIsland(new int[][]{
                {1}
        });
        System.out.println(i);
    }
}
