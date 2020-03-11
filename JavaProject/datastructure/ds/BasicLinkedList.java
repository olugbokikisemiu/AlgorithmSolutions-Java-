package datastructure.ds;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public int getSize() {
        return nodeCount;
    }

    public void add(X nodeItem) {
        if (first == null) {
            first = new Node(nodeItem);
            last = first;
        } else {
            Node newLastNode = new Node(nodeItem);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    public X removeHead() {
        if (first != null) {
            X removedItem = first.getNodeItem();
            first = first.getNextNode();
            nodeCount--;
            return removedItem;
        }
        return null;
    }

    public X removedFromTail(){
        Node currentNode = first;
        Node previousNode = null;
        if(nodeCount != 0){
            for(int i = 1; i <= nodeCount; i++){
                if(i == nodeCount -1){
                    previousNode = currentNode;
                }
                currentNode = currentNode.nextNode;
            }
            last = previousNode;
            nodeCount--;
            return last.nodeItem;
        }
        return null;
    }

    public X insertNode(X item, int position) {
        Node currentNode = first;
        Node nextNode = null;
        if(nodeCount >= position){
            for(int i = 1; i < position && currentNode != null; i++){
                currentNode = currentNode.getNextNode();
            }
            System.out.println("CurrentNode "+ currentNode.getNodeItem());
            nextNode = currentNode.nextNode;
            Node newNode = new Node(item);
            currentNode.setNextNode(newNode);
            newNode.setNextNode(nextNode);
            nodeCount++;
            return newNode.getNextNode().getNodeItem();
        }
        return null ;
    }

    public int removeAT(int position) {
        Node currentNode = first;
        Node previousNode = first;
        if(currentNode != null && nodeCount >= position){
            for(int i = 1; i < position; i++){
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            previousNode.setNextNode(currentNode.getNextNode());
            nodeCount--;
            return 1;
        }
        return 0;
    }

    public void removeDuplicate() {
        Hashtable<X, Boolean> hash = new Hashtable<>();
        Node currentNode = first;
        Node previousNode = null;
        while(currentNode != null){
            if(hash.containsKey(currentNode.getNodeItem())){
                previousNode.setNextNode(currentNode.getNextNode());
                nodeCount--;
            }else{
                hash.put(currentNode.getNodeItem(), true);
                previousNode = currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    public X headNode() {
        return first.nodeItem;
    }

    public X tailNode() {
        return last.nodeItem;
    }

    public X getByPosition(int position){
        Node currentNode = first;
        if(currentNode != null){
            for(int i = 1; i < position; i++){
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getNodeItem();
        }
        return null;
    }

    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item) {
            nextNode = null;
            nodeItem = item;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public X getNodeItem() {
            return this.nodeItem;
        }

    }

    public static void main(String[] args) {
        BasicLinkedList<Integer> linked = new BasicLinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.add(1);
        linked.add(6);
        linked.add(9);

        System.out.println("Position " + linked.getByPosition(3));

        linked.removeDuplicate();

     System.out.println("After Position " + linked.getByPosition(3));

        // System.out.println("Removed: " + linked.removeHead());

        // System.out.println("After head removed: " + linked.headNode());

        // System.out.println("Last Node: " + linked.tailNode());

        // System.out.println(linked.removedFromTail());

        // System.out.println("Last After remove: " + linked.tailNode());
    }

}