package com.paidy;

/**
 * @created 2022/7/5
 */
public class OrdinalIndicatorConverter {
  public static String convertOrdinal(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException();
    }

    return Integer.toString(number).concat(determineOrdinalSuffix(number));
  }

  private static String determineOrdinalSuffix(int number) {
    if (isSpecialCase(number)) {
      return "th";
    }

    int lastDigit = number % 10;
    switch (lastDigit) {
      case 1:
        return "st";
      case 2:
        return "nd";
      case 3:
        return "rd";
      default:
        return "th";
    }
  }

  /**
   * 11th – eleventh
   * 12th – twelfth
   * 13th – thirteenth
   *
   * @param n
   * @return
   */
  private static boolean isSpecialCase(int n) {
    return 13 >= n && n >= 11;
  }
}
