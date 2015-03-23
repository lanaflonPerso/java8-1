package com.michalprzysucha.java8.datetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Michal Przysucha
 * @since 2015-03-23
 */
public class ChangingTime {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        localDateTime = localDateTime.plusDays(2);
        System.out.println(localDateTime);

        localDateTime = localDateTime.plusHours(17);
        System.out.println(localDateTime);

        localDateTime = localDateTime.minus(17, ChronoUnit.HOURS);
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = localDateTime.minus(1, ChronoUnit.NANOS);
        System.out.println(localDateTime2.isBefore(localDateTime));
    }

}
