package com.xiaohua.tixiclass.class15;

/**
 * @author xiaohua
 * @create 2022-06-23 0:22
 */
public  class UnionArrTwo{
    int[] parent;
    int[] size;
    int[] help;
    int sets;
    int sizeMax;

    public UnionArrTwo(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int N = row * col;
        sets = 0;
        sizeMax=0;
        parent = new int[N];
        size = new int[N];
        help = new int[N];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j]==1){
                    int index = index(i, j, col);
                    parent[index] =index;
                    size[index] = 1;
                    sets++;
                }
            }
        }
    }
    public  int index(int i,int j ,int col){
        return i*col+j;
    }

    public  int findFather(int i,int j,int col){
        int indexHelp = 0;
        int indexArr = index(i, j, col);
        while (parent[indexArr]!=indexArr){
            indexArr = parent[indexArr];
            help[indexHelp++] = indexArr;
        }
        for (int k = --indexHelp; k >=0 ; k--) {
            parent[help[indexHelp]] = indexArr;
        }
        return indexArr;

    }

    public  void union(int i,int j,int k,int z,int col){
        if (size[index(i,j,col)] == 0 || size[index(k,z,col)] == 0) {
            return;
        }
        int Afather = findFather(i, j, col);
        int Bfather = findFather(k, z, col);
        if (Afather!=Bfather){
            int Asize = size[Afather];
            int Bsize = size[Bfather];
            if (Asize>Bsize){
                parent[Bfather]=Afather;
                size[Afather] += size[Bfather];
                sizeMax = Math.max(sizeMax, size[Afather]);
                sets--;
            }else {
                parent[Afather] = Bfather;
                size[Bfather] += size[Afather];
                sizeMax = Math.max(sizeMax, size[Bfather]);
                sets--;
            }
        }


    }
}
