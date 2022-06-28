package com.xiaohua.tixiclass.class15;

/**
 * @author xiaohua
 * @create 2022-06-22 0:22
 */
public class UnionArr {

    int[] parent;
    int[] size;
    int[] help;

    int sets;

    public UnionArr(int length){
        parent = new int[length];
        size = new int[length];
        help = new int[length];
        sets = length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findFather(int i){
        int index = 0;
        help[index++] = i;
        while (i!=parent[i]){
            i = parent[i];
            help[index++]=i;
        }
        for (index--;index>=0;index--){
            parent[help[index]] = i;
        }
        return i;
    }

    public void union(int i,int j ){
        int iFather = findFather(i);
        int jFather = findFather(j);
        if (iFather!=jFather){
            int iSize = size[i];
            int jSize = size[j];
            int bigFather = iSize > jSize ? iFather : jFather;
            int smallFather = bigFather == iSize ? jFather : iFather;
            parent[smallFather] = bigFather;
            size[bigFather] += size[smallFather];
            sets -= 1;
        }
    }
    public int getSets(){
        return sets;
    }


}
