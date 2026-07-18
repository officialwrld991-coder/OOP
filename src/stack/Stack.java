package stack;

import java.util.EmptyStackException;

public class Stack {

    private String[] elements;
    private int counter;
    private int size;


    public void createArray(int number) {
        this.size = number;
        elements = new String[number];
    }

    public boolean isEmpty() {
       if(counter > 0) {
         return false;
            }
        return true;

    }

    public void push(String items) {

        if(counter >= size) {
            throw new IllegalStateException("Stack is full");
        }

        this.elements[counter++] = items;

    }

    public String pop() {

        if (counter <= 0) {
            throw new EmptyStackException();
        }
        return elements[--counter];

    }

    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[counter-1];
    }
}
