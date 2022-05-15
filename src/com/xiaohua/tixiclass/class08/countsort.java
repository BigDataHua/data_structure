package com.xiaohua.tixiclass.class08;

import com.xiaohua.tixiclass.PublicMethodUtils;

/** 计数排序
 * @author xiaohua
 * @create 2022-05-09 23:01
 */
public class countsort {

    private int getNum(int num,int digit){
        int count = 1;
        for (int i = 0; i <digit ; i++) {
            count *= 10;
        }
        num=num%count;
        num = num / (count / 10);
        return num;
    }

    private int getMaxdigit(int[] arr){
        int count = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        while (max!=0){
            max /= 10;
            count++;
        }
        return count;
    }

    private void countSort(int[] arr,int left,int right,int digit){

        int[] count = new int[10];
        int[] help = new int[arr.length];
        for (int i = 1; i <= digit; i++) {

            //求每个位数上的数
            for (int j = 0; j <=right; j++) {
                count[getNum(arr[j], i)]++;
            }
            //求出前缀和数组
            for (int j = 1; j <count.length ; j++) {
                count[j] = count[j - 1]+count[j] ;
            }
            for (int j = right; j >=0 ; j--) {
                help[--count[getNum(arr[j], i)]] = arr[j];
            }

            //交换数组
            for (int index = left, j = 0; j < help.length; index++,j++) {
                arr[index] = help[j];
            }
            //重置count数组
            for (int j = 0; j < count.length; j++) {
                count[j] = 0;
            }
        }


    }
    public void countSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        countSort(arr,0,arr.length-1,getMaxdigit(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{54, 33, 12, 44, 99, 100, 88, 44, 121};
        countsort cs = new countsort();
        cs.countSort(arr,0,arr.length-1,cs.getMaxdigit(arr));
        PublicMethodUtils.print(arr);
    }

}
