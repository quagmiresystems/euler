package com.quagmiresystems.euler;

/**
 *
 *
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November. All the rest have
 * thirty-one, Saving February alone, Which has twenty-eight, rain or shine. And on leap years,
 * twenty-nine. A leap year occurs on any year evenly divisible by 4, but not on a century unless it
 * is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31
 * Dec 2000)?
 * 
 */
public class Problem019CountingSundays {

  static int sundayCount = 0;
  static int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  static int yearMonths = 12;

  private static boolean isLeapYear(int year) {
    return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
  }

  private static class Date {

    int year, month, day;

    void next() {
      day += 7;
      if (day > daysInMonth(this)) {
        day = day % daysInMonth(this);
        month++;
      }

      if (month > yearMonths) {
        month = month % yearMonths;
        year++;
      }
    }

    int daysInMonth(Date d) {
      if (month == 2 && isLeapYear(d.year)) {
        return 29;
      } else {
        return monthDays[d.month];
      }
    }

    void print() {
      System.out.println(year + "-" + month + "-" + day);
    }
  }

  public static void main(String[] args) {
    Date d = new Date();
    d.year = 1900;
    d.month = 1;
    d.day = 7;
    while (d.year <= 2001) {
      d.print();
      d.next();
      if (d.day == 1 && d.year > 1900 && d.year < 2001) {
        sundayCount++;
      }
    }
    System.out.println(sundayCount);
  }

}
