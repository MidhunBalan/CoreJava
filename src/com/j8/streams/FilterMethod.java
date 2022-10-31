package com.j8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMethod {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);
        System.out.println(list);

        // without streams: find only even numbers
        List<Integer> list1 = new ArrayList<>();
        for(Integer value: list){
            if(value % 2 == 0){
                list1.add(value);
            }
        }
        System.out.println("Even number from the list without streams"+list1);

        // with streams: find only even numbers
        List<Integer> list2 = list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
        System.out.println("Even number from the list with streams"+list2);
    }
}
