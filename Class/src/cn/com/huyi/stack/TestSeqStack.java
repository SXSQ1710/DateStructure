package cn.com.huyi.stack;

import org.junit.Test;

/**
 * @title: TestSeqStack
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/15 8:53
 **/

public class TestSeqStack {
    @Test
    public void Test(){
        SeqStack<Integer> integerSeqStack = new SeqStack<>(6);
        for (int i = 0; i < 6; i++) {
            int random = (int) (Math.random()*10+10);
            integerSeqStack.push(random);
            System.out.println(random);
        }
    }
}
