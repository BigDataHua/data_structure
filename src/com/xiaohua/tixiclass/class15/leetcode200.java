package com.xiaohua.tixiclass.class15;

/**
 * @author xiaohua
 * @create 2022-06-22 1:20
 */
public class leetcode200 {

    public int numIslands1(char[][] grid) {
        int isLand = 0;

        for (int i = 0; i < grid.length ;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    infect(grid,i,j);
                    isLand++;
                }

            }

        }
        return isLand;
    }

    private void infect(char[][] grid,int i, int j) {
        if (i<0||i>=grid.length||j<0||j>grid[0].length||grid[i][j]!='1'){
            return;
        }
        grid[i][j] = '!';
        infect(grid,i-1,j);
        infect(grid,i+1,j);
        infect(grid,i,j+1);
        infect(grid,i,j-1);
    }



//    public int numIslands2(char[][] grid) {
//        UnionArrTwo unionArrTwo = new UnionArrTwo(grid);
//        int col = grid[0].length;
//        int row = grid.length;
//        //第一行
//        for (int i = 0; i <col ; i++) {
//            if (grid[0][i]=='1'){
//                if (i>=1&&grid[i-1][0]=='1'){
//                    unionArrTwo.union(0,i,0,i-1,col);
//                }
//            }
//        }
//        //第一列
//        for (int i = 0; i < row; i++) {
//            if (grid[i][0]=='1'){
//                if (i>=1&&grid[i-1][0]=='1'){
//                    unionArrTwo.union(i,0,i-1,0,col);
//                }
//            }
//        }
//        //剩下的元素
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < col; j++) {
//                if (grid[i][j]=='1'){
//                    if (grid[i-1][j]=='1'){
//                    unionArrTwo.union(i,j,i-1,j,col);
//                    }
//                    if (grid[i][j-1]=='1'){
//                    unionArrTwo.union(i,j,i,j-1,col);
//                    }
//                }
//            }
//        }
//        return unionArrTwo.sets;
//
//    }

//    public static void main(String[] args) {
//        int i = new leetcode200().numIslands2(new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}});
//        System.out.println(i);
//    }


}
