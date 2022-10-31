package com.j8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapMethod {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

        // without streams: multiply every value by 2
        List<Integer> list1= new ArrayList<>();
        for(Integer value: list){
            list1.add(value* 2);
        }
        System.out.println("Output without stream map method"+list1);

        List<Integer> list2 = list.stream().map(value -> value*2).collect(Collectors.toList());
        System.out.println("Output with stream map method"+list2);

    }
}
