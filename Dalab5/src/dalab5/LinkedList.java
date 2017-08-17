/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalab5;

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
    public void add(T item){
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
        
        list.add('a');     
        list.add('b');
        list.add('c');
        list.add('d'); 
        //list.add('e');
        
        System.out.println("List: " + list);
    }
}