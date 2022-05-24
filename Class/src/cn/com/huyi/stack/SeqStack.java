package cn.com.huyi.stack;

import java.util.Arrays;

/**
 * @title: LinkedStack
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/15 8:41
 **/

public class SeqStack<T> implements Stack<T>{
    private Object[] elements;
    private int top;
    public SeqStack() {
        this(20);
    }

    public SeqStack(int lenght) {
        this.elements =new Object[lenght];
        this.top=0;
    }

    public boolean isFull() {
        return this.top == elements.length;
    }

    @Override
    public boolean isEmpty() {
        return this.top==0;
    }

    @Override
    public void push(T t) {
        if (this.top == this.elements.length){
            Object[] objects = new Object[top * 2];
            for (int i = 0; i < this.elements.length; i++) {
                objects[i] = this.elements[i];
            }
            this.elements = objects;
        }
        this.elements[top++] = t;
    }

    @Override
    public T peek() {
        if (top == 0) return null;
        return (T) this.elements[top-1];
    }

    @Override
    public T pop() {
        if (top == 0) return null;
        return (T) this.elements[--top];
    }

    @Override
    public String toString() {
        return "SeqStack{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + top +
                '}';
    }
}
