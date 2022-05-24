package cn.com.huyi.linearlist;

import org.junit.Test;

public class SinglyList<E extends Comparable<E>> implements LinearList<E> {
	public Node<E> head;		
	public int size;					

	public SinglyList() {
		head = new Node<E>();
		size = 0;
	}

	public SinglyList(E[] values) {
		this();
		Node<E> last = head;
		for(int i=0;i<values.length;i++) {
			last.next = new Node<E>(values[i],null);
			last = last.next;
		}
		size = values.length;
	}
	
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	@Override
	public int size() {
		return size;
	}

	//返回第i位置的结点(i=0,1,2,3....)
	private Node<E> location(int i ){
		if (i >= 0 && i < this.size){
			Node<E> p = head.next;
			for (int j = 0 ; j < i ; j++){
				p = p.next;
			}
			return p;
		}else {
			throw new IndexOutOfBoundsException("超出范围！");
		}
	}

	@Override
	public E get(int i) {
		//TODO
		if (isEmpty()){
			System.out.println("此链表没有数据！");
			return null;
		}else {
			return location(i).data;
		}
	}

	@Override
	public void set(int i, E x) {
		//TODO
		location(i).data = x;
	}

	@Override
	public boolean insert(int i, E x) {
		// TODO
		if (size == 0){
			//空表插入
			head.next = new Node<E>(x,null);
			size++;
			return true;
		}else if (size > 0 && i < size-1){
			//表间插入
			Node<E> p = location(i-1);
			p.next = new Node<E>(x,p.next);
			size++;
			return true;
		}else if (i == size){
			//表尾插入
			location(i-1).next = new Node<E>(x,null);
			size++;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int insert(E x) {
		insert(size,x);
		return size;
	}

	public  boolean insert(int i , Node<E> node){
		if (size == 0){
			//空表插入
			head.next = node;
			size++;
			return true;
		}else if (size > 0 && i < size-1){
			//表间插入
			Node<E> p = location(i-1);
			node.next = p.next;
			p.next = node ;
			size++;
			return true;
		}else if (i == size){
			//表尾插入
			location(i-1).next = node;
			size++;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public E remove(int i) {
		// TODO
		Node<E> p = location(i - 1);
		Node<E> removep = p.next;
		if (i < size-1 && i >=0) {
			p.next = p.next.next;
			size--;
			return removep.data;
		}else if (i == size-1){
			p.next = null;
			size--;
			return removep.data;
		}else {
			return null;
		}
	}

	@Override
	public void clear() {
		head.next = null;
	}

	@Override
	public int search(E key) {
		// TODO
		Node<E> p = head.next;
		for (int j = 0 ; j < this.size ; j++){
			if (p.data.equals(key)){
				return j;
			}
			p = p.next;
		}
		return -1;
	}

	@Override
	public boolean contains(E key) {
		int i = search(key);
		return i!=-1;
	}

	@Override
	public int remove(E key) {
		int i = search(key);
		remove(i);
		return i;
	}

	public void reverse(){
		Node<E> p = head.next;
		Node<E> q = null;
		head.next = null;
		while (p!=null){
			q = p;
			p = p.next;
			q.next = head.next;
			head.next = q;
		}
	}

	public void partition(){
		Node<E> base = head.next;
		Node<E> pointer = base.next;
		Node<E> hit = base;
		Node<E> tail = base;
		for (int i =0 ; i < this.size-1;i++){
			if (base.data.compareTo(pointer.data)>0){
				tail.next=pointer.next;
				pointer.next = hit;
				hit = pointer;
				head.next = hit;
			} else if (base.data.compareTo(pointer.data)==0){
				tail.next=pointer.next;
				pointer.next = base.next;
				base.next = pointer;
				if (tail == base) tail=tail.next;
			} else{
				tail = tail.next;
			}
			pointer = tail.next;
		}
	}

	//反转链表
	public void reversal(){
		if (head.next == null || head.next.next == null) return;
		Node<E> pointer = head.next;
		Node<E> next ;
		Node<E> backLink = new Node<>();
		for (int i = 0; i < size; i++) {
			next = pointer.next;
			pointer.next = backLink.next;
			backLink.next = pointer;
			pointer = next;
		}
		head.next = backLink.next;
	}

	//TODO 返回最后一个结点
	public Node<E> last1(){
		Node<E> p = head.next;
		while (p.next != null){
			p = p.next;
		}
		System.out.println(p.data);
		return p;
	}

	public Node<E> last2(Node<E> p){
		if (p.next==null) return p;
		else return last2(p.next);
	}


	//TODO 返回p结点的前驱结点
	public Node<E> prev(Node<E> p){
		if (size()==0){
			throw new IndexOutOfBoundsException();
		}
		Node<E> q = head;
		for (int i = 0; i < size(); i++) {
			if (q.next.data==p.data) return q;
			q = q.next;
		}
		return null;
	}

	//TODO 返回从第i个结点开始，长度为len的子表，深拷贝
 	public SinglyList<E> subList(int i,int len){
		if (size-i+1-len < 0) throw new IndexOutOfBoundsException("超出原链表长度!");
		SinglyList<E> eSinglyList = new SinglyList<>();
		Node<E> q = null;
		eSinglyList.head.next = location(i-1);
		q = eSinglyList.head.next;
		for (int j = 0; j < len-1; j++) {
			q = q.next;
		}
		q.next = null;
		return eSinglyList;
	}

	public static SinglyList<Pooi> addALL(SinglyList<Pooi> A , SinglyList<Pooi> B ){
		Node<Pooi> front = A.head;
		Node<Pooi> q = B.head.next;
		Node<Pooi> p = front.next;
		while (p.next!=null && q.next!=null){
			if (p.data.getExp()==q.data.getExp()){
				if (p.data.getCoef()+q.data.getCoef()==0){
					p = p.next;
					front.next = p;
					q = q.next;
				} else {
					p.data.setCoef(p.data.getCoef()+q.data.getCoef());
					p = p.next;
					front = front.next;
					q = q.next;
				}
			}
			else if(p.data.getExp() < q.data.getExp()){
				front = front.next;
				p = p.next;
			} else {
				Node<Pooi> a = q;
				q = q.next;
				front.next = a;
				a.next = p;
				front = front.next;
			}
		}
		while (p.data.getExp() > q.data.getExp()){
			Node<Pooi> a = q;
			q = q.next;
			front.next = a;
			a.next = p;
			front = front.next;
		}
	if (p.next == null && q.next != null) p.next = q;
		return A;
	}

	public String toString() {
		String str = "["; 
		Node<E> p =head.next;
		while (p!=null) {
			str += "," +p.data.toString();
			p = p.next;
		}
		return str + "] ";
	}
}
