package com.xiaohua.tixiclass.class08;

import sun.misc.resources.Messages_it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 示例 1：
 输入：nums = [5,2,6,1]
 输出：[2,1,1,0]
 解释：
 *
 * @author xiaohua
 * @create 2022-05-12 22:26
 */
public class leetcode315 {

    public List<Integer> countSmaller(int[] nums) {

        return mergesort(nums);
    }

    private List<Integer> mergesort(int[] nums) {
        int[] indexs = new int[nums.length];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            indexs[i]=i;
            ans.add(0);
        }
        int mergesize = 1;
        while (mergesize<nums.length){

            int left = 0;
            while (left<nums.length){
                int mid = left+mergesize-1;
                //右边没数了，退出吧
                if (mid>=nums.length-1){
                    break;
                }
                int right = Math.min(nums.length-1,mid+mergesize);
                indexs=merge(nums,left,mid,right,ans,indexs);
                left=right+1;
                for (int i = 0; i < indexs.length; i++) {
                    System.out.print(indexs[i]+" ");
                }
                System.out.println();
            }

            //防溢出
            if (mergesize>nums.length/2){
                break;
            }
            mergesize <<= 1;
        }


        return ans;
    }

    private int[] merge(int[] nums, int left, int mid, int right, ArrayList<Integer> ans,int[] indexs) {


        for (int lindex = mid,rindex = right;lindex>=left;lindex--){

            while (nums[lindex]<=nums[rindex]&&rindex>mid){
                rindex--;
            }

            ans.set(indexs[lindex],ans.get(indexs[lindex])+(rindex-mid));
        }
        int l = left;
        int r = mid+1;
        int[] help = new int[right-left + 1];
        int[] helpindex = new int[help.length];
        for (int i = 0; i < helpindex.length; i++) {
            helpindex[i] = indexs[left+i];
        }
        int index = 0;
        while (l<=mid&&r<=right){
            if (nums[l]<=nums[r]){
                help[index]=nums[l];
                indexs[left+index]=helpindex[l-left];
                index++;
                l++;
            }else {
                help[index]=nums[r];
                indexs[left+index]=helpindex[r-left];
                index++;
                r++;
            }

        }
        while (l<=mid){
            help[index] = nums[l];
            indexs[left+index]=helpindex[l-left];
            index++;
            l++;
        }
        while (r<=right){
            help[index] = nums[r];
            indexs[left+index]=helpindex[r-left];
            index++;
            r++;
        }
        for (int i = 0; i < help.length; i++) {
            nums[left + i] = help[i];

        }
        return indexs;
    }

    public static void main(String[] args) {
        List<Integer> integers = new leetcode315().countSmaller(new int[]{3,6,7,4,6,3,7});
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }
    }

}
