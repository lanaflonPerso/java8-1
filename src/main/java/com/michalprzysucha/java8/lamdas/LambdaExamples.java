package com.michalprzysucha.java8.lamdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Michal Przysucha
 * @since 2015-03-21
 */
public class LambdaExamples {

    interface MyAwesomeGenericInterface<T, R> {
        R myAwesomeMethod(T t);
        default String defMethod(String x) {
            return x + " :-)";
        }
    }

    interface MyAwesomeTypedInterface {
        Integer myAwesomeMethod(String t);
    }

    interface MyAwesomeTypedSecondInterface {
        Integer myAwesomeMethod(String t1, String t2);
    }


    interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }

    private void java7() {
        Function<Integer, Integer> f1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        };
        System.out.println(f1.apply(3));
        System.out.println(f1.apply(4));
        System.out.println(f1.apply(5));

        MyAwesomeGenericInterface<Double, Double> f2 = new MyAwesomeGenericInterface<Double, Double>() {
            @Override
            public Double myAwesomeMethod(Double aDouble) {
                return aDouble * aDouble * 3.14;
            }
        };
        System.out.println(f2.myAwesomeMethod(3d));
        System.out.println(f2.myAwesomeMethod(4d));
        System.out.println(f2.myAwesomeMethod(5d));

        MyAwesomeTypedInterface f3 = new MyAwesomeTypedInterface() {
            @Override
            public Integer myAwesomeMethod(String t) {
                return (t == null) ? 0 : t.length();
            }
        };
        System.out.println(f3.myAwesomeMethod("Jakis tekst"));
        System.out.println(f3.myAwesomeMethod("Lorem ipsum dolor sit amet"));
        System.out.println(f3.myAwesomeMethod("Ceska Pojistovna"));
    }

    private void java8() {
        Function<Integer, Integer> f1 = x -> x * 2;
        System.out.println(f1.apply(3));
        System.out.println(f1.apply(4));
        System.out.println(f1.apply(5));

        MyAwesomeGenericInterface<Double, Double> f2 = x -> x * x * 3.14;
        System.out.println(f2.myAwesomeMethod(3d));
        System.out.println(f2.myAwesomeMethod(4d));
        System.out.println(f2.myAwesomeMethod(5d));
        System.out.println(f2.defMethod("abcd"));

        MyAwesomeTypedInterface f3 = t -> (t == null) ? 0 : t.length();
        System.out.println(f3.myAwesomeMethod("Jakis tekst"));
        System.out.println(f3.myAwesomeMethod("Lorem ipsum dolor sit amet"));
        System.out.println(f3.myAwesomeMethod("Michal Przysucha"));

        MyAwesomeTypedSecondInterface f4 = (t1, t2) -> f3.myAwesomeMethod(t1) + f3.myAwesomeMethod(t2);
        System.out.println(f4.myAwesomeMethod("Jakis tekst", "Lorem ipsum dolor sit amet"));

        Predicate<String> f5 = t -> t != null && !t.isEmpty();
        System.out.println(f5.test("Jakis tekst"));
        System.out.println(f5.test(" "));
        System.out.println(f5.test(""));
        System.out.println(f5.test(null));

        Consumer<String> f6 = t -> System.out.println(t);
        f6.accept("Michal Przysucha");

        Supplier<Integer> f7 = () -> 1 + (int) (Math.random() * 1000);
        System.out.println(f7.get());
        System.out.println(f7.get());
        System.out.println(f7.get());
        System.out.println(f7.get());

        BiFunction<Double, Double, Double> f8 = (a, b) -> Math.sqrt(a * a + b * b);
        System.out.println(f8.apply(3d, 4d));

        TriFunction<Double, Double, Double, Double> f9 = (a, b, c) -> {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        };

        System.out.println(f9.apply(3d, 4d, 5d));

    }

    private void go() {
        java7();
        java8();
    }

    public static void main(String[] args) {
        new LambdaExamples().go();
    }

}
