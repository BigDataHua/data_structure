package com.xiaohua.rumen.one;

import sun.reflect.generics.tree.Tree;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import javax.swing.event.TreeExpansionEvent;
import java.security.PrivateKey;

/**入门第一课
 *
 *
 求任意一个数的2进制表示
 演示一下位运算
 一个数的相反数  取反加一
 负数最小的相反数为本身
 0的相反数
 算法分类
 明确知道怎么算的流程
 明确知道怎么尝试的流程
 选择加冒泡加直接插入

 *
 * @author xiaohua
 * @create 2022-03-16 13:25
 */
public class 位运算 {


    //求一个数的32进制
    public static void print(int num){
        //循环取每个进制的数
        for (int i = 31;i>=0;i--){
            //三目运算符的判断条件是布尔值
            int result = (num & (1 << i))==0 ? 0 : 1;
            System.out.print(result);
        }
        System.out.println();

    }




    public static void main(String[] args) {

        //对于取某个数的相反数来说
        //既可以选择 直接加负号  也可以取反加1
        //两种方法
//        int a = 19292;
//        int b =~a+1;
//        print(-a);
//        print(b);
//        print(a & b);//&运算相同为一不同为零
//        print(a | b);//|运算有1为1 全零为零
//        print(~a); //~取反运算
//        print(a^b);//^异或运算 相同为零 不同为1

        //最小负数的相反数是它本身
        //原理：最小的负数在底层存储的是 10000...000  进行取反变为 011111...111  然后加一进位
//        int num = Integer.MIN_VALUE;
//        print(num);//10000000000000000000000000000000
//        print(-num);//10000000000000000000000000000000
//        print(~num+1);//10000000000000000000000000000000
        //0和其相反数的二进制代码  在底层存储的是 00000...000  进行取反变为 111111...111  然后加一进位
        //成了 100000....000  其中首位的1在33位 溢出舍去
//        print(0);
//        print(~0+1);






    }





}
