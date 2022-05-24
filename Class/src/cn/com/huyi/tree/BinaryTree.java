package cn.com.huyi.tree;

import java.net.PortUnreachableException;

/**
 * @title: BinaryTree
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/5/12 10:21
 **/

public class BinaryTree <T extends Comparable<? super T>>{
    private BinaryNode<T> root;
    private int i;
    private int numOfLeaf;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryTree(T[] preList) {
        this.i = 0;
        this.root = creat(preList);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    private BinaryNode<T> creat(T[] preList) {
        BinaryNode<T> p = null;
        if (i < preList.length){
            T elem = preList[i++];
            if (elem != null){
                p = new BinaryNode<>(elem);
                p.setLeft(creat(preList));
                p.setRight(creat(preList));
            }
        }
        return p;
    }

    public void preOrder(){
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(BinaryNode<T> p) {
        if (p != null){
            System.out.print(p.getDate() + " ");
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }
    }

    public void inOrder(){
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(BinaryNode<T> p) {
        if (p != null){
            inOrder(p.getLeft());
            System.out.print(p.getDate() + " ");
            inOrder(p.getRight());
        }
    }

    public void postOrder(){
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(BinaryNode<T> p) {
        if (p != null){
            postOrder(p.getLeft());
            postOrder(p.getRight());
            System.out.print(p.getDate() + " ");
        }
    }

    //返回一共由多少个叶子结点
    public void countLeaves(){
        this.numOfLeaf = 0;
        countLeaves(this.root);
        System.out.println("一共有" + this.numOfLeaf + "个叶子结点");
    }

    private void countLeaves(BinaryNode<T> p) {
        if (p != null){
            if (p.isLesf()) {
                this.numOfLeaf++;
            }
            countLeaves(p.getLeft());
            countLeaves(p.getRight());
        }
    }

    //求二叉树的高度
//    public void getHeight(){
//        int hight = 0;
//        hight = getHeight(this.root);
//        System.out.println("二叉树的高度为" + hight);
//    }
//
//    private int getHeight(BinaryNode<E> p) {
//        if (p == null) return 0;
//        else {
//            int lh = getHeight(p.getLeft());
//            int rh = getHeight(p.getRight());
//            return lh >= rh ? lh : rh;
//        }
//    }

    //TODO ① BinaryNode<T> remove(T key); //查找并删除首个以与key相等元素结点为根的子树
    private BinaryNode<T> removeNode;
    private boolean hasRemove = false;
    public BinaryNode<T> remove(T key){
        if (this.root.getDate().compareTo(key) == 0){
            this.removeNode = root;
            this.root = null;
            return removeNode;
        }else if (this.root == null){
            return null;
        }else {
            remove(this.root, key);
        }
        return removeNode;
    }

    private void remove(BinaryNode<T> p ,T key){
        if (this.hasRemove || p == null) return;
        if (p.getLeft() != null && p.getLeft().getDate().compareTo(key) == 0) {
            this.removeNode = p.getLeft();
            p.setLeft(null);
            this.hasRemove = true;
        }
        if (this.hasRemove) return;
        if (p.getRight() != null && p.getRight().getDate().compareTo(key) == 0){
            this.removeNode = p.getRight();
            p.setRight(null);
            this.hasRemove = true;
        }
        remove(p.getLeft() , key);
        remove(p.getRight() , key);
    }

    //TODO ② boolean isSorted();
    // 判断该二叉树是否为二叉排序树，注：二叉排序树，或者是一棵空树；或者是具有下列性质的二叉树：
    // (1)若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    // (2)若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    // (3)它的左、右子树也分别为二叉排序树。
    private boolean backIsSorted = true;
    public boolean isSorted(){
        if (this.root == null) return true;
        else isSorted(this.root);
       return backIsSorted;
    }

    private void isSorted(BinaryNode<T> p){
        if (p == null) return;
        if (p.getLeft() != null && p.getLeft().getDate().compareTo(p.getDate()) > 0) this.backIsSorted = false;
        if (p.getRight() != null && p.getRight().getDate().compareTo(p.getDate()) < 0) this.backIsSorted = false;
        isSorted(p.getLeft());
        isSorted(p.getRight());
    }

    //TODO ③ BinaryNode<T> parent(BinaryNode<T> p);
    // 返回p结点的父母结点
    private BinaryNode<T> backParent = null;
    public BinaryNode<T> parent(BinaryNode<T> p){
        if (this.root == null) return null;
        if (p.getDate().compareTo(this.root.getDate()) == 0) return null;
        parent(this.root , p.getDate());
        return backParent;
    }

    private void parent(BinaryNode<T> p , T key){
        if (p == null) return;
        if (p.getLeft() != null && p.getLeft().getDate().compareTo(key) == 0) this.backParent = p;
        if (p.getRight() != null && p.getRight().getDate().compareTo(key) == 0) this.backParent = p;
        parent(p.getLeft() , key);
        parent(p.getRight() , key);
    }

    //TODO 要求一次遍历效率  ①	void property3(BinaryTree<T> bitree); 验证二叉树的性质3
    private int[] nodeNum = {0,0,0};
    public void property3(BinaryTree<T> bitree){
        property(bitree.root);
        for (int j = 0; j < 3; j++) {
            System.out.println("度为"+j+"的结点一共有"+this.nodeNum[j]+"个");
        }
    }

    public void property(BinaryNode<T> node){
        int cnode = 0;
        if (node == null) return;
        if (node.getLeft() != null) cnode++;
        if (node.getRight() != null) cnode++;
        this.nodeNum[cnode]++;
        property(node.getLeft());
        property(node.getRight());
    }

    //TODO ② void swap(BinaryTree<T> bitree);   //交换结点的左右子树，讨论3种遍历算法的可行性
    public void swap1(BinaryTree<T> bitree){
        System.out.println("对二叉树进行前序交换左右子树");
        System.out.print("交换前前序遍历结果:");
        bitree.preOrder();
        System.out.print("交换前中序遍历结果:");
        bitree.inOrder();
        swap1(bitree.root);
        System.out.print("交换后前序遍历结果:");
        bitree.preOrder();
        System.out.print("交换后中序遍历结果:");
        bitree.inOrder();
    }

    public void swap1(BinaryNode<T> node){
        if (node == null) return;
        BinaryNode<T> ln = node.getLeft();
        BinaryNode<T> rn = node.getRight();
        node.setRight(ln);
        node.setLeft(rn);
        swap1(node.getLeft());
        swap1(node.getRight());
    }

    public void swap2(BinaryTree<T> bitree){
        System.out.println("对二叉树进行中序交换左右子树");
        System.out.print("交换前前序遍历结果:");
        bitree.preOrder();
        System.out.print("交换前中序遍历结果:");
        bitree.inOrder();
        swap2(bitree.root);
        System.out.print("交换后前序遍历结果:");
        bitree.preOrder();
        System.out.print("交换后中序遍历结果:");
        bitree.inOrder();
    }

    public void swap2(BinaryNode<T> node){
        if (node == null) return;
        swap2(node.getLeft());
        BinaryNode<T> ln = node.getLeft();
        BinaryNode<T> rn = node.getRight();
        node.setRight(ln);
        node.setLeft(rn);
        swap2(node.getRight());
    }

    public void swap3(BinaryTree<T> bitree){
        System.out.println("对二叉树进行后序交换左右子树");
        System.out.print("交换前前序遍历结果:");
        bitree.preOrder();
        System.out.print("交换前中序遍历结果:");
        bitree.inOrder();
        swap3(bitree.root);
        System.out.print("交换后前序遍历结果:");
        bitree.preOrder();
        System.out.print("交换后中序遍历结果:");
        bitree.inOrder();
    }

    public void swap3(BinaryNode<T> node){
        if (node == null) return;
        swap3(node.getLeft());
        swap3(node.getRight());
        BinaryNode<T> ln = node.getLeft();
        BinaryNode<T> rn = node.getRight();
        node.setRight(ln);
        node.setLeft(rn);
    }
}


