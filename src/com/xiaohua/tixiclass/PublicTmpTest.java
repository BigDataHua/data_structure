package com.xiaohua.tixiclass;

import org.junit.Test;

/**
 * @author xiaohua
 * @create 2022-03-31 21:56
 */
public class PublicTmpTest {
    @Test
    public void test01(){

        int num=0;
        do {
            num = (int)(Math.random()*1000);
            System.out.println(num);
        }while ((num<=1)&&(num%2==0)&&(num<(1000/2)));

    }

}
