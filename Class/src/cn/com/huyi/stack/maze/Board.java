package cn.com.huyi.stack.maze;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @title: board
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/16 15:31
 **/

public class Board {
    //用户输入的棋盘规格
    private int width;
    //加上边界的宽度
    private int realwidth;
    //保存棋盘布局
    private int [][] elements;
    //保存4种移动操作
    private move[] moves;
    //记录移动的步骤，用于递归
    private LinkedList<move> positions = new LinkedList<>();

    public Board(int width) {
        this.width =width;
        this.realwidth =width+2;
        this.elements = new int [realwidth][realwidth];
        initSetElements();
        initMoves();
    }

    //加上”围墙“
    public void initSetElements() {
        for (int i = 0; i < realwidth; i++) {
            this.elements[0][i] = this.elements[realwidth -1][i] = -1;
            this.elements[i][0] = this.elements[i][realwidth-1] = -1;
        }
    }

    public void initMoves(){
        this.moves = new move[]{
                new move(0,-1),//左移
                new move(-1,0),//上移
                new move(0,1),//右移
                new move(1,0),//下移
        };
    }

    //对棋盘单一格子进行设置
    public void setElement(int x, int y, int con) {
        this.elements[x+1][y+1] = con;
    }

    //寻路+回溯
    public void findPath(int startx, int starty, int endx, int endy){
        int allPath = this.getpPath(startx, starty, endx, endy);
        this.backPath(endx,endy,allPath);
    }

    //寻路
    public int getpPath(int startx, int starty, int endx, int endy){
        this.setElement(startx,starty,-2);
        this.setElement(endx,endy,-3);
        System.out.println(toString());
        int x = startx+1;
        int y = starty+1;
        int movex = x;
        int movey = y;
        int num = 1;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("检查："+x+","+y);
            for (int i = 0; i < 4; i++) {
                movex = x+this.moves[i].getX();
                movey = y+this.moves[i].getY();
                if (this.elements[movex][movey] == 0) {
                    this.elements[movex][movey] = num;
                    this.positions.add(new move(movex,movey));
                } else if (this.elements[movex][movey] == -3){
                    System.out.println(toString());
                    return this.elements[x][y]+1;
                }
            }
            System.out.println();
            System.out.println("检查完成：");
            this.toString();
            System.out.println();

            System.out.println(this.positions);
            move m = positions.poll();
            System.out.println("推出" + m);
            x = m.getX();
            y = m.getY();
            num = this.elements[x][y]+1;
            System.out.println("---------------------------------------------");
        }while (true);
    }

    //回溯
    public void backPath(int endx,int endy,int path){
        Stack<move> paths = new Stack<>();
        paths.push(new move(endx,endy));
        int movex = endx;
        int movey = endy;
        this.positions.clear();
        do {
            path--;
            for (int i = 3; i >= 0; i--) {
                movex = endx + this.moves[i].getX();
                movey = endy + this.moves[i].getY();
                if (this.elements[movex][movey] == path && this.elements[movex][movey] > 0) {
                    paths.push(new move(movex,movey));
//                    System.out.println(movex+","+movey);
                    this.positions.add(new move(movex,movey));
                    break;
                } else if (this.elements[movex][movey] == -2) {
                    while (!(paths.isEmpty())){
                        System.out.println(paths.pop().toString());
                    }
                    return;
                }
            }
            move m = positions.poll();
            endx = m.getX();
            endy = m.getY();
        }while (true);
    }

    @Override
    public String toString() {
        for (int[] enement : this.elements){
            for (int i : enement){
                if (i < 0 || i > 9)    System.out.print(" "+i);
                else System.out.print("  "+i);
            }
            System.out.println();
        }
        return "";
    }

    public static void main(String[] args) {
        Board board = new Board(7);
        board.setElement(0,2,-1);
        board.setElement(1,2,-1);
        board.setElement(1,3,-1);
        board.setElement(2,4,-1);
        board.setElement(3,4,-1);
        board.setElement(3,3,-1);
        board.setElement(4,4,-1);
        board.setElement(4,0,-1);
        board.setElement(5,0,-1);
        board.setElement(6,0,-1);
        board.setElement(5,1,-1);
        board.setElement(6,1,-1);
        board.setElement(5,2,-1);
        board.setElement(6,2,-1);
//        board.findPath(0, 0, 6, 6);
    }
}
