package com.xiaohua.tixiclass.class05;

import java.util.ArrayList;

/**
 * 求一个数组中满足 [lower,upper]之间所有可能的区间个数
 * @author xiaohua
 * @create 2022-04-25 21:34
 */
public class RangeSum {

           static int ans = 0;
    /*
    *
    * 首先创造前缀和数组，
    *
    * */

    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums==null||nums.length<1){
            return 0;
        }
        long[] sum = new long[nums.length];
        sum[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            sum[i]=sum[i-1]+nums[i];
        }
        return mycount(sum,0,sum.length-1,lower,upper);

    }

    public int mycount(long[] sum,int left,int right,int lower,int upper){

        if (left==right){
            return (sum[left]>=lower&&sum[left]<=upper? 1:0);
        }
        int mid = left+(right-left)/2;
        int leftcount = mycount(sum,left,mid,lower,upper);
        int rightcount = mycount(sum,mid+1,right,lower,upper);
        int mergecout = merge(sum,left,mid,right,lower,upper);
        return leftcount+rightcount+mergecout;

    }

    private int merge(long[] sum, int left,int mid, int right, int lower, int upper) {

        int ans = 0;
        int myleft = left;
        int myright = left;
        for (int i = mid+1; i <=right; i++) {
            long min = sum[i]-upper;
            long max = sum[i]-lower;
            while (sum[myleft]<min&&myleft<=mid){
                myleft++;
            }
            while (sum[myright]<=max&&myright<=mid){
                myright++;
            }
            ans+=Math.max(myright-myleft,0);
        }

        long[] help = new long[right-left+1];
        int p1 = left;
        int p2 = mid+1;
        int h = 0;
        while (p1<=mid&&p2<=right){
            help[h++]=  (sum[p1]<=sum[p2]?sum[p1++]:sum[p2++]);
        }
        while (p1<=mid){
            help[h++]=sum[p1++];
        }
        while (p2<=right){
            help[h++]=sum[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            sum[left+i]=help[i];
        }
        return ans;
    }



}
