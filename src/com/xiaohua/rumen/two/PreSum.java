package com.xiaohua.rumen.two;

/**前缀和  查找 从a-b范围上数组的和   次数极其频繁
 * 方法一  构建一个 n*n的矩阵  来刻画a-b范围上的和   可以利用矩阵压缩 因为只需要上三角矩阵
 * 方法二  构建一个 等长的前缀和数组  用来求出 0-x范围的前缀和  然后利用 0-b的前缀和减去0-a的前缀和来算出结果
 * @author xiaohua
 * @create 2022-03-18 23:29
 */
public class PreSum {

    //刻画前缀和数组
    public static int[] sum(int arr[]){
        int[] tem = new int[arr.length];
        tem[0]=arr[0];
        //前缀和数组的值等于前一个的值加上arr数组中的值
        for (int i = 1; i < arr.length; i++) {
            tem[i]=arr[i-1]+arr[i];
        }
        return tem;
    }

}
