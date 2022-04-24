package com.xiaohua.rumen.two;

/** 得到一个随机范围的数字，返回另外随机范围的数字
 *
 * 思路：无论给的什么等概率  如果区间为偶数个 直接进行划分0和1
 * 如果区间为奇数 那么重做中间的数字 划分 0和1
 *
 * 然后目标范围是a到b
 * 用二进制刻画等概率0-（b-a）的范围
 * 最后返回加上a就行
 *
 *
 * @author xiaohua
 * @create 2022-03-18 22:46
 */
public class RundomToRange {

    //随机得到1-5   目标返回 1-7
    public static int f1(){
        return (int) (Math.random()*5+1);

    }

    //切分为 0 1
    public static int f2(){
        int num;
        do {
            num = f1();

        }while (num==3);
        return (num<3)? 0:1;
    }
    //返回 1-7  根据二进制拼接
    public static int f3(){
        int num;
        do {
            num=(f2()<<2)+(f2()<<1)+(f2()<<0);
        }while (num==7);
        return num+1;
    }


    public static void testRandom(int arr[]){
        int num = 100000;
        int tmp;
        for (int i = 0; i < num; i++) {
            tmp=f3();
            arr[tmp]++;
        }

//        for (int i = 0; i < arr.length; i++) {
//            arr[i]/=num;
//        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }




    public static void main(String[] args) {
        int[] count = new int[8];
        testRandom(count);

    }




}
