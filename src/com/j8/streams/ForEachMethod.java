package com.j8.streams;

import java.util.ArrayList;

public class ForEachMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("BB");
        list.add("CCC");

        list.stream().forEach(value-> System.out.println(value));

        // where ever lambda expression is there, we can replace it with method reference.
        list.stream().forEach(System.out::println);
    }
}
