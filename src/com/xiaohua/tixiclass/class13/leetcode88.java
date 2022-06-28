package com.xiaohua.tixiclass.class13;

/**
 * @author xiaohua
 * @create 2022-06-12 0:59
 */
public class leetcode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = m+n-1;
        int n1 = m-1;
        int n2 = n-1;
        while (n1>=0&&n2>=0){
            if (nums1[n1]>nums2[n2]){
//                n1大
                nums1[index--] = nums1[n1--];


            }else {
//                n2大
                nums1[index--] = nums2[n2--];
            }

        }
        while (n1>=0){
            nums1[index--] = nums1[n1--];
        }
        while (n2 >= 0) {
            nums1[index--] = nums2[n2--];
        }

    }


}
