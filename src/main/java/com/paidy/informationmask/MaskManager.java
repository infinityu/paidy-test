package com.paidy.informationmask;

import java.util.Arrays;
import java.util.List;

/**
 * @created 2022/7/6
 */
public class MaskManager {
  public static String ERR_MSG = "invalid email or phone number";

  private List<IMask> masks;

  public MaskManager(IMask... masks) {
    this.masks = Arrays.asList(masks);
  }

  public String execute(String input) {
    for (IMask mask : this.masks) {
      if (mask.isValid(input)) {
        return mask.execute(input);
      }
    }
    throw new IllegalArgumentException(ERR_MSG);
  }
}
