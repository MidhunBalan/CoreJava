package com.j8.time;

import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeClass {
    public static void main(String[] args) {
        LocalDateTime dateTime= LocalDateTime.now();
        System.out.println(dateTime);

        int dd = dateTime.getDayOfMonth();
        int mm = dateTime.getMonthValue();
        int yyyy = dateTime.getYear();
        System.out.printf("%d-%d-%d",dd,mm, yyyy);

        int h = dateTime.getHour();
        int m = dateTime.getMinute();
        int s = dateTime.getSecond();
        int n= dateTime.getNano();
        System.out.printf("\n%d-%d-%d-%d",h,m,s,n);

        LocalDateTime dt = LocalDateTime.of(1995, Month.MAY, 28, 12, 45);
        System.out.println("\n"+dt);
    }
}
