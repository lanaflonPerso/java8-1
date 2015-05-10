package com.michalprzysucha.java8.lamdas.bytecode;

import java.util.function.Function;

/**
 * @author Michal Przysucha <michal.przysucha@proama.pl>
 * @since 05.05.2015 17:33:00
 */
public class Slave {

    public <T, R> R doIt(Function<T, R> instructions, T object) {
        return instructions.apply(object);
    }

}
