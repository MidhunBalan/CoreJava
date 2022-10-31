package com.j8.streams;

import java.util.ArrayList;

public class MinAndMaxMethods {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

        Integer min = list.stream().min((value1, value2)-> value1.compareTo(value2)).get();
        System.out.println("Minimum value "+min);

        Integer max = list.stream().max((value1, value2)-> value1.compareTo(value2)).get();
        System.out.println("Maximum value "+max);
    }
}
