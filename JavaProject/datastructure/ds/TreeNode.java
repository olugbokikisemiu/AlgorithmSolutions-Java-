package datastructure.ds;

import java.util.HashMap;
import java.util.TreeMap;

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}