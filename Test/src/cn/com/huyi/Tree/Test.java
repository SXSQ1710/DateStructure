package cn.com.huyi.Tree;

/**
 * @title: Test
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/24 11:24
 **/

public class Test {
    @org.junit.Test
    public void testBinaryTree(){
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> integerTreeNode2 = new TreeNode<>(2);
        TreeNode<Integer> integerTreeNode3 = new TreeNode<>(3);
        TreeNode<Integer> integerTreeNode4 = new TreeNode<>(4);
        TreeNode<Integer> integerTreeNode5 = new TreeNode<>(5);
        TreeNode<Integer> integerTreeNode6 = new TreeNode<>(6);
        TreeNode<Integer> integerTreeNode7 = new TreeNode<>(7);
        integerBinaryTree.setRoot(root);
        root.setLeft(integerTreeNode2);
        root.setRight(integerTreeNode3);
        integerTreeNode2.setLeft(integerTreeNode4);
        integerTreeNode2.setRight(integerTreeNode5);
        integerTreeNode3.setLeft(integerTreeNode6);
        integerTreeNode3.setRight(integerTreeNode7);
        System.out.println("前序遍历：");
        integerBinaryTree.preOrder();
        System.out.println("中序遍历：");
        integerBinaryTree.infixOrder();
        System.out.println("后序遍历：");
        integerBinaryTree.postOrder();
        System.out.println("前序查找：");
        System.out.println(integerBinaryTree.preOrderRsearch(1));
    }

}
