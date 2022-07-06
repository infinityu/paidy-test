package com.paidy;

import com.paidy.informationmask.EmailMask;
import com.paidy.informationmask.IMask;
import com.paidy.informationmask.MaskManager;
import com.paidy.informationmask.PhoneNumberMask;

/**
 * @created 2022/7/6
 */
public class PersonalInformationMask {

  private MaskManager maskManager;

  public PersonalInformationMask() {
    IMask emailMask = new EmailMask();
    IMask phoneNumberMask = new PhoneNumberMask();
    maskManager = new MaskManager(emailMask, phoneNumberMask);
  }

  public String execute(String input) {
    return maskManager.execute(input);
  }
}
