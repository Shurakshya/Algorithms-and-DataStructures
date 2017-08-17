/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalab6;

import java.util.Scanner;

/**
 *
 * @author shurakshyakharel
 */
public class LinkedList<T extends Comparable<T>> {
    private Node first;
    //private Node last;

    public LinkedList() {
        first = null;
        //last = null;
    }
    
    public void insert_to_end(T item){
        if(first != null){
            Node prev = first;
            while(prev.next != null){
                prev = prev.next;
            }
            prev.next = new Node(item, null);
        }else{
            first = new Node(item,null);
        }   
    }
    
    public void delete_first(){
        if(first != null){
            first = first.next;
        }
    }
    
    public void delete_last(){
        if(first != null){
            Node current = first;
            Node prev;
            prev = current;
            while(current.next  != null){
                prev = current;
                current = current.next;
            }
            if(first.next == null){
                first = null;
                
            }
            prev.next = null; 
        }
    }
    
    
    public int find_pos(T item){
        Node currentNode= first;
        int i = 0;
        int result = -1; 
        while (currentNode != null ) {
            if(currentNode.data != null && currentNode.data.compareTo(item) == 0){
                result = i;
            }
            currentNode = currentNode.next; 
            i++;
        } 
        return result;       
    }
    
    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override public String toString() {
        StringBuilder s = new StringBuilder();
        Node p = first;
        while (p != null) {
            s.append(p.data + " ");
            p = p.next;
        }
        
        return s.toString();
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<Character>(); 
        Scanner s = new Scanner(System.in);
        int order_no;
        char to_be_searched;
        try 
        {
            list.delete_last();
            list.insert_to_end('?');
            list.delete_last();
            list.insert_to_end('x');
            list.insert_to_end('a');
            list.insert_to_end('b');
            list.insert_to_end('c');
            list.insert_to_end('d');
            list.insert_to_end('y');
            System.out.println("List: " + list);
            System.out.print("Enter first character to be searced ? "); 
            to_be_searched = s.next().charAt(0);
            if ((order_no = list.find_pos(to_be_searched)) >= 0)
                System.out.println("The order no is " + order_no); 
            else
                System.out.println("Not found");
                System.out.print("Enter second character to be searced ? "); 
                to_be_searched = s.next().charAt(0);
            if ((order_no = list.find_pos(to_be_searched)) >= 0)
                System.out.println("The order no is " + order_no); 
            else
                System.out.println("Not found");
                list.delete_first();
                System.out.println("List: " + list);
                list.delete_last();
                System.out.println("List: " + list);
        }
        catch(Exception e)
        {
            System.out.println("Exception " + e);
        }
    }

}