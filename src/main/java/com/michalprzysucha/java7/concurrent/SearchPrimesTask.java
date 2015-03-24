package com.michalprzysucha.java7.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Michal Przysucha
 * @since 2015-03-24
 */
public class SearchPrimesTask extends RecursiveTask<List<Integer>> {

    int min, max;

    SearchPrimesTask(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    protected List<Integer> compute() {
        List<Integer> res = new ArrayList<>();
        if (max - min > 1_000) {
            SearchPrimesTask task1 = new SearchPrimesTask(min, (min + max) / 2);
            SearchPrimesTask task2 = new SearchPrimesTask((min + max) / 2 + 1, max);
            task1.fork();
            task2.fork();
            res.addAll(task1.join());
            res.addAll(task2.join());
        } else {
            for (int i = min; i <= max; i++) {
                if (isPrime(i)) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        List<Integer> primes = forkJoinPool.invoke(new SearchPrimesTask(1, 1_000_000));
        for (Integer prime : primes) {
            System.out.print(prime + ", ");
        }
        System.out.println();
    }

    public static boolean isPrime(int x) {
        boolean isPrime = x >= 2;
        int i;
        for (i = 2; isPrime && i <= x / 2; i++) {
            if (x % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

}
