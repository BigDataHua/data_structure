package com.xiaohua.tixiclass.class04;

import com.xiaohua.tixiclass.PublicMethodUtils;

import javax.sound.midi.Soundbank;

/**
 * 一个数 右边有多少个数的两倍还比其小
 *
 * @author xiaohua
 * @create 2022-04-19 21:58
 */
public class TwoNumSum {

    /**
     * 本题核心就是利用归并排序来搞，不过对于归并排序我更喜欢非递归
     * 在merge函数中，先求解再进行merge
     * 另外注意编程技巧  左闭右开区间
     * @param arr 求解的数组
     * @return
     */

    public static int twosum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return myprocess(arr);
    }

    public static int merge(int[] arr, int left, int mid, int right) {

        int ans = 0;
        int myright = mid+1;
        //指针不回退技巧，这个时间复杂度是O（N）不是N的平方
        //i是指向left别搞错了
        for (int i = left; i <= mid; i++) {
            while (myright <= right && (arr[i] > (arr[myright] << 1))) {
                myright++;
            }
            ans += (myright - mid - 1);
        }
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int hi = 0;//辅助指针
        while (p1 <= mid && p2 <= right) {
            help[hi++] = (arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]);
        }
        while (p1 <= mid) {
            help[hi++] = arr[p1++];
        }
        while (p2 <= right) {
            help[hi++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return ans;
    }

    public static int myprocess(int[] arr) {

        int ans = 0;

        int mergesize = 1;
        while (mergesize < arr.length) {

            int left = 0;
            while (left < arr.length) {

                int mid = left + mergesize - 1;
                if (mid >= arr.length) {
                    break;
                }
                int right = Math.min(arr.length - 1, mid + mergesize);
                ans += merge(arr, left, mid, right);
                left = right + 1;
            }

            if (mergesize > arr.length / 2) {
                break;
            }
            mergesize <<= 1;

        }


        return ans;
    }

    //检查方法
    public static int check(int[] arr) {

        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int max = 10000;
        int len = 2000;
        int time = 10000;
        boolean flag = true;
        for (int i = 0; i <time ; i++) {

            int[] randomArr = PublicMethodUtils.getRandomArr(max, len);
            int[] copyArr = PublicMethodUtils.copyArr(randomArr);
            int twosum = twosum(randomArr);
            int check = check(copyArr);
            if (check!=twosum){
                flag = false;
                System.out.println(check);
                System.out.println(twosum);
                PublicMethodUtils.print(copyArr);
            }
        }

        if (flag){
            System.out.println("Nice");
        }else {
            System.out.println("有错误");
        }

    }

}
