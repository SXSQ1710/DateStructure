package cn.com.huyi.stack;

import org.junit.Test;

import java.util.Scanner;

/**
 * @title: Convert
 * @Author SXSQ
 * @Description //TODO 基于栈的进制转换
 * @Date 2022/4/16 9:53
 **/

public class Convert{
    public static void main(String[] args) {
        System.out.println("请输入十进制数：");
        Scanner scanner = new Scanner(System.in);
        int ten = scanner.nextInt();
        Convert.convert(ten,2);
        Convert.convert(ten,8);
        Convert.convert(ten,16);
    }

    public static void convert(int ten,int system){
        if (system==2 || system==8 || system==16) {
            SeqStack seqStack = new SeqStack(2);
            while (!(ten / system == 0)) {
                int i = ten % system;
                switch (i) {
                    case 10:
                        seqStack.push('A');
                        break;
                    case 11:
                        seqStack.push('B');
                        break;
                    case 12:
                        seqStack.push('C');
                        break;
                    case 13:
                        seqStack.push('D');
                        break;
                    case 14:
                        seqStack.push('E');
                        break;
                    case 15:
                        seqStack.push('F');
                        break;
                    default:
                        seqStack.push(i);
                }
                ten /= system;
            }
            seqStack.push(ten % system);
            System.out.print("转换为" + system + "进制为：");
            while (!(seqStack.isEmpty())) {
                Object pop = seqStack.pop();
                System.out.print(pop);
            }
            System.out.println("");
        }else {
            throw new RuntimeException("进制错误！");
        }
    }
}
