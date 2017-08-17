/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalab9;

import java.io.Serializable;

/**
 *
 * @author shurakshyakharel
 */
public class Student implements Comparable<Student>, Serializable{
    private String firstName;
    private String lastName;
    private int age;
    private float grade;
    
    
    public Student(String newFirstName, String newLastName, int newAge , float newGrade){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.age = newAge;
        this.grade = newGrade;       
    }
    
    @Override
    public String toString(){
        return this.firstName + " "+ this.lastName + " "+ this.age +" "+ this.grade;
    }

    @Override
    public int compareTo(Student o) {
        if(!firstName.equals(o.firstName) || !lastName.equals(o.lastName)){
            if (age >= o.age){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            return 0;
        }
        

    }
    
}
