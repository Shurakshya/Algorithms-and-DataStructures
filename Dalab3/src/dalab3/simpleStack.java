/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalab3;

import java.io.IOException;

/**
 *
 * @author shurakshyakharel
 */
public class simpleStack<T extends Comparable<T>> {
    private static final int MAXN = 10;
    private int top;
    private T[] array;
    
    public simpleStack() {
        top = -1;
        array = (T[])new Comparable[MAXN];
    }

    public boolean push(T item) {
        if (top >= MAXN-1)
            return false;
        else
            array[++top] = item;
            return true;
    }

    public T pop() {
        if (top == -1)
            return null;
        else
            return array[top--];
    }

    public void print() {
        for (int i = top; i >= 0; i--)
            System.out.print(array[i] + " ");
    }
    
    public static void main(String[] args) throws IOException {
        simpleStack<Character> stack = new simpleStack();
        Character             item;

        System.out.println("Enter a letter to push onto stack");
        System.out.println("or digit 1 to take a letter from stack");
        System.out.println("Return to end the program\n");
        try{
            item = new Character((char)System.in.read());
            while (item.compareTo(new Character('\n')) != 0) {
                if(item.compareTo('+') == 0){
                int num1= Character.getNumericValue(stack.pop());
                int num2= Character.getNumericValue(stack.pop());
                int result=num1+num2;
                char c=Integer.toString(result).charAt(0);
                stack.push(c);
                
                }else if(item.compareTo('-') == 0){
                int num1= Character.getNumericValue(stack.pop());
                int num2= Character.getNumericValue(stack.pop());
                int result=num2-num1;
                char c=Integer.toString(result).charAt(0);
                stack.push(c);
                }else if(item.compareTo('=') == 0){
                    Character character=stack.pop();
                    System.out.println("The topmost value is  "+character);
                    stack.push(character);
                }else if(item.compareTo('Q') == 0){
                    stack.print();
                }else
                    stack.push(item);
                    System.out.print("Stack content: "); 
                    stack.print(); 
                    System.out.println();
                    item = (char)System.in.read();    
            }      
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
