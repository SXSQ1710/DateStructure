package cn.com.huyi.stack;

/**
 * @title: Stack
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/15 8:42
 **/

public interface Stack<T> {
    boolean isEmpty();

    void push(T t);

    T peek();

    T pop();
}
