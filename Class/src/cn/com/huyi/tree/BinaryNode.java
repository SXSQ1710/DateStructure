package cn.com.huyi.tree;

/**
 * @title: BinaryNode
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/5/12 10:17
 **/

public class BinaryNode <T extends Comparable<? super T>>{
    private T date;
    private BinaryNode<T> left,right;

    public BinaryNode(T date, BinaryNode<T> lefr, BinaryNode<T> right) {
        this.date = date;
        this.left = lefr;
        this.right = right;
    }

    public BinaryNode(T date) {
        this(date,null,null);
    }

    public BinaryNode() {
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public boolean isLesf(){
        return this.left == null && this.right == null;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "date=" + date +
                '}';
    }
}
