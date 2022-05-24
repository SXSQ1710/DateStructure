package cn.com.huyi.stack;

/**
 * @title: hannot
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/23 15:09
 **/

public class hannot {
    public void exchange(int n, char a, char b, char c){
        if(n == 1){
            System.out.println("The " + n + " from " + a + " to " + c);
        }else{
            exchange(n-1, a, c, b);
            System.out.println("The " + n + " from " + a + " to " + c);
            exchange(n-1, b, a, c);
        }
    }
    public static void main(String[] args) {
        int f = 3;
        hannot t = new hannot();
        t.exchange(f, 'a', 'b', 'c');
    }

}
