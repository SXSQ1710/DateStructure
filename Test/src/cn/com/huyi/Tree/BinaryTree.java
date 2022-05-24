package cn.com.huyi.Tree;

/**
 * @title: BinaryTree
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/24 11:03
 **/

public class BinaryTree<E> {
    private TreeNode<E> root;

    //前序遍历
    public void preOrder(){
        if (this.root != null) this.root.preOrder();
        else System.out.println("二叉树为空！");
    }

    //中序遍历
    public void infixOrder(){
        if (this.root != null) this.root.infixOrder();
        else System.out.println("二叉树为空！");

    }

    //后序遍历
    public void postOrder(){
        if (this.root != null) this.root.postOrder();
        else System.out.println("二叉树为空！");
    }

    //前序遍历查找
    public TreeNode<E> preOrderRsearch(E date){
        if (this.root != null) return root.preOrderRsearch(date);
        else return null;
    }

    //中序遍历查找
    public TreeNode<E> infixOrderRsearch(E date){
        if (this.root != null) return root.infixOrderRsearch(date);
        else return null;
    }

    //后序遍历查找
    public TreeNode<E> postOrderRsearch(E date){
        if (this.root != null) return root.postOrderRsearch(date);
        else return null;
    }

    public BinaryTree() {
    }

    public BinaryTree(TreeNode<E> root) {
        this.root = root;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }
}
