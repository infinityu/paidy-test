package com.paidy.informationmask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @created 2022/7/6
 */
public class PhoneNumberMask implements IMask {

  public static final Pattern VALID_PHONE_NUMBER_REGEX =
      Pattern.compile(
          "^(\\+?\\d{1,2}\\s)?\\(?\\d{1,3}\\)?[\\s.-]?\\d{3,4}[\\s.-]?\\d{3,4}$",
          Pattern.CASE_INSENSITIVE);

  public static final char REPLACEMENT_HYPHEN = '-';
  public static final char REPLACEMENT_ASTERISK = '*';

  @Override
  public boolean isValid(String input) {
    char[] nums = input.toCharArray();

    // as it is required that a phone number consists of at least 9 digits
    int count = 0;
    for (char n : nums) {
      if (Character.isDigit(n)) {
        count++;
      }
    }
    if (count < 9) {
      return false;
    }

    Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(input);
    return matcher.find();
  }

  @Override
  public String execute(String input) {
    String hyphened = input.replace(' ', REPLACEMENT_HYPHEN);

    char[] nums = hyphened.toCharArray();
    int digitOffSet = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (!Character.isDigit(nums[i])) {
        continue;
      }
      if (digitOffSet < 4) {
        digitOffSet++;
      } else {
        nums[i] = REPLACEMENT_ASTERISK;
      }
    }
    return String.valueOf(nums);
  }
}
