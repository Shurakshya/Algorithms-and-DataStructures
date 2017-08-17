/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalab9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author shurakshyakharel
 */
public class StudentRegister implements Serializable{
    private TreeSet<Student> records;
    private Scanner reader;
    
    public StudentRegister(){
        this.records = new TreeSet<Student>();
        this.reader = new Scanner(System.in);
    }
    
    public void services(){
        while(true){
            System.out.println("Please enter any command : ADD, LIST, SAVE, LOAD, EXIT");
            String input = reader.nextLine();
            String[] array = input.split(" ");
            String command = array[0];
            
            if(command.equalsIgnoreCase("Add")){
                String fName = array[1];
                String lName = array[2];
                int age = Integer.parseInt(array[3]);
                float grade = Float.parseFloat(array[4]);
                Student student = new Student(fName, lName, age , grade);
                this.records.add(student); 
            }else if(command.equalsIgnoreCase("list")){
                for (Student s: records){
                    System.out.println(s);  
                } 
            }else if(command.equalsIgnoreCase("save")){
                try{
                    FileOutputStream fos = new FileOutputStream("studentRegister");
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(records);
                    oos.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }else if(command.equalsIgnoreCase("load")){
                try{
                    FileInputStream fis = new FileInputStream("studentRegister");
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    records =(TreeSet) ois.readObject();
                    ois.close(); 
                   
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(command.equalsIgnoreCase("Exit")){
                break;
            }    
        }
    }   
}
