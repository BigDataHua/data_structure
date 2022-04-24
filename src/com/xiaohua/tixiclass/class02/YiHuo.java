package com.xiaohua.tixiclass.class02;



import com.xiaohua.tixiclass.PublicMethodUtils;
import org.junit.Test;

import java.sql.Time;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 异或有关的运算
 *异或 与同或 有可能你记混淆  全部理解为无进位相加
 *
 *
 * 用异或完成交换 （不申请额为的变量） 两个数的值
 * 如何求出一个数的三十二位
 * 如何求出一个数的最右的1
 * 一个数组 一种数为奇数  其他为偶数 求出那个奇数
 * 一个数组 两种数为奇数  其他为偶数 求出那两个数
 *
 * m>1  要求空间复杂度为常数级别  时间复杂度为O（N）
 * 一个数组 一种数为 k个  其他数都为m个  k<m  求出那个数有k个
 * 一个数组 一种数可能有k个  其他数都为m个 k<m 如果存在那个数有k个则输出 否则返回-1
 *
 * @author xiaohua
 * @create 2022-03-25 18:46
 */
public class YiHuo {


    /**
     * 用异或完成两个数的交换
     */
    @Test
    public  void test01(){
        int a = 10;
        int b  =  19;
        a=a^b;
        b=a^b;
        a=a^b;

        System.out.println(a + "  " + b);

    }

    /**
     * 如何求出一个数的32位
     * 让她每次与1进行 与 运算 ，如果为零那么就是零  否则就可能是非零的正数（2的n次幂形式）
     * 然后进行输出
     */
    @Test
    public void test02(){
        int a = 8;
        for (int i = 0; i <32; i++) {
            int result = (a&(1<<i))==0?0:1;
            System.out.print(result);
        }
    }

    /**
     * 如何取出最右的1
     *
     * 利用位运算   你要取出一个数的最右的1 首先你讲它取反
     * 00....0010
     * 取反
     * 11....1101
     * 加一
     * 11....1110
     * 然后进行 与运算  就得到了 00...0010
     *
     */
    @Test
    public void test03(){

        int a= 7;
        for (int i = 0; i <32; i++) {
            int result = (a&(1<<i))==0?0:1;
            System.out.print(result);
        }
        System.out.println();
        int b = (~a+1);
        System.out.println(a&b);

    }

    /**
     * 异或 一个数组 一种数为奇数  其他为偶数 求出那个奇数
     */
    public int OneArr(int[] arr){
        int result = 0;
        for (int i : arr) {
            result = result^i;
        }
        return result;
    }
    public int OneTestArr(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if(!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.put(i,map.get(i)+1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer)%2==1){

                return integer;
            }
        }

