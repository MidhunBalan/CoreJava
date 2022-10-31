package com.j8.streams;

import java.util.ArrayList;
import java.util.Arrays;

public class ToArrayMethod {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);

        Integer[] array2 = list.stream().toArray(value -> new Integer[value]);
        System.out.println(Arrays.toString(array2));

        Integer[] array = list.stream().toArray(Integer[] :: new);
        System.out.println(Arrays.toString(array));

    }
}
