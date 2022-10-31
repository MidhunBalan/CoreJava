package com.j8.streams;

import java.util.stream.Stream;

public class StreamOfMethod {
    public static void main(String[] args) {
        // for group of objects
        Stream<Integer> s = Stream.of(9, 99, 999, 9999, 99999);
        s.forEach(System.out::println);  // or s.forEach(value-> System.out.println(value));

        // for arrays

        Double[] doubleArray = {100.00, 101.00, 102.00, 103.00, 104.00};
        Stream<Double> s1 = Stream.of(doubleArray);
        s1.forEach(System.out::println);// or s1.forEach(value-> System.out.println(value));

    }
}
