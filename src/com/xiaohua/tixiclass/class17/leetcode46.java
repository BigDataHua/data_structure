package com.xiaohua.tixiclass.class17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaohua
 * @create 2022-06-28 0:40
 */
public class leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums==null||nums.length<1){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        process(arr, 0, ans);
        return ans;

    }

    private void process(ArrayList<Integer> nums, int index, List<List<Integer>> ans) {
        if (index==nums.size()){
            ans.add(new ArrayList<Integer>(nums));
            return;
        }
        boolean[] booleans = new boolean[10];
        for (int i = index; i <nums.size() ; i++) {
            if (!booleans[i]){
                booleans[i] = true;
                swap(nums, index, i);
                process(nums,index+1,ans);
                swap(nums,index,i);
            }


        }
    }

    private void swap(ArrayList<Integer> nums, int index, int i) {

        int tem = nums.get(index);
        nums.set(index, nums.get(i));
        nums.set(i, tem);
    }


    public List<List<Integer>> permute2(int[] nums) {
        if (nums==null||nums.length<1){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        f(arr, "", ans);

        return ans;

    }

    public void f(ArrayList<Integer> arr, String path, List<List<Integer>> ans) {
        if (arr.isEmpty()){
            String[] split = path.split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (String s : split) {
                list.add(Integer.parseInt(s));
            }
            ans.add(list);
        }else {
            int N = arr.size();
            for (int i = 0; i <N ; i++) {
            Integer inum = arr.get(i);
            arr.remove(i);

            f(arr,path+inum+" ",ans);
            arr.add(i, inum);
        }

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = new leetcode46().permute2(arr);
        for (List<Integer> integers : permute) {
            System.out.println(integers.toString());
        }
    }
}
