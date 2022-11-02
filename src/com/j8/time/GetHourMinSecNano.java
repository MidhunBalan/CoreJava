package com.j8.time;

import java.time.LocalTime;

public class GetHourMinSecNano {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        int h= time.getHour();
        int m= time.getMinute();
        int s= time.getSecond();
        int n= time.getNano();
        System.out.printf("%d:%d:%d:%d", h, m, s, n);
    }
}