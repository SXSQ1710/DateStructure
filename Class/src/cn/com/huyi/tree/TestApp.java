package cn.com.huyi.tree;

import org.junit.Test;

/**
 * @title: TestApp
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/5/12 10:36
 **/

public class TestApp {
    @Test
    public void test1() {
        String [] str = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H",null,null,null};
        Integer [] a = {1,2,3,4,5,6};
        BinaryTree<String> integerBinaryTree = new BinaryTree<>(str);
        integerBinaryTree.preOrder();
        integerBinaryTree.inOrder();
        integerBinaryTree.postOrder();
        integerBinaryTree.countLeaves();
//        integerBinaryTree.getHeight();
    }

    @Test
    public void testRemove(){
        String [] str = {"A","B","D",null,"G",null,null,null,"B","E",null,null,"F","H",null,null,null};
        BinaryTree<String> integerBinaryTree = new BinaryTree<>(str);
        System.out.print("remove前的结果进行前序遍历:");
        integerBinaryTree.preOrder();
        BinaryNode<String> removeNode = integerBinaryTree.remove("B");
        System.out.println("remove的结点为:"+removeNode);
        System.out.print("remove后的结果进行前序遍历:");
        integerBinaryTree.preOrder();
    }

    @Test
    public void testIsSorted(){
        Integer [] intList = {3,2,1,null,4,null,null,null,6,9,null,null,8,7,null,null,null};
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(intList);
        integerBinaryTree.preOrder();
        System.out.println("该二叉树是否为二叉排序树:" + integerBinaryTree.isSorted());
    }

    @Test
    public void testParent(){
        Integer [] intList = {3,2,1,null,4,null,null,null,6,5,null,null,8,7,null,null,null};
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(intList);
        integerBinaryTree.preOrder();
        BinaryNode<Integer> p = new BinaryNode<>(4);
        System.out.println("该结点的父母结点为:" + integerBinaryTree.parent(p).getDate());
    }

    @Test
    public void testProperty3(){
        Integer [] intList = {3,2,1,null,4,null,null,null,6,5,null,null,8,7,null,null,null};
        BinaryTree<Integer> integerBinaryTree1 = new BinaryTree<>(intList);
        System.out.print("前序遍历结果:");
        integerBinaryTree1.preOrder();
        integerBinaryTree1.property3(integerBinaryTree1);
        String [] str = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H",null,null,null};
        BinaryTree<String> integerBinaryTree2 = new BinaryTree<>(str);
        System.out.print("前序遍历结果:");
        integerBinaryTree2.preOrder();
        integerBinaryTree2.property3(integerBinaryTree2);
    }

    @Test
    public void testswap1(){
        Integer [] intList = {3,2,1,null,4,null,null,null,6,5,null,null,8,7,null,null,null};
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(intList);
        integerBinaryTree.swap1(integerBinaryTree);
    }

    @Test
    public void testswap2(){
        Integer [] intList = {3,2,1,null,4,null,null,null,6,5,null,null,8,7,null,null,null};
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(intList);
        integerBinaryTree.swap2(integerBinaryTree);
    }

    @Test
    public void testswap3(){
        Integer [] intList = {3,2,1,null,4,null,null,null,6,5,null,null,8,7,null,null,null};
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(intList);
        integerBinaryTree.swap3(integerBinaryTree);
    }
}
