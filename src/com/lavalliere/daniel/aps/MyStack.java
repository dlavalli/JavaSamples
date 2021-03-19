package com.lavalliere.daniel.aps;

public class MyStack<T> {
    private String[] stack;
    private int head;
    public MyStack(int size) {
        stack = new String[size];
        head = -1;
    }

    public void push(String value) {
        if (head == stack.length) {
            System.out.printf("Stack is full, cannot push %s\n", value);
        }
        head++;
        stack[head] = value;
    }

    public String pop() {
        if (head <= -1) {
            System.out.printf("Stack is empty, nothing to pull %s\n");
        }
        String value = stack[head];
        head--;
        if (head < -1) head = -1;
        return value;
    }
}
