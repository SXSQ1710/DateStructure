package cn.com.huyi.linearlist;

public class Node<E> {
	public E data;			//数据域
	public Node<E> next;  //指针域
	public Node() {
		data = null;
		next = null;
	}
	public Node(E x, Node<E> next) {
		this.data = x;
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}
