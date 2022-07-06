package com.paidy;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

/**
 * @created 2022/7/6
 */
public class SundayCounter {

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  public static int count(String date_from, String date_to) throws ParseException {
    LocalDate from = LocalDate.parse(date_from, formatter);
    LocalDate to = LocalDate.parse(date_to, formatter);

    // find the first sunday in the month of `date_from`
    // and locate to the first sunday between `date_from` and `date_to`
    LocalDate sunday = from.with(firstInMonth(DayOfWeek.SUNDAY));
    while (sunday.isBefore(from)) {
      sunday = sunday.plus(Period.ofDays(7));
    }

    // do the counting every 7 days till `date_to` inclusively
    int count = 0;
    while (!sunday.isAfter(to)) {
      count++;
      sunday = sunday.plus(Period.ofDays(7));
    }
    return count;
  }
}
