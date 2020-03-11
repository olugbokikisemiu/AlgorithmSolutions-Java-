package datastructure.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack
 */
public interface Stack {
    public void push(Object value);
    public Object pop();
    public boolean contain(Object value);
    public Object search(Object value);
    public String listItems();
    public int getSize();
}