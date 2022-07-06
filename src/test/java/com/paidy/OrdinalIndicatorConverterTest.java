package com.paidy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @created 2022/7/5
 */
public class OrdinalIndicatorConverterTest {

  @Test
  void convertTest() {
    assertEquals("1st", OrdinalIndicatorConverter.convertOrdinal(1));
    assertEquals("2nd", OrdinalIndicatorConverter.convertOrdinal(2));
    assertEquals("3rd", OrdinalIndicatorConverter.convertOrdinal(3));
    assertEquals("4th", OrdinalIndicatorConverter.convertOrdinal(4));
    assertEquals("10th", OrdinalIndicatorConverter.convertOrdinal(10));
    assertEquals("11th", OrdinalIndicatorConverter.convertOrdinal(11));
    assertEquals("12th", OrdinalIndicatorConverter.convertOrdinal(12));
    assertEquals("13th", OrdinalIndicatorConverter.convertOrdinal(13));
    assertEquals("21st", OrdinalIndicatorConverter.convertOrdinal(21));
    assertEquals("22nd", OrdinalIndicatorConverter.convertOrdinal(22));
    assertEquals("23rd", OrdinalIndicatorConverter.convertOrdinal(23));
    assertEquals("100th", OrdinalIndicatorConverter.convertOrdinal(100));

    assertThrows(
        IllegalArgumentException.class,
        () -> assertEquals("-1st", OrdinalIndicatorConverter.convertOrdinal(-1)));
  }
}
