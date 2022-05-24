package cn.com.huyi.stack;

import org.junit.Test;

/**
 * @title: Fibonacci
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/3/29 9:37
 **/

public class Fibonacci {
    public static long fib(int n){
        if (n==0) return 0;
        else if(n==1) return 1;
        else {
            return fib(n-1)+fib(n-2);
        }
    }

    @Test
    public void testfib(){
        System.out.println(fib(10));
        System.out.println(fib(11));
        System.out.println(fib(12));
    }
}
