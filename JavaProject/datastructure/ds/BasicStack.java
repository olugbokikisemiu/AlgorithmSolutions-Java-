package datastructure.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BasicStack implements Stack{
    private ArrayList<Object> data;

    public BasicStack(){
        data = new ArrayList<>();
    }

    @Override
    public void push(Object value) {
        data.add(value);
    }

    @Override
    public Object pop() {
        if (data.size() == 0){
            throw new IllegalStateException("No more item in stack");
        }

        int a = data.size() - 1;
        return data.remove(a);
    }

    @Override
    public boolean contain(Object value) {
        for(int i = 0; i < data.size(); i++)
            if(value.equals(data.get(i)))
                return true;
        
        return false;
    }

    @Override
    public Object search(Object value){
        while (data.size() > 0){
            Object tempValue = pop();
            if(value.equals(tempValue))
                return tempValue;
        }
        
        throw new IllegalStateException("Value not found in stack");
    }
    
    public String listItems(){
        return data.toString();
    }

    public int getSize() {
        return data.size();
    }


    public static void main(String[] args) {
        Stack basic = new BasicStack();
        basic.push("Queen of heart");
        basic.push("Ace of heart");
        basic.push("King of heart");

        System.out.println(basic.listItems());

        System.out.println();

        System.out.println("Size of stack: " + basic.getSize());

        System.out.println();

        System.out.println(basic.pop());

        System.out.println();

        System.out.println(basic.listItems());
        // System.out.println("Size of stack: " + basic.getSize());

        // System.out.println();

        // System.out.println("isFound: " + basic.contain("Ace of heart"));

        // System.out.println();

        // System.out.println("isFound: " + basic.contain("King of heart"));
    }

}