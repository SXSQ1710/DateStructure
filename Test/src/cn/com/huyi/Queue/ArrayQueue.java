package cn.com.huyi.Queue;

import org.junit.Test;

import javax.print.DocFlavor;

/**
 * @title: ArrayQueue
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/21 16:56
 **/

public class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int front; //头指针
    private int rear; //尾指针
    private Object[] arr; //用于储存数据

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new Object[arrMaxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public  boolean isEmpty(){
        return this.front == this.rear;
    }

    public void addQueue(Object date){
        if (this.isFull()){
            System.out.println("队列已满！");
            return;
        }
        arr[rear] = date;
        rear = (rear + 1) % maxSize;
    }

    public Object getQueue(){
        if (this.isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        Object date = arr[front];
        front = (front + 1) % maxSize;
        return date;
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue(){
        if (this.isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d:%d\t",i % maxSize, arr[i % maxSize]);
        }
    }

    public Object headQueue(){
        if (this.isEmpty()) throw new RuntimeException("队列为空！");
        return arr[front];
    }
}
