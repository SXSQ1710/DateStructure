package cn.com.huyi.linearlist;

/**
 * @title: DoubleLinkedList
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/21 20:26
 **/

public class DoubleLinkedList<E extends Comparable<E>> implements LinearList<E>  {
    public Node<E> head;
    public int size;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int search(E key) {
        return 0;
    }

    @Override
    public int remove(E key) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public void set(int i, E x) {

    }

    @Override
    public boolean insert(int i, E x) {
        return false;
    }

    @Override
    public int insert(E x) {
        return 0;
    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public boolean contains(E x) {
        return false;
    }
}
