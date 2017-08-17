/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binstree;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author shurakshyaKharel
 */
public class BinSTree<T extends Comparable<T>> {
    private Node root;
    private int count = 0;
    
    public BinSTree(){
        root = null;
    }
    
    
    public void insert_to_tree(T item){
        Node newNode = new Node(item);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(item.compareTo(current.data) == -1){				
                current = current.leftChild;
                if(current==null){
                        parent.leftChild = newNode;
                        return;
                }
            }else {
                current = current.rightChild;
                if(current==null){
                        parent.rightChild = newNode;
                        return;
                }
            }
        }
    }
    
    public boolean isInTree(T item){
        count = 0;
        Node current = root;
        while(current != null){
            if(current.data.compareTo(item) == 0){
                return true;
                
            }else if(current.data.compareTo(item) == 1){
                current = current.leftChild;
                
            }else{
                current = current.rightChild;
                
            }
            this.count++;          
        }
        return false;
    }
    
   /* public void display(Node root){
        if(root!=null){
                display(root.leftChild);
                System.out.print(" " + root.data);
                display(root.rightChild);
        }
    } */
    
    private class Node {
        private T data;
        Node leftChild;
        Node rightChild;

        Node(T data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BinSTree<Integer> bst = new BinSTree<Integer>();
        for(int i = 0; i <10000; i++){
            Random r = new Random();
            int val  = r.nextInt(10000)+ 1;
            bst.insert_to_tree(val);
        }
        Scanner reader = new Scanner(System.in);
        
       for(int j =0 ; j<5 ; j++){
            System.out.println("Enter the number to search");
            int to_be_search = Integer.parseInt(reader.nextLine());        
           if(bst.isInTree(to_be_search)){
               System.out.println("Item found");
               int num = bst.count;
               System.out.println("The comparisions made were : " + num);
           }else{
               System.out.println("Item not found");
               int num = bst.count;
               System.out.println("The comparisions made were : " + num);
           }
        }  
        
    }
    
}
