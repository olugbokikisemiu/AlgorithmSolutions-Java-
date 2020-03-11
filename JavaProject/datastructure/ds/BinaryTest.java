package datastructure.ds;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class BinaryTest {
    private TreeNode root;

    // public BinaryTest() {
    // root = null;
    // }

    public BinaryTest(TreeNode n) {
        root = n;
    }

    public TreeMap<Integer, Integer> verticalSumMain() {
        if (root == null) {
            return null;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        verticalSum(root, 0, treeMap);
        return treeMap;
    }

    public void verticalSum(TreeNode root, int hd, TreeMap<Integer, Integer> treeMap) {
        if (root == null) {
            return;
        }

        verticalSum(root.getLeft(), hd - 1, treeMap);
        int value = 0;
        if (treeMap.get(hd) == null) {
            value = root.getValue();
        } else {
            value = treeMap.get(hd) + root.getValue();
        }

        treeMap.put(hd, value);

        verticalSum(root.getRight(), hd + 1, treeMap);
    }

    public int countTreeWidth() {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        int maxWidth = 0;
        while (!nodeQ.isEmpty()) {
            int count = nodeQ.size();
            maxWidth = Math.max(maxWidth, count); // compare the maxWidth and count
            while (count-- != 0) {
                TreeNode tempNode = nodeQ.remove(); // dequeue the root
                if (tempNode.getLeft() != null) {
                    nodeQ.add(tempNode.getLeft());
                }
                if (tempNode.getRight() != null) {
                    nodeQ.add(tempNode.getRight());
                }
            }
        }
        return maxWidth;
    }

    public String BFSearch(){
        String result = "";
        if(root == null){
            return "";
        }

        LinkedList<TreeNode> queueNode = new LinkedList<>();
        queueNode.add(root);
        while(!queueNode.isEmpty()){
            int count = queueNode.size();
            while( count -- > 0){
                TreeNode tempNode = queueNode.pop();
                result += tempNode.getValue(); 
                if(tempNode.getLeft() != null){
                    queueNode.add(tempNode.getLeft());
                }
                if(tempNode.getRight() != null){
                    queueNode.add(tempNode.getRight());
                }
            }
            result += "\n";
        }
        return result;
    }

    public void arrangeStudent(int item) {
        TreeNode node = new TreeNode(item);
        if (root == null) {
            this.root = node;
        } else {
            if (this.root.getValue() < item) {
                this.root.setLeft(node);
            } else {
                this.root.setRight(node);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.setLeft(new TreeNode(2));
        tree.setRight(new TreeNode(3));
        tree.getLeft().setLeft(new TreeNode(4));
        tree.getLeft().setRight(new TreeNode(5));
        tree.getRight().setLeft(new TreeNode(6));
        tree.getRight().setRight(new TreeNode(7));

        BinaryTest test = new BinaryTest(tree);
        // TreeMap<Integer, Integer> result = test.verticalSumMain();
        System.out.println(test.BFSearch());
    }
}