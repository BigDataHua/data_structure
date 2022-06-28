package com.xiaohua.tixiclass.class08;

/** 基数排序
 * @author xiaohua
 * @create 2022-05-09 23:02
 */
public class RadixSort {

    public void radixSort(int[] arr){
        int num = 0;
        //寻找数组中最大值
        for (int i = 0; i < arr.length; i++) {
            num = arr[i] > num ? arr[i] : num;
        }
        //创建help辅助数组，长度为num+1以便好算
        int[] help = new int[num+1];
        //遍历arr数组记录每个值
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }
        //重新给arr赋值
        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]!=0){
                arr[index++] = i;
                help[i]--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 4, 1, 2, 3};
        new RadixSort().radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
