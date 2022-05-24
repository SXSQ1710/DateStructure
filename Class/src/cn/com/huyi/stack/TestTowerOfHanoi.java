package cn.com.huyi.stack;

import org.junit.Test;

/**
 * @title: TestTowerOfHanoi
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/22 15:17
 **/

public class TestTowerOfHanoi {
    @Test
    public void test(){
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(8);
        System.out.println(towerOfHanoi.toString());
        int moves = towerOfHanoi.moves();
        System.out.println(towerOfHanoi.toString());
        System.out.printf("一共移动了%d步",moves);
    }

}
