package com.paidy.informationmask;

/**
 * @created 2022/7/6
 */
public interface IMask {
  boolean isValid(String input);
  String execute(String input);
}
