package com.michalprzysucha.java8.lamdas;

import java.math.BigInteger;
import java.util.function.Supplier;

/**
 * @author Michal Przysucha
 * @since 2015-03-21
 */
public class Fibonacci implements Supplier<BigInteger> {
    private BigInteger f = BigInteger.ONE;
    private BigInteger s = BigInteger.ZERO;
    public BigInteger get() {
        s = f.add(s);
        f = s.subtract(f);
        return s;
    }
}
