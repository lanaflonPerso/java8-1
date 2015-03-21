package com.michalprzysucha.java8.lamdas;


import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Michal Przysucha
 * @since 2015-03-19
 */
public class Numbers {

    private Fibonacci fibonacci;

    private void java8() {
        Stream<Integer> oneTwoThree = Stream.<Integer>builder().add(1).add(2).add(3).build();
        oneTwoThree.forEach(System.out::println);
//        oneTwoThree.forEach(System.out::println); // stream has already been operated upon or closed
//        Stream.<Integer>iterate(0, i -> i + 1).forEach(System.out::println); // never ends
        Stream.<Integer>iterate(0, i -> i + 1).limit(1000).forEach(System.out::println);

//        Stream.generate(fibonacci).limit(100).forEach(System.out::println);


        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.submit(() -> {
            IntStream.range(1, 1_000_000).boxed().filter(Numbers::isPrime).limit(100).collect(Collectors.toList());
        });

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

    public static boolean isPrime(int x) {
        boolean isPrime = x >= 2;
        int i;
        for (i = 2; isPrime && i <= x / 2; i++) {
            if (x % i == 0) {
                isPrime = false;
            }
        }
        System.out.println(x + " is " + (isPrime ? "" : "not ") + " a prime, num of iters: " + (i - 1));
        return isPrime;
    }

}

