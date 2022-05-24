package cn.com.huyi.linearlist;

/**
 * @title: Pooi
 * @Author SXSQ
 * @Description //TODO 多项式中的一项
 * @Date 2022/3/30 19:20
 **/

public class Pooi implements Comparable<Pooi>{
    //coef：系数  exp：指数
    private int coef , exp;
    public Pooi() {
    }

    public Pooi(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public int compareTo(Pooi o) {
        if (o.getExp() != this.getExp()) try {
            throw new Exception("指数不相同！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (o.getCoef() == this.getCoef()) return 0;
        else if (o.getCoef() > this.getCoef()) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "{coef=" + coef +
                ", exp=" + exp +
                '}';
    }
}
