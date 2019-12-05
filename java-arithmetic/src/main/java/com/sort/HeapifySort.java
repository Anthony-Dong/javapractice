package com.sort;

/**
 * TODO
 *
 * @date:2019/11/20 20:21
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class HeapifySort {

    public static void main(String[] args) {
        int[] tree = {8, 7, 9, 5, 2, 7, 1, 2, 0};

        heap_sort(tree, tree.length);

        for (int i : tree) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    /**
     * 堆排序
     *
     * @param tree
     * @param n
     */
    static void heap_sort(int[] tree, int n) {

        // 1. 构建一个堆
        build_heap(tree, n);

        // 2.
        // 堆顶和最后一个节点做交换 , 但是我们需要在数组上截取 , 所以就是每次
        for (int i = n - 1; i >= 0; i--) {
            // 交换节点
            swap(tree, i, 0);

            // 第0个位置 开始堆重新排序
            heapify(tree, i, 0);
        }
    }

    /**
     * 构建一个 大顶堆
     *
     * @param tree
     * @param n
     */
    static void build_heap(int[] tree, int n) {

        // 最后一个节点
        int last_node = n - 1;

        // 开始遍历的位置是 : 最后一个堆的堆顶 , 意思就是 , 整个树中最小的一个堆 , 其实就是最后一个节点的父节点
        int parent = (last_node - 1) / 2;

        // 递减向上遍历
        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }


    /**
     * @param tree 代表一棵树
     * @param n    代表多少个节点
     * @param i    对哪个节点进行 heapify
     */
    static void heapify(int[] tree, int n, int i) {

        // 如果当前值 大于 n 直接返回了 ,一般不会出现这种问题 .....
        if (i >= n) {
            return;
        }

        // 子节点
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;

        // 假设最大的节点 为 i (父节点)
        int max = i;

        // 如果大于  赋值给 max
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }

        // 如果大于  赋值给 max
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }

        // 如果i所在的就是最大值我们没必要去做交换
        if (max != i) {

            // 交换最大值 和 父节点 的位置
            swap(tree, max, i);


            // 交换完以后 , 此时的max其实就是 i原来的数 ,就是最小的数字 ,所以需要递归遍历
            heapify(tree, n, max);
        }

    }


    static void swap(int[] tree, int max, int i) {
        int temp = tree[max];
        tree[max] = tree[i];
        tree[i] = temp;
    }

}
