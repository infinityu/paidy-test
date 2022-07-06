package com.paidy;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @created 2022/7/6
 */
public class SundayCounterTest {

    @Test
    public void countTest() {
        try {
            assertEquals(6, SundayCounter.count("03-07-2022", "08-08-2022"));
            assertEquals(6, SundayCounter.count("03-07-2022", "07-08-2022"));
            assertEquals(5, SundayCounter.count("02-07-2022", "06-08-2022"));
            assertEquals(5, SundayCounter.count("03-07-2022", "06-08-2022"));
            assertEquals(4, SundayCounter.count("04-07-2022", "06-08-2022"));
            assertEquals(0, SundayCounter.count("04-08-2022", "06-08-2022"));
            assertEquals(0, SundayCounter.count("25-07-2022", "30-07-2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
