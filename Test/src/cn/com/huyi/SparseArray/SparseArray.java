package cn.com.huyi.SparseArray;

import org.junit.Test;

/**
 * @title: SparseArray
 * @Author SXSQ
 * @Description //TODO 稀疏数组的实现
 * @Date 2022/4/21 16:27
 **/

public class SparseArray {
    @Test
    public void commonArray(){
        int chessArray[][] = new int [11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        for (int[] row : chessArray){
            for (int date : row){
                System.out.printf("%d\t",date);
            }
            System.out.println();
        }
    }

    @Test
    public void turnToSparseArray(){
        int chessArray[][] = new int [11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        //1.遍历数组,
        //1.遍历数组,得到非0的个数
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) sum++;
            }
        }
        //2.创建对应的稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        //给稀疏数组赋值(第一行：多少行；多少列；多少非零值)
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[1].length;
        sparseArray[0][2] = sum;
        //遍历数组，将非零的值存到sparseArray中
        int conut = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    conut++;
                    sparseArray[conut][0] = i;
                    sparseArray[conut][1] = j;
                    sparseArray[conut][2] = chessArray[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("获得稀疏数组为");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        System.out.println("恢复为普通数组");

        //将稀疏数组恢复到普通数组
        int[][] newChessArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length ; i++) {
            newChessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //打印恢复的普通数组
        for (int[] array : newChessArray){
            for (int date : array){
                System.out.printf("%d\t",date);
            }
            System.out.println();
        }
    }
}
