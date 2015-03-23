package com.michalprzysucha.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Michal Przysucha
 * @since 2015-03-23
 */
public class DateConversions {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();

        /** To convert between LocalDateTime and Date, an Instant and a ZoneId must be used */

        System.out.println(ZoneId.systemDefault());

        Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date date2 = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(date1);
        System.out.println(date2);

        Date dateNow = new Date();
        System.out.println(dateNow);
        System.out.println(dateNow.toInstant());
        System.out.println(LocalDateTime.ofInstant(dateNow.toInstant(), ZoneId.systemDefault()));
        System.out.println(LocalDateTime.ofInstant(dateNow.toInstant(), ZoneId.systemDefault()).toLocalDate());
        System.out.println(LocalDateTime.ofInstant(dateNow.toInstant(), ZoneId.systemDefault()).toLocalTime());


        /** What about Calendar? */

        Calendar calendar = Calendar.getInstance();
        calendar.toInstant();

        //Calendar.from // there's no from method
    }

}
