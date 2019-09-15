package com.javase.Keyword.collection;


/**
 * TODO
 *
 * @date:2019/9/11 22:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) {
        ///  4个字节   2*31-1
//        System.out.println(Integer.MAX_VALUE);


        System.out.println(10&(byte)1);
        System.out.println(10>>>1);
    }


}

class Heep{
    int[] arr ;

    public Heep(int[] arr) {
        this.arr = arr;
    }


//    public void add(int num){
//        this.arr[arr.length] = num;
//    }

    public void build(){
        int length = this.arr.length;

//     i 指的是 最后一个的叶子节点的父节点
        for (int i = length / 2 - 1; i >= 0; i++) {

            int parent = i;

            int l = i * 2;
            int r = i * 2 + 1;

            if (this.arr[l - 1] >this.arr[i - 1]||this.arr[r - 1] > this.arr[i - 1]) {
                this.arr[i - 1] = this.arr[l - 1];
            }



        }

    }
}