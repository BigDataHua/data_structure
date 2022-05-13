package com.xiaohua.tixiclass.class07;

import com.xiaohua.QuickSort;
import com.xiaohua.tixiclass.PublicMethodUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.xiaohua.tixiclass.class04.MergeSort.equalArr;

/**
 * 给定很多线段，每个线段都有两个数[start, end]，
 表示线段开始位置和结束位置，左右都是闭区间
 规定：
 1）线段的开始和结束位置一定都是整数值
 2）线段重合区域的长度必须>=1
 返回线段最多重合区域中，包含了几条线段
 * 最大重合线段数
 * @author xiaohua
 * @create 2022-05-07 23:54
 */

class Line{
    int left = 0;
    int right = 0;
    public Line(){

    }

    public Line(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class mixLine {



    public int getMaxLine(Line[] arr){
        if (arr==null||arr.length<1){
            return 0;
        }
        QuickSort.sort(arr, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.left-o2.left;
            }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            while (heap.size()!=0&&arr[i].left>=heap.peek()){
                heap.poll();
            }
            heap.add(arr[i].right);
            result = Math.max(result,heap.size());
        }
        return result;
    }


    public Line[] getLines(int max, int len){

        do {
            if (len==0){
                len+=(int) (max*Math.random());
            }
            len = (int) (Math.random() * len);
        }while (len==0);

        Line[] arr = new Line[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Line();
            arr[i].left = PublicMethodUtils.getRandomNum(max);
            do {
                arr[i].right = PublicMethodUtils.getRandomNum(max)+10;
            }while (arr[i].left>=arr[i].right);
        }
        return arr;
    }

    public int check(Line[] arr){
        if (arr==null||arr.length<1){
            return 0;
        }

        int leftMin =arr[0].left;
        int rightMax = arr[0].right;

        for (int i = 1; i < arr.length; i++) {
            leftMin = Math.min(arr[i].left, leftMin);
            rightMax = Math.max(arr[i].right,rightMax);
        }
        int result = 0;
        for (float i = (float) (leftMin+0.5); i <rightMax ; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].left<i&&i<arr[j].right){
                    count++;
                }
            }
            result = Math.max(result,count);
            count = 0;
        }
        return result;

    }

    public static void main(String[] args) {
        int max = 10000;
        int len = 1000;
        int time  =1000;
        boolean flag = true;
        mixLine mixLine = new mixLine();
        for (int i = 0; i < time; i++) {
            System.out.println(i);
            Line[] randomArr = mixLine.getLines(max,len);
            Line[] copyArr = copyArr(randomArr);
            int ran = mixLine.getMaxLine(randomArr);
            int check = mixLine.check(copyArr);
            flag=(ran==check);
            if (!flag){
                break;
            }



        }
        if (flag==true){
            System.out.println("Nice");
        }else {
            System.out.println("nonono");
        }

    }

    private static Line[] copyArr(Line[] randomArr) {
        Line[] line = new Line[randomArr.length];
        for (int i = 0; i < line.length; i++) {
            line[i] = new Line(randomArr[i].left,randomArr[i].right);
        }
        return line;

    }


}
