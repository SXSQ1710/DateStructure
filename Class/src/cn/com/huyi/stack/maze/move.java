package cn.com.huyi.stack.maze;

/**
 * @title: move
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/20 21:28
 **/

public class move {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "move{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
