package com.michalprzysucha.java8.lamdas.bytecode;

import java.util.function.Function;

/**
 * @author Michal Przysucha <michal.przysucha@proama.pl>
 * @since 05.05.2015 17:37:00
 */
public class Master7 {

    public void useSlave() {
        System.out.println(new Slave().doIt(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer o) {
                return 2 * o;
            }
        }, 10));
    }

}
