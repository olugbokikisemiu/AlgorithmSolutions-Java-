package datastructure.ds;

import java.util.TreeMap;

public class BasicBinaryTree<X extends Comparable<X>> {

    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root = null;
    }

    public int getSize() {
        return size;
    }

    public void add(X item) {
        Node node = new Node(item);
        if (this.root == null) {
            this.root = node;
            System.out.println("Root created: "+ root.getValue());
            this.size++;
        } else {
            insert(this.root, node);
        }
    }

    public boolean contains(X item) {
        Node n = getNode(item);
        if (n == null) {
            return false;
        }
        return true;
    }

    public boolean delete(X item) {
        boolean deleted = false;
        if (this.root == null) {
            return deleted;
        }
        Node currentNode = getNode(item);
        if (currentNode != null) {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlinkNode(currentNode, null);
                deleted = true;
            } else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                unlinkNode(currentNode, currentNode.getRight());
                deleted = true;
            } else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                unlinkNode(currentNode, currentNode.getLeft());
                deleted = true;
            }else{
                Node child = currentNode.getLeft();
                while(child.getRight() != null && child.getLeft() != null){
                    child = child.getRight();
                }

                child.getParent().setRight(null);

                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unlinkNode(currentNode, child);
                deleted = true;
            }
        }

        if(deleted){
            this.size--;
        }

        return deleted;

    }

    private void unlinkNode(Node currentNode, Node newNode) {
        if (currentNode == this.root) {
            newNode.setRight(currentNode.getRight());
            newNode.setLeft(currentNode.getLeft());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode) {
            currentNode.getRight().setParent(newNode);
        } else {
            currentNode.getLeft().setParent(newNode);
        }
    }
    
    private Node getNode(X item) {
        Node currentNode = this.root;
        while (currentNode != null) {
            int val = item.compareTo(currentNode.getValue());

            if (val == 0) {
                return currentNode;
            } else if (val < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    private void insert(Node parent, Node child) {
        if (parent.getValue().compareTo(child.getValue()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                System.out.println("LeftChild created: "+ child.getValue());
                this.size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (parent.getValue().compareTo(child.getValue()) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                System.out.println("RightChild created: "+ child.getValue());
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }
        }
    }

    private class Node {
        private Node parent;
        private Node left;
        private Node right;
        private X value;

        public Node(X item) {
            this.parent = null;
            this.left = null;
            this.right = null;
            this.value = item;
        }

        public Node getParent() {
            return this.parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public X getValue() {
            return this.value;
        }

        public void setValue(X value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        BasicBinaryTree<Integer> basic = new BasicBinaryTree<>();
        basic.add(4);
        basic.add(2);
        basic.add(5);
        basic.add(1);
        basic.add(3);
        basic.add(4);
        basic.add(6);
        basic.add(7);
        basic.add(9);
    }

}