package com.j8.time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate birthday= LocalDate.of(1992, 8, 4);
        LocalDate today= LocalDate.now();
        Period period= Period.between(birthday, today);
        System.out.println(period.getYears()+"-"+ period.getMonths()+"-"+ period.getDays());
    }
}
