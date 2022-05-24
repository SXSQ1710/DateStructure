package cn.com.huyi.problem;


import cn.com.huyi.linearlist.LinearList;
import cn.com.huyi.linearlist.SeqList;

public class Josephus {
	private LinearList<Integer> josephusRing;
	private int n;
	private int start;
	private int distance;
	public Josephus(int n,int start,int distance) {
		this.n = n;
		this.start = start;
		this.distance = distance;
		this.josephusRing = new SeqList<Integer>(n);
		for(int i=1;i<=n;i++) {
			josephusRing.insert(i);
		}
	}
	public void resolve() {
		//TODO
		
	}
	public static void main(String[] args) {
		new Josephus(5,1,3).resolve();
	}
}
