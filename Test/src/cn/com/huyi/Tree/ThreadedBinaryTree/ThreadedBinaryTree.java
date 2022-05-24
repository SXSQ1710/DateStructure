package cn.com.huyi.Tree.ThreadedBinaryTree;

/**
 * @title: ThreadedBinaryTree
 * @Author SXSQ
 * @Description //TODO 实现线索化功能的二叉树
 * @Date 2022/4/25 20:54
 **/

public class ThreadedBinaryTree<E> {
    private TreeNode<E> root;

    //前驱结点的指针
    private TreeNode pre = null;

    public ThreadedBinaryTree() {
    }

    public ThreadedBinaryTree(TreeNode<E> root) {
        this.root = root;
    }

    public void threadedNodes(){
        pre = root;
        this.threadedNodes(root);
    }


    //对二叉树进行中序 线索化的方法
    /**
     *
     * @param node 当前需要线索化的结点
     */
    public void threadedNodes(TreeNode node){
        if (node == null) return;
        threadedNodes(node.getLeft()); //递归线索化左子树
        if (node.getLeft() == null){
            //当前结点的左指针指向前驱结点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!!每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node ;
        threadedNodes(node.getRight()); //递归线索化右子树
    }

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

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }
}
