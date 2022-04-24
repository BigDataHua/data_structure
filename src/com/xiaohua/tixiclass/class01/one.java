package com.xiaohua.tixiclass.class01;

import com.xiaohua.tixiclass.PublicMethodUtils;

import java.util.Arrays;

/**
 * 复杂度
 * 时间复杂度要用最坏情况估计   当时间复杂度在同一个量级  拼常数（直接实测 用随机大样本来比拼）
 * 空间复杂度估计时 只估计你所需要完成功能的空间
 * 例如 要求你返回一个数组 那么你开辟的这个数组不算空间复杂度
 * <p>
 * 最优解
 * 首先是保证时间复杂度最低
 * 然后考虑空间复杂度
 * <p>
 * 选择
 * 冒泡
 * 直接插入
 * <p>
 * 对数器
 * 二分法 mid=(L+R)/2 有可能溢出   要改为L+(（R-L）/2)
 * 一个数除2用右移1位来代替   mid=（L+（R-L）>>1）;
 * 有序数组找个数
 * 有序数组找大于等于i最左的数
 * 有序数组找小于等于i最右的数
 * 求局部最小
 * @author xiaohua
 * @create 2022-03-23 21:56
 */
public class one {

    //交换方法
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //冒泡排序
    public static void BubbleSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }

    }

    //选择排序
    public static void selectSort(int arr[]) {
        int mixIndex;
        for (int i = 0; i < arr.length; i++) {
            mixIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                mixIndex = arr[mixIndex] > arr[j] ? j : mixIndex;
            }
            swap(arr, i, mixIndex);
        }


    }

    //直接插入排序
    public static void insertSort(int arr[]) {

        if (arr == null && arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && arr[j - 1] > num; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;

        }

    }


    //二分法查找一个数
    public static int findNum(int arr[], int find) {

        if (arr == null || arr.length < 1) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > find) {
                r = mid - 1;
            } else if (arr[mid] < find) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        int reslut = (arr[l] == find) ? l : -1;
        return reslut;
    }

    //顺序查找（判断）
    public static int findKey(int arr[], int find) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= find) {
                return i;
            }
        }
        return -1;
    }

    //    有序数组找大于等于i最左的数
    public static int findUpLeft(int arr[], int find) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int result = -1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid]>=find){
                result = mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }

        return arr[l]>=find?l:result;

    }


    public static void main(String[] args) {

        int maxTime = 100000;
        int maxValue = 100000;
        int maxlen = 10000;
        boolean flag = true;
        int[] randomArr = PublicMethodUtils.getRandomArr(maxValue, maxlen);
//        int[] arr1 = {-2812,305, 1198 ,2512};
//        int[] arr2 = PublicMethodUtils.copyArr(randomArr);

        insertSort(randomArr);
//        Arrays.sort(arr2);



        for (int i = 0; i < maxTime; i++) {
            int num = 0;
            do {
                num =  PublicMethodUtils.getRandomNum(maxValue);
            } while (num < 0);

            int find = num;
            int findIndex1 = findUpLeft(randomArr, find);
            int findIndex2 = findUpLeft(randomArr, find);
            System.out.println(findIndex1+"  "+findIndex2);
            if (findIndex1!=findIndex2 ) {
                flag = false;
                System.out.println(find);
                PublicMethodUtils.print(randomArr);
                return;
            }

        }

        String reslut = flag ? "good" : "失败了";
        System.out.println(reslut);

    }


}
