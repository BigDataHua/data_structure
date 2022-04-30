package com.xiaohua.tixiclass.class05;

/**  36题写的不够好，还要再次优化
 * @author xiaohua
 * @create 2022-04-30 12:48
 */
public class leetcode36 {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        boolean flag = false;
        if(nums ==null||nums.length<1){
            return new int[]{-1,-1};
        }
        if (left==right){
            return nums[left]==target? new int[]{left,right}:new int[]{-1,-1};
        }
        int mid = 0 ;
        while(left<=right){
            mid = left+((right-left)>>1);
            if(nums[mid]==target){
                flag = true;
                break;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if (flag==false){
            return new int[]{-1,-1};
        }
        left = mid;
        right = mid;
        while(left>=0&&nums[left]==target){
            left--;
        }

        while(right<=nums.length-1&&nums[right]==target){
            right++;
        }

        return new int[]{left+1,right-1};
    }

    public static void main(String[] args) {
        int[] arr = {1,4};

        int[] range = searchRange(arr, 4);
        for (int i = range[0]; i <= range[1]; i++) {
            System.out.println(arr[i]);

        }
    }

}
