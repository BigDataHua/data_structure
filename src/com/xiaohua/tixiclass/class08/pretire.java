package com.xiaohua.tixiclass.class08;

/** 前缀树
 * @author xiaohua
 * @create 2022-05-09 23:00
 */

class Node{

    public int pass;
    public int end;
    public Node[] nexts;

    public Node(){
        pass = 0;
        end = 0;
        nexts = new Node[26];
    }



}

public class pretire {
    private Node root = null;
    public pretire(){
        root = new Node();
    }

    //插入方法
    public void insert(String word){
        if (word==null){
            return;
        }
        char[] arr = word.toCharArray();
        Node p = root;
        p.pass++;
        for (int i = 0; i < arr.length; i++) {
            if (p.nexts[arr[i]-'a']==null){
                p.nexts[arr[i]-'a'] = new Node();
            }
            p = p.nexts[arr[i]-'a'];
            p.pass++;
        }
        p.end++;

    }

    //删除方法
    public void delete(String word){
        if (search(word)==0){
            return;
        }
        Node p =root;
        p.pass--;
        char[] array = word.toCharArray();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            index = array[i] - 'a';
            if (--p.nexts[index].pass==0){
                p.nexts[index]=null;
                return;
            }
            p = p.nexts[index];
        }
        p.end--;

    }
    //查找方法 这个单词之前加入过几次
    public int search(String word){
        if (word==null){
            return 0;
        }
        char[] arr = word.toCharArray();
        Node p = root;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            index = arr[i] - 'a';
            if (p.nexts[index]==null){
                return 0;
            }
            p = p.nexts[index];
        }
        return p.end;
    }

    //所有加入字符中，有多少个是以此为前缀
    public int perString(String word){
        if (word==null){
            return  0 ;
        }
        Node p = root;
        char[] array = word.toCharArray();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            index = array[i]-'a';
            if (p.nexts[index]==null){
                return 0;
            }
            p = p.nexts[index];
        }
        return p.pass;


    }


    public static void main(String[] args) {
        pretire pretire = new pretire();
        pretire.insert("huahua");
        pretire.insert("li");
        pretire.insert("xiaohua");
        pretire.insert("china");
        System.out.println(pretire.search("china"));
    }
}
