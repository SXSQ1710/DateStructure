package cn.com.huyi.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: TowerOfHanoi
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/22 15:08
 **/

public class TowerOfHanoi {
    //圆盘数量
    private int disksNum;
    //用栈来作为塔储存圆盘
    private SeqStack<Integer> A;
    private SeqStack<Integer> B;
    private SeqStack<Integer> C;
    //保存各个圆盘的位置（所在的塔）
    Map<Integer,SeqStack<Integer>> disks;
    //保存塔所对应的索引
    Map<SeqStack<Integer>,Integer> towersIndex;
    //用一个数组所有的保存塔所
    private SeqStack[] towersList;
    //一共移动了多少次
    private int num = 0;

    public SeqStack<Integer> getA() {
        return A;
    }

    public SeqStack<Integer> getB() {
        return B;
    }

    public SeqStack<Integer> getC() {
        return C;
    }


    public TowerOfHanoi(int disksNum) {
        this.disksNum = disksNum;
        this.A = new SeqStack<>(disksNum);
        this.B = new SeqStack<>(disksNum);
        this.C = new SeqStack<>(disksNum);
        towersIndex = new HashMap<>(3);
        init();
        towersList = new SeqStack[]{A,B,C};
    }

    public void init(){
        disks = new HashMap<>();
        for (int i = disksNum; i > 0; i--) {
            disks.put(i,A);
            A.push(i);
        }
        towersIndex.put(A,0);
        towersIndex.put(B,1);
        towersIndex.put(C,2);
    }

    public int moves(){
        do {
            for (int i = 1; i < disksNum + 1; i++) {
                if (C.isFull()) return num;
                if (disksNum % 2 != 0) {
                    //如果圆盘是奇数圆盘
                    if (i % 2 != 0) {
                        if(moveleft(i)) num++;
//                        System.out.println(toString());
                    } else {
                        if(moveRight(i)) num++;
//                        System.out.println(toS tring());
                    }
                } else {
                    //如果圆盘是偶数圆盘
                    if (i % 2 != 0) {
                        if(moveRight(i)) num++;
//                        System.out.println(toString());
                    } else {
                        if(moveleft(i)) num++;
//                        System.out.println(toString());
                    }
                }
            }
        } while (true);
    }

    //第i个圆盘
    public boolean moveleft(int i){
        //获取此圆盘所在的塔 和 塔的编号
        SeqStack<Integer> disksTower = disks.get(i);
        Integer ti = towersIndex.get(disksTower);
        //圆盘向左移动一个塔
        if (judge(i,(ti + 3 - 1) % 3)) {
            i = disksTower.pop();
            towersList[(ti + 3 - 1) % 3].push(i);
            disks.put(i, towersList[(ti + 3 - 1) % 3]);
            return true;
        }
        return false;
    }

    //第i个圆盘
    public boolean moveRight(int i){
        //获取此圆盘所在的塔 和 塔的编号
        SeqStack<Integer> disksTower = disks.get(i);
        Integer ti = towersIndex.get(disksTower);
        //圆盘向右移动一个塔
        if (judge(i,(ti + 3 + 1) % 3)) {
            i = disksTower.pop();
            towersList[(ti + 3 + 1) % 3].push(i);
            disks.put(i, towersList[(ti + 3 + 1) % 3]);
            return true;
        }
        return false;
    }

    //判断第disk个圆盘能否移动到第tower个塔上
    public boolean judge(int disk,int tower){
        //圆盘是否在当前所在塔的顶端
        if (disks.get(disk).peek() != disk) return false;
        //圆盘是否比所要移动到塔的顶层的小
        if (towersList[tower].peek() != null){
            if ((Integer)towersList[tower].peek() < disk)return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TowerOfHanoi{" +
                "disksNum=" + disksNum +
                "\nA=" + A.toString() +
                "\nB=" + B.toString() +
                "\nC=" + C.toString() +
                "\ndisks=" + disks.toString() +
                '}';
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(7);
        System.out.println(towerOfHanoi.toString());
        int moves = towerOfHanoi.moves();
        System.out.println(towerOfHanoi.toString());
        System.out.printf("一共移动了%d步",moves);
    }
}
