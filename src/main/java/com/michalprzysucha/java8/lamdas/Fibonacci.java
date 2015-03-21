package com.michalprzysucha.java8.lamdas;

import java.math.BigInteger;
import java.util.function.Supplier;

/**
 * @author Michal Przysucha
 * @since 2015-03-21
 */
public class Fibonacci implements Supplier<BigInteger> {
    private BigInteger f = BigInteger.ZERO;
    private BigInteger s = BigInteger.ONE;
    public BigInteger get() {
        BigInteger res = s;
        BigInteger tmp = f.add(s);
        f = s;
        s = tmp;
        return res;
    }
}
