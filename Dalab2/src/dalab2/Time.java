package dalab2;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shurakshyakharel
 */
public class Time implements Comparable<Time>{ 
    private int hour;
    private int minute;
    Scanner reader = new Scanner(System.in);
    
    public Time(){
        
    }
    
    public Time(int newHour , int newMinute){
        this.hour = newHour;
        this.minute = newMinute;
    }

    public void read(String initialWord){
        System.out.println(initialWord);
        String time1 = reader.nextLine();
        String [] result = time1.split(":");
        this.hour = Integer.parseInt(result[0]);
        this.minute =Integer.parseInt(result[1]);
    }

    public boolean lessThan(Time t) {
        if (this.hour < t.hour){
            System.out.println("hour less");
            return true;
        }
        if(this.hour == t.hour && this.minute < t.minute){
            System.out.println("minute less");
            return true;          
        }
        System.out.println("greater");
        return false;
   }

    public Time subtract(Time t) {
        int minDiff = 0;
        int hourDiff = 0;
        Time time = new Time(this.hour , this.minute);
            if(t.minute < time.minute){
                minDiff = Math.abs(t.minute - time.minute);
                hourDiff =Math.abs(t.hour - time.hour);
        }else{
                minDiff = 60 - Math.abs(time.minute - t.minute);
                hourDiff = Math.abs(time.hour-t.hour- 1);
            }    
        
        Time duration = new Time(hourDiff , minDiff);
        return duration;
        
    }

    @Override
    public String toString() {
      return this.hour + ":" + this.minute;
    }

    @Override
    public int compareTo(Time time) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Integer.compare(this.hour*60+this.minute, time.hour*60+time.minute);
    }
}
