package cn.com.huyi.Queue;

import org.junit.Test;

/**
 * @title: TestArrayQueue
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/21 19:25
 **/

public class TestArrayQueue {
    @Test
    public void test(){
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(1);
        System.out.println(arrayQueue.size());
        arrayQueue.showQueue();
        System.out.println(arrayQueue.isFull());
    }
}
