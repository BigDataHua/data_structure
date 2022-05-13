package com.xiaohua.tixiclass.class07;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
/**
 * 加强堆的实现
 * @author xiaohua
 * @create 2022-05-07 22:41
 */
public class HeapGreater<T>{

    private ArrayList<T> heap;
    private HashMap<T,Integer> indexMap;
    private int heapsize;
    private Comparator<T> comp;

    public HeapGreater(Comparator comp){
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapsize = 0;
        this.comp = comp;
    }

    public boolean isEmpty(){
        return heapsize==0 ;
    }

    public int getHeapsize(){
        return heapsize;
    }

    public boolean comtains(T obj){
        return indexMap.containsKey(obj);
    }

    public T peek(){
        return heap.get(0);
    }

    public void push(T obj){
        heap.add(obj);
        indexMap.put(obj, heapsize);
        heapInsert(heapsize++);

    }

    public T pop(){
        T ans = heap.get(0);
        swap(0,--heapsize);
        indexMap.remove(ans);
        //两个remove都行 一个是index（O（1）） 一个是元素（O（N））
        heap.remove(heapsize);
//        heap.remove(ans);
        heapify(0);
        return ans;
    }

    public void remove(T obj){
        T replace = heap.get(heapsize - 1);
        Integer integer = indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapsize);
        if (replace !=obj){
            heap.set(integer,replace);
            indexMap.put(replace, integer);
            resign(integer);
        }
    }

    private void resign(Integer index) {
        heapify(index);
        heapInsert(index);
    }

    //返回堆上所有元素
    public List<T> getAllElements(){
        List<T> list = new ArrayList<>();
        for (T t : heap) {
            list.add(t);
        }
        return list;
    }

    private void heapInsert(int index) {
        while (comp.compare(heap.get(index),heap.get((index-1)/2))<0){
            swap(index,(index-1)/2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index){
        int left = index*2+1;
        while (left<heapsize){
            int bigger = left+1<heapsize&&comp.compare(heap.get(left+1),heap.get(left))<0?left+1:left;
            bigger = comp.compare(heap.get(bigger),heap.get(index))<0?bigger:index;
            if (bigger==index){
                break;
            }
            swap(bigger,index);
            index = bigger;
            left = index*2+1;
        }
    }

    private void swap(int i, int j) {
        T t1 = heap.get(i);
        T t2 = heap.get(j);
        heap.set(i, t2);
        heap.set(j, t1);
        indexMap.put(t1, j);
        indexMap.put(t2, i);

    }


}
