package com.j8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedMethodCustomized {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

        List<Integer> list1 = list.stream().sorted((value1, value2)->value2.compareTo(value1)).collect(Collectors.toList());
        System.out.println("List according to the customized sorting"+list1);
    }
}
