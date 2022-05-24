package cn.com.huyi.Recursion;

/**
 * @title: EightQueenProblem
 * @Author SXSQ
 * @Description //TODO 在8*8的棋盘上放8个皇后，使她们不会发生冲突
 * @Date 2022/4/21 21:18
 **/

public class EightQueenProblem {
    //8个皇后
    int queenNum = 8;
    //保存皇后的摆放位置,如 {0，4，7，5，2，6，1，3}
    int[] positions = new int[queenNum];
    static int count = 0;
    static int realcount = 0;

    public static void main(String[] args) {
        EightQueenProblem eightQueenProblem = new EightQueenProblem();
        eightQueenProblem.check(0);
        System.out.printf("一共有%d次解法",count);
        System.out.println();
        System.out.printf("一共有%d",realcount);
    }

    //打印皇后的拜访位置
    public void print(){
        count++;
        for (int i = 0; i < positions.length; i++) {
            System.out.print(positions[i]+" ");
        }
        System.out.println();
    }

    //放置第n+1个皇后
    public void check(int n){
        if (n == queenNum){
            print();
            return ;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < queenNum; i++) {
            //先把当前这个皇后放在该行第一列
            positions[n] = i;
            if (judge(n)){//不冲突
                //接着放n+1个皇后，即递归开始
                realcount++;
                check(n+1);
            }
            //如果发生冲突，则继续执行positions[n] = i;
        }
    }

    //判断该皇后和前面摆放的皇后之间是否可以攻击，n表示第n个皇后
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //判断第n个皇后是否和前面的皇后在同一列或者在同一斜线
            if (positions[i] == positions[n] || Math.abs(n - i) == Math.abs(positions[n] - positions[i])){
                return false;
            }
        }
        return true;
    }

    //放置第n个皇后
//    private void check(int n){
//        if (queenNum == n)
//    }
}
