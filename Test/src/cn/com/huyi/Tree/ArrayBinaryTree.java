package cn.com.huyi.Tree;

/**
 * @title: ArrayBinaryTree
 * @Author SXSQ
 * @Description //TODO 顺序存储二叉树，基于数组的二叉树实现
 * @Date 2022/4/25 16:11
 **/

public class ArrayBinaryTree<E> {
    private E [] arr; //用于存储结点的数组

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree<Integer>(arr);
        arrayBinaryTree.preOrder();
    }

    public ArrayBinaryTree(E [] arr) {
        this.arr = arr;
    }


    public void preOrder(){
        this.preOrder(0);
    }


        /**
         * @Description //TODO 完成二叉树的前序遍历
         * //TODO  第n个元素的左子节点为2*n+1
         * //TODO  第n个元素的右子节点为2*n+2
         * //TODO  第n个元素的父节点为（n-1）/2
         * @param index 数组下标
         */
    public void preOrder(int index){
        if (arr == null || arr.length == 0) {
            System.out.println("二叉树为空！");
        }
        System.out.println(arr[index]);
        if ((index * 2 + 1) < arr.length) preOrder(index * 2 + 1);
        if ((index * 2 + 2) < arr.length) preOrder(index * 2 + 2);
    }

}
