package cn.com.huyi.linearlist;



public class SeqList<E extends Comparable<E>> implements LinearList<E> { // 线性表的顺序存储实现（顺序表）
	protected Object[] element; // 地址连续的顺序存储空间，Object数组提供
	protected int n; // 顺序表元素个数（长度）
	private static final int MIN_CAPACITY = 16; // 定义顺序存储空间的最小容量

	public SeqList() {
		this(MIN_CAPACITY);
	}

	public SeqList(int length) {
		if (length < MIN_CAPACITY)
			length = MIN_CAPACITY;
		this.element = new Object[length];
		this.n = 0;
	}

	@Override
	public boolean isEmpty() {
		return this.n == 0;
	}

	@Override
	public int size() {
		return n;
	}

	
	@Override
	// 读取操作
	// 若0≤i<n，返回第i个元素；否则，返回null--- O(1)
	public E get(int i){ 
		if (i >= 0 && i < this.n)
			return (E) this.element[i];
		return null;
	}

	@Override
	// 若0≤i<n且x≠null，设置第i个元素为x；否则抛出序号越界异常或空对象异常---O(1)
	public void set(int i, E x) {
		if (i < 0 || i >= this.n){
			throw new IndexOutOfBoundsException(i+"");
		}
		if (x == null){
			throw new NullPointerException("x=null");
		}
		this.element[i] = x;
	}

	@Override
	// 顺序表的插入操作
	// 插入x为第i个元素，x!=null，返回插入成功true，失败false
	// x为null不能插入，插入失败
	// 对i容错，若i<0，则头插入；若i>长度，则尾插入
	// 对存储空间大小校验，若数组空间已满，则扩充顺序表的数组容量
	// 插入操作：将插入位置及之后的记录往后移动一个单元，待插入的数据放置到第i个元素的位置
	// 时间复杂度：？
	public boolean insert(int i, E x) {
		//判断x是否为空
		if (x == null) return false;
		//将超出集合的归为插入头部或尾部
		if (i < 0) i = 0;
		if (i > 0) i = this.n;
		//若超过原数组，扩容
		if (this.size() == this.element.length){
			Object[] source = this.element;
			this.element = new Object[this.element.length*2];
			for (int k = 0 ; k < source.length ; k++) {
				this.element[k] = source[k];
			}
		}

		for (int j = n-1 ; j >= i ; j--){
			this.element[j+1] = this.element[j];
		}
		this.element[i] = x;
		n++;
		return true;
	}


	@Override
	public int insert(E x) { // 顺序表尾插入x元素，O(1)。成员方法重载
		this.insert(this.n, x); // 调用insert(i, x)方法
		return  this.n;
	}
	

	@Override
	//顺序表的删除操作
    public E remove(int i) {           // 删除第i个元素，0≤i<n，返回被删除元素。若i越界，返回null。O(n)
        if(i>=0 && i<this.n)  {
            E x = (E)this.element[i];            // x中存储被删除元素
            for(int j=i; j<this.n-1; j++)
                this.element[j] = this.element[j+1];       // 元素前移一个位置
            this.element[this.n--]=null;         // 设置数组元素对象为空，释放原引用实例
            return x;                            // 返回x局部变量引用的对象，传递对象引用
        }
        return null;
    }

	@Override
	public void clear() //  删除所有元素
	{
		 // clear to let GC do its work
        for (int i = 0; i < n; i++)
            element[i] = null;

        n = 0;
	}

	@Override
	// 顺序查找
    // 在this引用的顺序表中，顺序查找首个与key相等元素，返回元素序号i，0≤i<n；若查找不成功，则返回-1。
    // 顺序查找算法:O(n)
    public int search(E key) {
		for (int i = 0 ; i < this.size() ; i++){
			if (element[i].equals(key)) return i;
		}
        return -1;                          // 空表或未找到时
    }

	@Override
	public boolean contains(E x) // 线性表中是否包含x元素
	{
		return this.search(x) != -1;
	}

	@Override
	public int remove(E key) // 删除值为key的记录
	{
		remove(search(key));
		return -1;	//没有值为key的记录
	}

	//TODO partiton算法
	public void partition(){
		int i = 0;
		int j = n-1;
		E base = this.get(i);
		while (i<j){
			while (base.compareTo(this.get(j))<0) j--;
			if (j>i){
				this.set(i,this.get(j));
				i++;
			}
			while (base.compareTo(this.get(i))>0) i++;
			if (j>i){
				this.set(j,this.get(i));
				j--;
			}
		}
		set(i,base);
	}

	//TODO 删除所以关键字为key的数据元素，要求所以元素一次移动到位
	public void removeALL(E key){
		int num = 0;
		for (int i = 0 ; i < this.n ; i++){
			if (element[i].equals(key)) {
				element[i] = null;
				num++;
			}
		}
		Object[] a = new Object[this.n - num];
		num = 0;
		for (int i = 0 ; i < this.n ; i++){
			if (element[i]!=null) a[i-num] = this.element[i];
			else  num++;
		}
		this.n = a.length;
		this.element=a;
	}

	//TODO 将第一个关键字为key的元素替换为x
	public void replaceFirst(E key,E x){
		if (search(key) != -1) {
			int index = search(key);
			set(index, x);
		}else {
			throw new IndexOutOfBoundsException("原表中没有元素");
		}
	}

	//TODO	查找最后一个关键字为key的元素，返回其索引号
	public int searchLast(E key){
		int index = 0 ;
		int[] indexs = new int[this.n];
		for (int i =0 ; i < this.n ; i++){
			if (element[i].equals(key)) {
				index++;
				indexs[index] = i;
			}
		}
		return indexs[index];
	}

	// 返回所有元素的描述字符串，形式为“[,]”。覆盖Object类的toString()方法
	// O(n)
	public String toString() {
		String str="[";
		if (this.n > 0)
			str += this.element[0].toString();
		for (int i = 1; i < this.n; i++) {
			str += ", " + this.element[i].toString();
			if (i % 15 == 0)
				str += "\n";
		}
		return str + "] ";
	}

	
}
