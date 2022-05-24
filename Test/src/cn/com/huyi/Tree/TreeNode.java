package cn.com.huyi.Tree;

/**
 * @title: Node
 * @Author SXSQ
 * @Description //TODO 树的结点
 * @Date 2022/4/24 11:04
 **/

public class TreeNode<E> {
    private E data;			//数据域
    private TreeNode<E> left;  //左节点
    private TreeNode<E> right //右结点
            ;  //指针域

    public TreeNode() {
    }

    public TreeNode(E data) {
        this.data = data;
    }

    public TreeNode(E data, TreeNode<E> left, TreeNode<E> reght) {
        this.data = data;
        this.left = left;
        this.right = reght;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode [data=" + data + "]";
    }

    //删除子节点
    public void delNode(int date){
        
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null) this.left.preOrder(); //递归向左子树前序遍历
        if (this.right != null) this.right.preOrder(); //递归向右子树前序遍历
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null) this.left.preOrder(); //递归向左子树前序遍历
        System.out.println(this);
        if (this.right != null) this.right.preOrder(); //递归向右子树前序遍历

    }

    //后序遍历
    public void postOrder(){
        if (this.left != null) this.left.preOrder(); //递归向左子树前序遍历
        if (this.right != null) this.right.preOrder(); //递归向右子树前序遍历
        System.out.println(this);
    }

    //前序遍历查找
    public TreeNode<E> preOrderRsearch(E date){
        if (this.data == date) return this;
        TreeNode<E> backNode = null;
        if (this.left != null) backNode = this.left.preOrderRsearch(date);
        if (backNode != null) return backNode; //如果左子树查找到返回结果
        if (this.right != null) backNode = this.right.preOrderRsearch(date);
        return backNode;
    }

    //中序遍历查找
    public TreeNode<E> infixOrderRsearch(E date){
        TreeNode<E> backNode = null;
        if (this.left != null) backNode = this.left.preOrderRsearch(date);
        if (backNode != null) return backNode; //如果左子树查找到返回结果
        if (this.data == date) return this; //如果左节点没有找到就和当前结点进行比较，若是就返回
        if (this.right != null) backNode = this.right.preOrderRsearch(date);
        return backNode;
    }

    //后序遍历查找
    public TreeNode<E> postOrderRsearch(E date){
        TreeNode<E> backNode = null;
        if (this.left != null) backNode = this.left.preOrderRsearch(date);
        if (backNode != null) return backNode; //如果左子树查找到返回结果
        if (this.right != null) backNode = this.right.preOrderRsearch(date);
        if (this.data == date) return this; //如果左右子树都没有找到，则比较当前结点，若是则返
        return backNode;//若还是没有，则返回backNode，为空
    }
}
