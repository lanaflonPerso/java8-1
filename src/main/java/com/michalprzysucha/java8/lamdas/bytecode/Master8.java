package com.michalprzysucha.java8.lamdas.bytecode;

import java.util.function.Function;

/**
 * @author Michal Przysucha <michal.przysucha@proama.pl>
 * @since 05.05.2015 17:37:00
 */
public class Master8 {

    public void useSlave() {
        System.out.println(new Slave().doIt(o -> 2 * o, 10).intValue());
    }

}
