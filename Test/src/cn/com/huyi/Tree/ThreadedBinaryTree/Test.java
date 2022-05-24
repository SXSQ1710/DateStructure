package cn.com.huyi.Tree.ThreadedBinaryTree;

/**
 * @title: Test
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/25 22:09
 **/

public class Test {
    public static void main(String[] args) {
        ThreadedBinaryTree<Integer> integerThreadedBinaryTree = new ThreadedBinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> integerTreeNode2 = new TreeNode<>(2);
        TreeNode<Integer> integerTreeNode6 = new TreeNode<>(6);
        TreeNode<Integer> integerTreeNode1 = new TreeNode<>(1);
        TreeNode<Integer> integerTreeNode3 = new TreeNode<>(3);
        TreeNode<Integer> integerTreeNode5 = new TreeNode<>(5);
        TreeNode<Integer> integerTreeNode7 = new TreeNode<>(7);
        root.setLeft(integerTreeNode2);
        root.setRight(integerTreeNode6);
        integerTreeNode2.setLeft(integerTreeNode1);
        integerTreeNode2.setRight(integerTreeNode3);
        integerTreeNode6.setLeft(integerTreeNode5);
        integerTreeNode6.setRight(integerTreeNode7);
        integerThreadedBinaryTree.setRoot(root);
        integerThreadedBinaryTree.threadedNodes();
        integerThreadedBinaryTree.infixOrder();
//        System.out.println(integerTreeNode1.getLeft());
//        System.out.println(integerTreeNode1.getRight());
//        System.out.println(integerTreeNode3.getLeft());
//        System.out.println(integerTreeNode3.getRight());
//        System.out.println(integerTreeNode5.getLeft());
//        System.out.println(integerTreeNode5.getRight());
//        System.out.println(integerTreeNode7.getLeft());
//        System.out.println(integerTreeNode7.getRight());
    }
}
