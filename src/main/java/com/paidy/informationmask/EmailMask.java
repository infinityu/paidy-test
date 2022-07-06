package com.paidy.informationmask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @created 2022/7/6
 */
public class EmailMask implements IMask {

  /** Regular Expression by RFC 5322 for Email Validation */
  public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile(
          "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", Pattern.CASE_INSENSITIVE);

  public static final String REPLACEMENT = "*****";
  public static final String AT_SIGN = "@";

  @Override
  public boolean isValid(String input) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(input);
    return matcher.find();
  }

  @Override
  public String execute(String input) {
    String[] emailParts = input.split(AT_SIGN);
    String localPart = emailParts[0].toLowerCase();
    String domain = emailParts[1];
    String prefix = String.valueOf(localPart.charAt(0));
    String postfix = String.valueOf(localPart.charAt(localPart.length() - 1));
    return prefix.concat(REPLACEMENT).concat(postfix).concat(AT_SIGN).concat(domain);
  }
}
