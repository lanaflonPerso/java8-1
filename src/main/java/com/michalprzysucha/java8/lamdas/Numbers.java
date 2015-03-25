package com.michalprzysucha.java8.lamdas;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

/**
 * @author Michal Przysucha
 * @since 2015-03-19
 */
public class Numbers {

    private Fibonacci fibonacci;

    private void java7() {
    }

    private void java8() {
        Stream<Integer> oneTwoThree = Stream.<Integer>builder().add(1).add(2).add(3).build();
        oneTwoThree.forEach(System.out::println);
//        oneTwoThree.forEach(System.out::println); // IllegalStateException: stream has already been operated upon or closed
//        Stream.<Integer>iterate(0, i -> i + 1).forEach(System.out::println); // this will never ends
        Stream.<Integer>iterate(0, i -> i + 1).limit(1000).forEach(System.out::println);

        System.out.println("Fibonacci numbers:");
        Stream.generate(fibonacci).limit(100).forEach(System.out::println);

    }


    private void go() {
        java8();
    }

    public Numbers(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    public static void main(String[] args) {
        new Numbers(new Fibonacci()).go();
    }

}

