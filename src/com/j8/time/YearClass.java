package com.j8.time;

import java.time.Year;

public class YearClass {
    public static void main(String[] args) {
        int y = 1996;
        Year year = Year.of(y);
        if(year.isLeap()){
            System.out.println("It is a leap year");
        }else{
            System.out.println("It is not a leap year");
        }
    }
}
