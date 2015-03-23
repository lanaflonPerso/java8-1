package com.michalprzysucha.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Michal Przysucha
 * @since 2015-03-24
 */
public class Basics {

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.from(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = LocalDateTime.of(2010, 1, 1, 11, 30);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = LocalDateTime.of(2010, 1, 1, 11, 29, 59);
        System.out.println(localDateTime4);

        LocalDate localDate4 = localDateTime4.toLocalDate();
        System.out.println(localDate4);

        LocalTime localTime4 = localDateTime4.toLocalTime();
        System.out.println(localTime4);
    }

}