        return Integer.MAX_VALUE;
    }

    @Test
    public void test04(){
        int max = 100000;
        int length = 10000;
        int timeNum = 1000;
        boolean flag = true;
        for (int i = 0; i < timeNum; i++) {
            int[] arr = RandomToOne(max,length);
            //打乱顺序
            arr = PublicMethodUtils.getArrToRandom(arr);
            int num1 = OneArr(arr);
            int num2 = OneTestArr(arr);
            if (num1!=num2){
                flag=false;
                for (int num:arr) {
                    System.out.println(num+" ");
                }
                break;
            }
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[j]+" ");
//            }
        }


        String reslut = (flag)? "good":"fuck!!!";
        System.out.println(reslut);


    }



    private static int[] RandomToOne(int max,int length) {

        int[] arr =new int[(int) (PublicMethodUtils.getArrLen(length))];
        int num=0;
        do {
            num = (int)(Math.random()*length);
//            System.out.println("num:"+num);
//            System.out.println("arr.len:"+arr.length);
        }while (num<1||num%2!=1||num>arr.length/2);

        //设置真命天子
        int oneNum =PublicMethodUtils.getRandomNum(max);
        for (int i = 0; i < num; i++) {
            arr[i] = oneNum;
        }

        //设置陪嫁
        for (int i = num; i < arr.length; i++) {
            oneNum =PublicMethodUtils.getRandomNum(max);
            arr[i++]=oneNum;
            if (i >= arr.length) break;
            arr[i]=oneNum;
        }


        return arr;
    }


    /**
     * 一个数组 两种数为奇数  其他为偶数 求出那两个数
     */
    private static int[] RandomToTwo(int max,int length) {


        int len;
        do {
            len=PublicMethodUtils.getArrLen(length);
        }while (len%2!=0);

        int[] arr =new int[len];
        int num1=0;
        do {
            num1 = (int)(Math.random()*length);

        }while (num1<1||num1%2!=1||num1>arr.length/3);

        int num2=0;
        do {
            num2 = (int)(Math.random()*length);
        }while (num2<1||num2%2!=1||num2>arr.length/3);

        //设置真命天子
        int oneNum =PublicMethodUtils.getRandomNum(max);
        int twoNum =PublicMethodUtils.getRandomNum(max);


        for (int i = 0; i < num1; i++) {
            arr[i] = oneNum;
        }
        for (int i = num1; i < num2; i++) {
            arr[i] = twoNum;
        }

        //设置陪嫁
        for (int i = num2; i < arr.length; i++) {
            oneNum =PublicMethodUtils.getRandomNum(max);
            arr[i++]=oneNum;
            if (i >= arr.length) break;
            arr[i]=oneNum;
        }

        //打乱顺序
        for (int i = 0; i < arr.length; i++) {
            int index01 = (int)(Math.random()*arr.length);
            int index02 = (int)(Math.random()*arr.length);
            if (index01!=index02){
                arr[index01]=arr[index01]^arr[index02];
                arr[index02]=arr[index01]^arr[index02];
                arr[index01]=arr[index01]^arr[index02];

            }
        }

        return arr;
    }

    public static int[] TwoArr(int arr[]){
        int[] ans = new int[2];
        int eor1 = 0;//0与任何数异或 仍是本身
        //得到两个奇数异或的结果
        for (int i = 0; i < arr.length; i++) {
            eor1 = eor1^arr[i];
        }

        int eor2=0;
        int num = eor1&(-eor1);
        for (int i = 0; i < arr.length; i++) {
            if ((num&arr[i])==0){
                eor2=eor2^arr[i];
            }
        }
        ans[0]=eor2;
        ans[1]=eor1^eor2;
        return ans;
    }

    public static int[] TwoTestArr(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if(!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.put(i,map.get(i)+1);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer)%2==1){

                ans[i++] = integer;
            }
        }

        return ans;

    }

    public static boolean checkTwoArr(int[] arr1,int[] arr2){
        if (arr1[0]!=arr2[0]){
            arr1[0] = arr1[0]^arr1[1];
            arr1[1] = arr1[0]^arr1[1];
            arr1[0] = arr1[0]^arr1[1];
        }
        if ((arr1[0]==arr2[0])&&(arr1[1]==arr2[1])){
            return true;
        }

        return false;
    }

    @Test
    public void test05(){
        int max = 10000;
        int len = 10000;
        int time = 10000;
        boolean flag = true;
        System.out.println("测试开始");
        for (int i = 0; i <time ; i++) {
            int[] arr = RandomToTwo(max,len);
            int[] ans1 = TwoArr(arr);
            int[] ans2 = TwoTestArr(arr);
            if(!checkTwoArr(ans1,ans2)){

                PublicMethodUtils.print(arr);
                PublicMethodUtils.print(ans1);
                PublicMethodUtils.print(ans2);
                flag = false;
                break;
            }

        }

        String ans = flag? "good!!":"fuck";

        System.out.println("测试结束"+ans);
    }

    /**
     * m>1  要求空间复杂度为常数级别  时间复杂度为O（N）
     * 一个数组 一种数为 k个  其他数都为m个  k<m  求出那个数有k个
     */

    private static int[] RandomToKOne(int max,int k,int m){

        //真命天子
        int twoK;
        do {
            twoK= (Math.random()<0.5)? k:(int) (Math.random()*m)+1;
        }while (twoK>m);
        int[] arr = new int[twoK+(twoK*m)];
        int num = PublicMethodUtils.getRandomNum(max);
        HashSet<Integer> set = new HashSet<>();
        int i;
//        设置k
        for (i = 0; i < twoK; i++) {
            arr[i]=num;
        }
        set.add(num);

        //设置m个数

        for (int kNum = 0;kNum<twoK;kNum++){
            do {
                num=PublicMethodUtils.getRandomNum(max);

            }while (set.contains(num));
            set.add(num);
            for (int mNum = 0; mNum < m; mNum++) {
                arr[i++]=num;
            }
        }
        //打乱顺序
        for (int j = 0; j < arr.length/2; j++) {
            int index1 = (int) (Math.random()*arr.length);
            int index2 = (int) (Math.random()*arr.length);
            if (index1!=index2){
                arr[index1]=arr[index1]^arr[index2];
                arr[index2]=arr[index1]^arr[index2];
                arr[index1]=arr[index1]^arr[index2];
            }
        }
        return arr;
    }

    public static int OneKArr(int[] arr,int k,int m){

        int[] ans = new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                ans[j]=ans[j]+((arr[i]&(1<<j))==0?0:1);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i]=ans[i]%m;
        }
        int result=0;
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]==0||(ans[i]==k&&ans[i]!=0)) {
                if (ans[i]==k) {
                    result = result + (1 << i);
                }
            }else {
                //失败返回int的最大值
                return Integer.MAX_VALUE;
            }
        }

        //最后收尾，以防 k=0的情况出错
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==result){
                count++;
            }
        }

        return (count==k)?result:Integer.MAX_VALUE;
    }

    public static int CheckOneKArr(int[] arr,int k,int m){

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){//当前map是否包含arr[i]
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        for (Integer integer : map.keySet()) {

                map.put(integer,map.get(integer)%m);

        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer)==k){
                return integer;
            }
        }

        //因为必定存在k，所以走不到这个return
        return Integer.MAX_VALUE;

    }

    @Test
    public void test06() {

        int max = 1000;
        int len = 1000;
        int time = 1000;
        int[] arr;
        boolean flag = true;
        System.out.println("测试开始:");
        for (int num = 0; num < time; num++) {
            int k;
            do {
                k = (int) (Math.random() * len);
            } while ((k < 1)||(k>len/3));
            int m;
            do {
                m = (int) (Math.random() * len);
            } while (m <=k);
//            System.out.println("进行了"+num+"次");
            arr = RandomToKOne(max, k, m);
            int ans1 = OneKArr(arr, k, m);
            int ans2 = CheckOneKArr(arr, k,m);
//            System.out.println("进行了"+num+"次");
            if (ans1 != ans2) {
                flag = false;
                System.out.println("ans1:"+ans1);
                System.out.println("ans2:"+ans2);
                System.out.println("k:"+k);
                System.out.println("m:"+m);
                System.out.println("shuzu");
                for (int i : arr) {
                    System.out.println(i);
                }
                break;
            }
        }


        String result = flag? "good!":"fuck!";

        System.out.println("测试结束："+result);
    }

}
