package com.michalprzysucha.java8.lamdas;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author Michal Przysucha
 * @since 2015-03-18
 */
public class LambdaExamples {

    private void java8() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(numbers.stream().map(x -> 2 * x).filter(x -> x % 3 != 0).collect(Collectors.toList()));

        isPrime(19);
        isPrime(21);
        isPrime(77);
        System.out.println("------------------");
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().filter(this::isPrime);
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().filter(this::isPrime).collect(Collectors.toList());
//        IntStream.range(1000, 10000).filter(this::isPrime).boxed().collect(Collectors.toList());
        IntStream.range(1000, 10000).filter(this::isPrime).boxed().findFirst().get();
//        IntStream.range(1000, 10000).filter(this::isPrime).findFirst().getAsInt();
        System.out.println("------------------");

        IntStream aaa1 = IntStream.range(1000, 10000).filter(this::isPrime);
        OptionalInt aaa2 = IntStream.range(1000, 10000).filter(this::isPrime).findFirst();

        Stream<Integer> aaa3 = IntStream.range(1000, 10000).filter(this::isPrime).boxed();
        Optional<Integer> aaa4 = IntStream.range(1000, 10000).filter(this::isPrime).boxed().findFirst();
    }

    private boolean isPrime(int x) {
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

    private void go() {
        java8();
    }

    public static void main(String[] args) {
        new LambdaExamples().go();
    }

}
