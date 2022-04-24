package com.xiaohua.tixiclass.class01;
import com.xiaohua.tixiclass.PublicMethodUtils;


/**
 * 求任意局部最小
 *      如果0为位置的比1位置小那么0就可以返回，如果最后一个比倒数第二个小那么就可以返回
 *      局部最小即 该数比左边小也比右边小
 * @author xiaohua
 * @create 2022-04-01 12:15
 */
public class Two {

    public static int getLeftAndRightMin(int[] arr){
        if (arr==null||arr.length<1){
            return Integer.MAX_VALUE;
        }
        if (arr.length==1){//数组长度为1
            return 0;
        }
        //这是两个边界情况
        if (arr[0]<arr[1]){
            return 0;
        }
        if (arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
//        正常情况开始判断
        int left = 0;
        int right = arr.length-1;
        while (left<right-1){
            int mid = left+((right-left)>>1);
            if (arr[mid]<arr[mid+1]&&arr[mid]<arr[mid-1]){
                return mid;
            }else if (arr[mid-1]<arr[mid]){
                right=mid-1;
                continue;
            } else {
                left=mid+1;
                continue;
            }
        }
        return arr[left]<arr[right]?left:right;
    }

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = PublicMethodUtils.getRandomNum(maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static int[] RandomArray(int maxValue,int maxLen){
        int len = (int)(Math.random()*maxLen);
        int[] arr = new int[len];
        if (len>0){
            arr[0]= (int)(Math.random()*maxValue);
            for (int i =1;i<arr.length;i++){
               do {
                   arr[i]=(int)(Math.random()*maxValue);
               }while (arr[i] ==arr[i-1]);
            }
        }
        return arr;
    }

    public static boolean Check(int[] arr,int index){
        if (arr==null||arr.length==0){
            return index==Integer.MAX_VALUE;
        }

        if (arr.length==1){
            return index==0;
        }
        int left = index-1;
        int right = index+1;
//        System.out.println("数组left："+left+ "right：" + right+ "len： "+arr.length);
        boolean leftBigger = left >= 0 ? arr[left] > arr[index] : true;
        boolean rightBigger = right < arr.length-1 ? arr[right] > arr[index] : true;
        return leftBigger&&rightBigger;
    }
    public static void main(String[] args) {

        int maxLen = 2000;
        int maxValue = 1000;
        int timeNum = 100000;
        boolean flag = true;
        for (int i = 0; i <timeNum ; i++) {
            int[] arr = randomArray(maxValue,maxLen);
            int min = getLeftAndRightMin(arr);
            boolean check = Check(arr, min);
            if (!check){
                PublicMethodUtils.print(arr);
                System.out.println(min);
                flag=false;
                break;
            }

        }
        String result = (flag)? "good":"fuck!!";
        System.out.println(result);
    }

}
