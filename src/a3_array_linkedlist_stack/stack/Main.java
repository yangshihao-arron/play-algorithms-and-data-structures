package a3_array_linkedlist_stack.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        Deque<Integer> deque = new LinkedList<>();


    }
}
