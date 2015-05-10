package com.michalprzysucha.java8.lamdas.bytecode;

/**
 * @author Michal Przysucha <michal.przysucha@proama.pl>
 * @since 05.05.2015 17:37:00
 */
public class MasterAndSlave {

    public static void main(String[] args) {
        new Master7().useSlave();
        new Master8().useSlave();
    }

}
