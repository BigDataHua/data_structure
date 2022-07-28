package com.xiaohua.tixiclass.class13;

/**
 * @author xiaohua
 * @create 2022-06-19 0:07
 */
public class leetcode004 {



    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int nstart1 = 0;
        int nstart2 = 0;
        int nend1 = nums1.length - 1;
        int nend2 = nums2.length - 1;
        int index1 = (nstart1 + nend1) >> 1;
        int index2 = (nstart2 + nend2) >> 1;
        int ans = 0;
        int size = (nums1.length+nums2.length)%2==0?2:1;
        int midIndex = (nums1.length + nums2.length)>>1;
        midIndex += size == 2 ? 0 : 1;
        for (int i = 0; i < size; i++) {
            do {
                if (nums1[index1] < nums2[index2] && midIndex < (index1 + index2 + 2)) {
                    //num2[index2]大并且长度大于目标长度
                    nend2 = index2-1;
                    index2 = (nstart2 + nend2) >> 1;
                    if (midIndex == (index1 + index2 + 2)){
                        ans +=  nums2[index2];
                        break;
                    }

                } else if (nums1[index1] < nums2[index2] && midIndex > (index1 + index2 + 2)) {
                    //num2[index2]大并且长度小于目标长度
                    nstart2 = index2+1;
                    index2 = (nstart2 + nend2) >> 1;
                    if (midIndex == (index1 + index2 + 2)){
                        ans +=  nums2[index2];
                        break;
                    }
                } else if (nums1[index1] > nums2[index2] && midIndex < (index1 + index2 + 2)) {
                    //num1[index1]大并且长度大于目标长度
                    nend1 = index1-1;
                    index1 = (nstart1 + nend1) >> 1;
                    if (midIndex == (index1 + index2 + 2)){
                        ans +=  nums1[index1];
                        break;
                    }

                } else if (nums1[index1] > nums2[index2] && midIndex < (index1 + index2 + 2)) {
                    nstart1 = index1+1;
                    index1 = (nstart1 + nend1) >> 1;
                    if (midIndex == (index1 + index2 + 2)){
                        ans +=  nums1[index1];
                        break;
                    }
                }
                if (midIndex == (index1 + index2 + 2)){
                    ans +=  Math.min(nums1[index1],nums2[index2]);
                    break;
                }


            } while (midIndex != (index1 + index2 + 2));
            midIndex += 1;
        }
        System.out.println(ans);
        return ans / size;


    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2,4};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}
