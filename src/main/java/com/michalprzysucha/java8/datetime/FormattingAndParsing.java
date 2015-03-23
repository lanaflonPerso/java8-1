package com.michalprzysucha.java8.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Michal Przysucha
 * @since 2015-03-23
 */
public class FormattingAndParsing {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

        LocalDateTime ldt = LocalDateTime.parse("10:10:50 02-05-2015", dtf);
        System.out.println(ldt.minusMinutes(10));

        LocalDateTime ldtNow = LocalDateTime.now();
        System.out.println(ldtNow.plusDays(1).format(dtf));
    }

}
